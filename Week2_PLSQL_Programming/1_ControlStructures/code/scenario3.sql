-- Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
-- Question: Write a PL/SQL block that fetches all loans due in the next 30 days and 
-- prints a reminder message for each customer.


BEGIN
    FOR C IN (
        SELECT
            C.NAME,
            C.CUSTOMERID,
            L.LOANAMOUNT,
            L.ENDDATE
        FROM
                 LOANS L
            JOIN CUSTOMERS C ON C.CUSTOMERID = L.CUSTOMERID
        WHERE
            L.ENDDATE BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Due loan on '
                             || TO_CHAR(C.ENDDATE, 'YYYY-MM-DD')
                             || ', amount: '
                             || C.LOANAMOUNT
                             || ', name: '
                             || C.NAME);
    END LOOP;
END;
/