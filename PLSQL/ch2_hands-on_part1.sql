--Hands-On Assignment Part I

--Assignment 2-1: Using Scalar Variables

DECLARE
    lv_test_date DATE := '10-DEC-12';
    lv_test_num CONSTANT NUMBER(3) := 10;
    lv_test_txt VARCHAR2(10);
BEGIN
    lv_test_txt := 'Jin';
    DBMS_OUTPUT.PUT_LINE(lv_test_date || ' | ' || lv_test_num || ' | ' || lv_test_txt);
END;

--Assignment 2-2: Creating a Flowchart

--Assignment 2-3: Using IF Statements

DECLARE
    lv_total_num NUMBER(5,2) := 0;
    lv_customer_txt VARCHAR2(4);
BEGIN
    IF lv_total_num > 200 THEN
        lv_customer_txt := 'HIGH';
    ELSIF lv_total_num > 100 THEN
        lv_customer_txt := 'MID';
    ELSE
        lv_customer_txt := 'LOW';
    END IF;
    DBMS_OUTPUT.PUT_LINE(lv_customer_txt);
END;

--Assignment 2-4: Using CASE Statements
DECLARE
    lv_total_num NUMBER(5,2) := 333;
    lv_customer_txt VARCHAR2(4);
BEGIN
    CASE
        WHEN lv_total_num > 200 THEN lv_customer_txt := 'HIGH';
        WHEN lv_total_num > 100 THEN lv_customer_txt := 'MID';
        ELSE lv_customer_txt := 'LOW';
    END CASE;
    DBMS_OUTPUT.PUT_LINE(lv_customer_txt);
END;

--Assignment 2-5: Using a Boolean Variable
--Create a PL/SQL block using a Boolean variable to indicate whether an amount is still due.
--Declare and initialize two variables to provide input for the account balance
--and the payment amount received.
--A TRUE Boolean value should indicate an amount is still owed,
--and a FALSE value should indicate the account is paid in full.
--Use output statements to confirm that the Boolean variable is working correctly.

DECLARE
    lv_balance_num NUMBER(6,2) := 1000;
    lv_received_num NUMBER (6,2) := 1000;
    lv_isowed_bln BOOLEAN;
BEGIN
    IF (lv_balance_num > lv_received_num) THEN
        lv_isowed_bln := TRUE;
        DBMS_OUTPUT.PUT_LINE('TRUE');
    ELSE
        lv_isowed_bln := FALSE;
        DBMS_OUTPUT.PUT_LINE('FALSE');
    END IF;
END;

--Assignment 2-6: Using Looping Statements
--Create a block using a loop that determines the number of items
--that can be purchased based on the item prices and the total available to spend.
--Include one initialized variable to represent the price
--and another to represent the total available to spend.
--(You could solve it with division, but you need to practice using loop structures.)
--The block should include statements to display the total number of items
--that can be purchased and the total amount spent.

DECLARE
    lv_price_num NUMBER(6,2) := 80;
    lv_available_num NUMBER(6,2) := 1000;
    lv_count_items_num NUMBER(4) := 0;
BEGIN
    LOOP
        EXIT WHEN lv_available_num - lv_price_num < 0;
        lv_available_num := lv_available_num - lv_price_num;
        lv_count_items_num := lv_count_items_num + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Number of items: ' || lv_count_items_num || ', total amount spent: $' || lv_price_num * lv_count_items_num);
END;

--Assignment 2-7: Creating a Flowchart


--Assignment 2-8: Using IF Statements
--Create a block to accomplish the task outlined in Assignment 2-7.
--Include a variable containing a Y or N to indicate membership status
--and a variable to represent the number of items purchased.
--Test with a variety of values.

DECLARE
    lv_ismember_txt CHAR(1) NOT NULL := 'N';
    lv_#items_num NUMBER(3) := 2;
    lv_shippingcost_num NUMBER(6,2);
BEGIN
    IF lv_ismember_txt = 'Y' THEN
        IF lv_#items_num > 10 THEN
            lv_shippingcost_num := 9;
        ELSIF lv_#items_num >= 7 THEN
            lv_shippingcost_num := 7;
        ELSIF lv_#items_num >= 4 THEN
            lv_shippingcost_num := 5;
        ELSE
            lv_shippingcost_num := 3;
        END IF;
    ELSE
        IF lv_#items_num > 10 THEN
            lv_shippingcost_num := 12;
        ELSIF lv_#items_num >= 7 THEN
            lv_shippingcost_num := 10;
        ELSIF lv_#items_num >= 4 THEN
            lv_shippingcost_num := 7.5;
        ELSE
            lv_shippingcost_num := 5;
        END IF;
    END IF;
    DBMS_OUTPUT.PUT_LINE('Is Member?' || lv_ismember_txt || ', #itmes: ' || lv_#items_num || ', shipping cost: $' || lv_shippingcost_num);
END;