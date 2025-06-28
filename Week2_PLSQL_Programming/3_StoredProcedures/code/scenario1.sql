-- Scenario 1: The bank needs to process monthly interest for all savings accounts.
-- Question: Write a stored procedure ProcessMonthlyInterest that calculates and
-- updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.


CREATE PROCEDURE PROCESSMONTHLYINTEREST AS
BEGIN
    UPDATE ACCOUNTS
    SET
        BALANCE = BALANCE + ( BALANCE *.01 )
    WHERE
        ACCOUNTTYPE = 'Savings';

END;
/

-- EXECUTE the PROCEDURE
BEGIN
    PROCESSMONTHLYINTEREST;
END;
/