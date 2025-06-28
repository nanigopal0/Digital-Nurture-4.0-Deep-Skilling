-- Scenario 3: Customers should be able to transfer funds between their accounts.
-- Question: Write a stored procedure TransferFunds that transfers a specified amount
--  from one account to another, checking that the source account has sufficient balance 
--  before making the transfer.

CREATE OR REPLACE PROCEDURE TRANSFERFUNDS (
    FROMACCID IN NUMBER,
    TOACCID   IN NUMBER,
    AMOUNT    IN NUMBER
) AS
    INSUFFICIENT_BALANCE EXCEPTION;
    C_AMT NUMBER;
BEGIN
    SELECT
        BALANCE
    INTO C_AMT
    FROM
        ACCOUNTS
    WHERE
        ACCOUNTID = FROMACCID;

    IF C_AMT > AMOUNT THEN
        UPDATE ACCOUNTS
        SET
            BALANCE = BALANCE - AMOUNT
        WHERE
            ACCOUNTID = FROMACCID;

        UPDATE ACCOUNTS
        SET
            BALANCE = BALANCE + AMOUNT
        WHERE
            ACCOUNTID = TOACCID;

        INSERT INTO TRANSACTIONS (
            TRANSACTIONID,
            ACCOUNTID,
            TRANSACTIONDATE,
            AMOUNT,
            TRANSACTIONTYPE
        ) VALUES ( 3,
                   FROMACCID,
                   SYSDATE,
                   AMOUNT,
                   'Withdrawal' );

        INSERT INTO TRANSACTIONS (
            TRANSACTIONID,
            ACCOUNTID,
            TRANSACTIONDATE,
            AMOUNT,
            TRANSACTIONTYPE
        ) VALUES ( 4,
                   TOACCID,
                   SYSDATE,
                   AMOUNT,
                   'Deposit' );

    ELSE
        RAISE INSUFFICIENT_BALANCE;
    END IF;

EXCEPTION
    WHEN INSUFFICIENT_BALANCE THEN
        DBMS_OUTPUT.PUT_LINE('Insufficent balance');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error!');
END;
/

-- EXECUTE the procedure
BEGIN
    TRANSFERFUNDS(2, 1, 500);
END;
/