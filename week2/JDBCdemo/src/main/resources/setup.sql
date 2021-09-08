  
-- This is the script where I'm going to create the tables for my app

--DROP TYPE IF EXISTS ivonnea.user_role CASCADE;
CREATE TYPE ivonnea.user_role AS ENUM ('ADMIN', 'EMPLOYEE', 'CUSTOMER');

-- This is just a demo of JDBC connection, and YOUR projhect 0 script does not need to be exactly like this

--DROP TABLE IF EXISTS ivonnea.users CASCADE;
CREATE TABLE ivonnea.users(
	
	-- it does NOT need to be the same name as your User.java instance variables
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL,
	user_role ivonnea.user_role NOT NULL
);

--DROP TABLE IF EXISTS ivonnea.accounts CASCADE;
CREATE TABLE ivonnea.accounts (
	id SERIAL PRIMARY KEY,
	balance NUMERIC(50, 2) DEFAULT 0,
	acc_owner INTEGER NOT NULL REFERENCES ivonnea.users(id),
	active BOOLEAN DEFAULT FALSE -- this IS determining whether the account has been activated
);

-- This is demonstrating a MANY to MANY relationship....
--DROP TABLE IF EXISTS ivonnea.users_account_jt CASCADE;
CREATE TABLE ivonnea.users_account_jt (
	acc_owner INTEGER NOT NULL REFERENCES ivonnea.users(id),
	account INTEGER NOT NULL REFERENCES ivonnea.accounts(id)
);

-- this table represents pending applications of users who want to open an account
--DROP TABLE IF EXISTS ivonnea.applications CASCADE;
CREATE TABLE ivonnea.applications (
	id SERIAL PRIMARY KEY,
	app_owner INTEGER NOT NULL REFERENCES ivonnea.users(id)
);

SELECT * FROM ivonnea.users;

-- When you truncate a table, you remove all of the data inside of it, without
-- actually deleting the table itself.
TRUNCATE TABLE ivonnea.users CASCADE;


-- We need to trigger an insert of the necessary data INTO the users_account_jt,
-- WHENEVER an account is inserted into the accounts table

SELECT * FROM ivonnea.users_account_jt;

/*
PL/pgSQL procedural language adds many procedural elements, 
e.g., control structures, loops, and complex computations, 
to extend standard SQL. It allows you to insert elements automatically into a table...
*/

/*
	PL/pgSQL = Procedural Language extension of PostgreSQL
	
		- NOT A SUBLANGUAGE OF SQL!
		- Allows devs to create:
			- stored functions (returns a result)
			- stored procedures (since postgres 11)
			- triggers
			- custom types
			
		- Adds procedural features to the normally declarative SQL scripts
			- loops
			- exception handling
			- if statements
			
*/

/*
	Stored Functions
	
		create [or replace] function [name] (params)
		returns [type]
		as '
			begin
				[logic]
			end
		'
		language plpgsql;
*/

-- Create the function to insert elements of a new ACCOUTN recorD into the
-- THE users_account_jt table
CREATE OR REPLACE FUNCTION ivonnea.auto_insert_into_jt() RETURNS TRIGGER AS
$BODY$
BEGIN
	
	INSERT INTO
		ivonnea.users_account_jt(acc_owner, account)
		VALUES(NEW.acc_owner, NEW.id);
	
			RETURN NEW;
END
$BODY$
LANGUAGE plpgsql;

-- set the trigger so that every time a new row is inserted into the ACCOUNTS
-- table, it automatically populates the users_accounts_jt table;
CREATE TRIGGER trig
	AFTER INSERT ON ivonnea.accounts 
	FOR EACH ROW
	EXECUTE PROCEDURE ivonnea.auto_insert_into_jt();

SELECT * FROM ivonnea.users;
SELECT * FROM ivonnea.accounts;
SELECT * FROM ivonnea.users_account_jt;

TRUNCATE TABLE ivonnea.users CASCADE;
TRUNCATE TABLE ivonnea.accounts CASCADE;


INSERT INTO ivonnea.users(username, pwd, user_role) 
	VALUES ('Larry', 'secret', 'Employee'),
			('Mary', '1234', 'Customer'),
			('Bary', 'pass', 'Customer');


INSERT INTO ivonnea.accounts (balance, acc_owner)
	VALUES (100, 4),  -- Larry's ID IS 4
		   (200, 5), -- Mary's ID IS 5
		   (2000, 5), -- Mary's ID IS 5
		    (300, 6); -- Bary's ID IS 6


-- This query is literally pulling from the users_account_jt table to select all accounts owned by a aprticualr user
-- JOIN from the accounts table and the users_account_jt WHERE the accowner_id is the same as the userId
SELECT ivonnea.accounts.id, ivonnea.accounts.balance FROM ivonnea.accounts
	INNER JOIN ivonnea.users_account_jt 
		ON ivonnea.accounts.id = ivonnea.users_account_jt.account	
			WHERE ivonnea.users_account_jt.acc_owner = 5;
-- The above query helps use find all the accounts that belong to a specific owner based on their ID
