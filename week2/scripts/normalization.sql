
-- This is 1NF -- NOT ideal
CREATE TABLE employee (
	employee_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(100) NOT NULL,
	ss_number INTEGER,
	dept_name VARCHAR(100)
);

-- to transform it from 1NF to 2NF 

CREATE TABLE employee_2nf (
		employee_id SERIAL PRIMARY KEY,
		emp_name VARCHAR(100) NOT NULL,
		ss_number INTEGER
);

CREATE TABLE employee_dept_2nf (
	employee_id REFERENCES employee_2nf(employee_id),
	dept_name VARCHAR(100) NOT NULL
);


-- 3NF looks like this...
CREATE TABLE department(
	dept_id SERIAL PRIMARY KEY, -- this must be persisted FROM the app
	dept_name VARCHAR(100)
);


CREATE TABLE employee_dept_3nf (
	employee_id INTEGER REFERENCES employee_detail_3nf(emp_id),
	dept_id INTEGER REFERENCES department(dept_id)
);

CREATE TABLE employee_detail_3nf (
	emp_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(100),
	ss_num INTEGER
);











