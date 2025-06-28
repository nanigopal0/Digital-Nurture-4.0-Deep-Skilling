-- Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
-- Question: Write a PL/SQL block that loops through all customers, checks their age, 
-- and if they are above 60, apply a 1% discount to their current loan interest rates.

DECLARE
    C_DOB CUSTOMERS.DOB%TYPE;
    C_AGE INTEGER;
BEGIN
    FOR LOAN IN (
        SELECT
            *
        FROM
            LOANS
    ) LOOP
        SELECT
            DOB
        INTO C_DOB
        FROM
            CUSTOMERS
        WHERE
            CUSTOMERID = LOAN.CUSTOMERID;

        C_AGE := SYSDATE - C_DOB;
        IF C_AGE > 60 THEN
            UPDATE LOANS
            SET
                INTERESTRATE = INTERESTRATE - 1
            WHERE
                LOANID = LOAN.LOANID;

        END IF;

    END LOOP;
END;
/