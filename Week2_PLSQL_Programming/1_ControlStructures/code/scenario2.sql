-- Scenario 2: A customer can be promoted to VIP status based on their balance.
-- Question: Write a PL/SQL block that iterates through all customers and
-- sets a flag IsVIP to TRUE for those with a balance over $10,000.

ALTER TABLE CUSTOMERS ADD ISVIP VARCHAR2(5);

BEGIN
    FOR CUST IN (
        SELECT
            BALANCE,
            CUSTOMERID
        FROM
            CUSTOMERS
    ) LOOP
        IF CUST.BALANCE > 10000 THEN
            UPDATE CUSTOMERS
            SET
                ISVIP = 'TRUE'
            WHERE
                CUSTOMERID = CUST.CUSTOMERID;

        ELSE
            UPDATE CUSTOMERS
            SET
                ISVIP = 'FALSE'
            WHERE
                CUSTOMERID = CUST.CUSTOMERID;

        END IF;
    END LOOP;
END;
/