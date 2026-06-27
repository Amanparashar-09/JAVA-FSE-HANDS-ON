-- Scenario 1: Apply 1% discount to loan interest rates for customers above 60

BEGIN
    FOR rec IN (
        SELECT c.CustomerID, l.LoanID, l.InterestRate,
               TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS age
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
    ) LOOP
        IF rec.age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
            DBMS_OUTPUT.PUT_LINE('Discount applied for CustomerID: ' || rec.CustomerID);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Set IsVIP flag for customers with balance over $10,000

BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            DBMS_OUTPUT.PUT_LINE('CustomerID ' || rec.CustomerID || ' is VIP.');
        END IF;
    END LOOP;
END;
/

-- Scenario 3: Send reminders for loans due within the next 30 days

BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name ||
            ', your loan (ID: ' || rec.LoanID ||
            ') is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/
