-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
-- Question: Write a stored procedure UpdateEmployeeBonus that updates the salary 
-- of employees in a given department by adding a bonus percentage passed as a parameter.

CREATE OR REPLACE PROCEDURE UPDATEEMPLOYEEBONUS (
    BONUS IN NUMBER,
    DEPT  IN VARCHAR2
) AS
BEGIN
    UPDATE EMPLOYEES
    SET
        SALARY = SALARY + ( SALARY * BONUS / 100 )
    WHERE
        DEPARTMENT = DEPT;

END;
/


-- EXECUTE the procedure 
BEGIN
    UPDATEEMPLOYEEBONUS(5,'IT');
END;
/