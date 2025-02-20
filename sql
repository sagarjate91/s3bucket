
CREATE TABLE CUSTOMERS (
   ID INT AUTO_INCREMENT,
   NAME VARCHAR(20) NOT NULL,
   AGE INT NOT NULL,
   ADDRESS CHAR (25),
   SALARY DECIMAL (18, 2),
   PRIMARY KEY (ID)
);

INSERT INTO CUSTOMERS VALUES 
(1, 'Ramesh', 32, 'Ahmedabad', 2000.00),
(2, 'Khilan', 25, 'Delhi', 1500.00),
(3, 'Kaushik', 23, 'Kota', 2000.00),
(4, 'Chaitali', 25, 'Mumbai', 6500.00),
(5, 'Hardik', 27, 'Bhopal', 8500.00),
(6, 'Komal', 22, 'Hyderabad', 4500.00),
(7, 'Muffy', 24, 'Indore', 10000.00);

SHOW COLUMNS FROM CUSTOMERS;


CRUD Operation:

SELECT COLUMN_NAME FROM TABLE_NAME

INSERT INTO TABBLE_NAME(CN) VALYES();

UPDATE table_reference
SET column1 = value1, column2 = value2...., columnN = valueN
WHERE [condition];

DELECT FROM TABLE NAME;

SELECT * FROM CUSTOMERS LIMIT 4;

SELECT DISTINCT ADDRESS FROM CUSTOMERS;

SELECT * FROM CUSTOMERS
ORDER BY NAME;

SELECT AGE, COUNT(Name) FROM CUSTOMERS GROUP BY AGE;

SELECT CONCAT(AGE, ' - ', SALARY) AS SALARY_AGEWISE 
FROM CUSTOMERS 
GROUP BY AGE, SALARY;

SELECT * FROM CUSTOMERS
WHERE ADDRESS = "Hyderabad" AND AGE = 22;


SELECT * FROM CUSTOMERS
WHERE SALARY > 5000
OR ADDRESS = "Hyderabad";

SELECT * from CUSTOMERS WHERE NAME LIKE '%esh';

SELECT * FROM CUSTOMERS 
WHERE NAME IN ('Khilan', 'Hardik', 'Muffy');

SELECT * FROM CUSTOMERS
WHERE NAME NOT LIKE 'K%'

SELECT * FROM CUSTOMERS 
WHERE AGE BETWEEN 20 AND 25;  

ALTER TABLE CUSTOMERS DROP ID;
ALTER TABLE CUSTOMERS ADD ID INT;
ALTER TABLE CUSTOMERS ADD ID INT FIRST;
ALTER TABLE CUSTOMERS ADD ID INT AFTER NAME;
ALTER TABLE CUSTOMERS MODIFY NAME INT;
ALTER TABLE CUSTOMERS ALTER NAME SET DEFAULT 1000;
ALTER TABLE CUSTOMERS ALTER NAME DROP DEFAULT;
ALTER TABLE CUSTOMERS RENAME TO BUYERS;
CREATE TABLE new_table SELECT * FROM original_table;

CREATE TABLE new_table LIKE original_table;
INSERT INTO new_table SELECT * FROM original_table;
