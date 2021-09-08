-- DDL _ Data definition language
-- DML data manipulation language
-- TCL transaction control language
-- DQL - Data query language
-- DCL -- Data control language


-- 1. create a user
CREATE USER harrypotter WITH PASSWORD 'dumbledore';

-- GRANT PRIVELEGES
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA sophiag TO harrypotter;
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA sophiag FROM harrypotter;


CREATE ROLE special_admin WITH
	CREATEDB
	CREATEROLE
	LOGIN
	INHERIT;

-- we can grant that role (with special capabilities to our specific user)
GRANT special_admin TO harrypotter;




