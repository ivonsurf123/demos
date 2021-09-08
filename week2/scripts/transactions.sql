CREATE TABLE bank_accounts (
	cust_name VARCHAR(50),
	balance NUMERIC(50, 2)
);

INSERT INTO bank_accounts (cust_name, balance)
	VALUES ('Alice', 100),
			('Bob', 50),
			('Sam', 0);
			
SELECT * FROM bank_accounts;

-- what happens if alice sends bob $50?
UPDATE bank_accounts SET balance = balance - 50 WHERE cust_name = 'Alice';
-- what would happen if I lost electricity in between!??!
UPDATE bank_accounts SET balance = balance + 50 WHERE cust_name = 'Bob';

-- A Transaction is a unit of work to be performed against a DB 
-- that follows a certain set of priciples (A.C.I.D)
-- TCL - Transaction Control Language
BEGIN;
	
	UPDATE bank_accounts SET balance = balance - 50 WHERE cust_name = 'Alice';

	SAVEPOINT my_savepoint;
	-- SAVEPOINTS allow you to selectively discard parts of the transaction while committing the rest

	UPDATE bank_accounts SET balance = balance + 50 WHERE cust_name = 'Sam';
-- WHOOPS! DIdn't mean to send moeny to Sam, meant to send it to Bob instead....

	ROLLBACK TO my_savepoint;
-- Think about how you might call a rollback in a java application
-- to check whether something has gone wrong

	UPDATE bank_accounts SET balance = balance + 50 WHERE cust_name = 'Bob';

COMMIT;

SELECT * FROM bank_accounts;

-- Transactions are ACIDic
-- - A proper TRANSACTION must have the following properties:

-- A = Atomicity: it either happens or it doesn't. It either happens or it doesn't
-- C = Consistency: Referential Integrity is maintained and constraints are changed properly upon successful transaction
-- I = Isolation: Transactions occur independently of eachother
-- D = Durability: Ensures that the result of a commited transaction persists in the case of system failure.

------------------------------------------------------------------------------------------------------


-- Transaction Problems: sometimes issues occur with transactions interfering with eachother
-- and getting ROLLED BACK due to the concurrent nature of a DB.

-- Dirty Read: A tx reads data from another transaction that hasn't been commited.
-- Non-Repeatable Read: 1 tx reads the same data TWICE while another tx updates the data in between the 1st and 2nd
-- Phantom Read: tx runs a query twice and gets diff data each time. Llike a diff # of ROWS 

-----------------------------------------------------------------------------------

-- Transaction Isolation Level: The higher the isolation level (the highest is called Serializable)
-- the more careful the system is about avoiding conflicts.

-- https://www.geeksforgeeks.org/transaction-isolation-levels-dbms/








