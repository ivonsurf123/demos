CREATE TABLE public.one (
	c_one INTEGER PRIMARY KEY,
	c_two INTEGER
);

CREATE TABLE public.two ( 
	c_one INTEGER PRIMARY KEY,
	c_two INTEGER
);

INSERT INTO public.one VALUES (1, 1), (2, 2);
INSERT INTO public.two VALUES (1, 1), (2, 1);

-- SET Operations only operate on results that have the same number and type of columns

-- the UNION operator will combine all resutls together
-- but it will NOT include duplicates

SELECT * FROM public.one UNION SELECT * FROM public.two;

-- UNION ALL will include duplicates

SELECT * FROM public.one UNION ALL SELECT * FROM public.two;

-- INTERSECT will include only the MATCHING results from tables
SELECT * FROM public.one INTERSECT SELECT * FROM public.two;


-- EXCEPT will keep results from the left view, and remove matching results from the right
SELECT * FROM public.one EXCEPT SELECT * FROM public.two;


/**
 * SQL has SCALAR and AGGREGATE functions....
 * 
 * 
 * SCALAR FUNCTION:
 * perform ONE thing to every value and return it
 */

SELECT UPPER(first_name), last_name FROM public.users;
-- LOWER...

-- AGGREGATE FUNCTION
-- operate on an entire column and produce 1 output
SELECT SUM(c_one) FROM public.one;
SELECT AVG(c_one) FROM public.one;
SELECT MAX(c_one) FROM public.one;

SELECT AVG(LENGTH(first_name)) FROM public.users;












