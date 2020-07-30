--Younga Jin (30 July 2020)
--Assignment 2-9: Using a FOR Loop
--Create a PL/SQL block using a FOR loop to generate a payment schedule for a donor’s pledge,
--which is to be paid monthly in equal increments.
--Values available for the block are starting payment due date,
--monthly payment amount,
--and number of total monthly payments for the pledge.
--The list that’s generated should display a line for each monthly payment
----showing payment number, date due, payment amount, and donation balance (remaining amount of pledge owed).

DECLARE
    lv_due_date DATE := '30-JUL-2020';
    lv_monthly_num NUMBER(6,2) := 120;
    lv_total#payments_num NUMBER(2) := 5; --total number of payments
    lv_remain_amount_num NUMBER(6,2) := 1000;
BEGIN
    FOR i IN 1..lv_total#payments_num LOOP
        DBMS_OUTPUT.PUT_LINE(i||' - '||lv_due_date || ': payment(' || lv_monthly_num||') remaining amount(' ||lv_remain_amount_num||')');
        lv_due_date := lv_due_date + 7;
        lv_remain_amount_num := lv_remain_amount_num - lv_monthly_num;
    END LOOP;
END;

--Assignment 2-10: Using a Basic Loop
--Accomplish the task in Assignment 2-9 by using a basic loop structure.
DECLARE
    lv_due_date DATE := '30-JUL-2020';
    lv_monthly_num NUMBER(6,2) := 120;
    lv_total#payments_num NUMBER(2) := 5; --total number of payments
    lv_remain_amount_num NUMBER(6,2) := 1000;
    lv_counter_num NUMBER(2) := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(lv_counter_num||' - '||lv_due_date || ': payment(' || lv_monthly_num||') remaining amount(' ||lv_remain_amount_num||')');
        EXIT WHEN lv_counter_num >= lv_total#payments_num;
        lv_due_date := lv_due_date + 7;
        lv_remain_amount_num := lv_remain_amount_num - lv_monthly_num;
        lv_counter_num := lv_counter_num + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Result - '||lv_due_date || ': payment(' || lv_monthly_num||') remaining amount(' ||lv_remain_amount_num||')');
END;

--Assignment 2-11: Using a WHILE Loop
--Accomplish the task in Assignment 2-9 by using a WHILE loop structure.
--Instead of displaying the donation balance (remaining amount of pledge owed) on each line of output,
--display the total paid to date.
DECLARE
    lv_due_date DATE := '30-JUL-2020';
    lv_monthly_num NUMBER(6,2) := 120;
    lv_total#payments_num NUMBER(2) := 5; --total number of payments
    lv_remain_amount_num NUMBER(6,2) := 1000;
    lv_total_amount_num NUMBER(6,2) := 0;
    lv_counter_num NUMBER(2) := 1;
BEGIN
    WHILE lv_counter_num < lv_total#payments_num LOOP
        lv_remain_amount_num := lv_remain_amount_num - lv_monthly_num;
        lv_total_amount_num := lv_total_amount_num + lv_monthly_num;
        DBMS_OUTPUT.PUT_LINE(lv_counter_num||' - '||lv_due_date || ': payment(' || lv_monthly_num||') total amount(' ||lv_total_amount_num||')');
        lv_due_date := lv_due_date + 7;
        lv_counter_num := lv_counter_num + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Result - '||lv_due_date || ': payment(' || lv_monthly_num||') remaining amount(' ||lv_remain_amount_num||') total amount(' ||lv_total_amount_num||')');
END;

--Assignment 2-12: Using a CASE Expression
--Donors can select one of three payment plans for a pledge indicated by the following codes:
--0 = one-time (lump sum) payment, 1 = monthly payments over one year, and 2 = monthly payments over two years.
--A local business has agreed to pay matching amounts on pledge payments during the current month.
--A PL/SQL block is needed to identify the matching amount for a pledge payment.
--Create a block using input values of a payment plan code and a payment amount.
--Use a CASE expression to calculate the matching amount,
----based on the payment plan codes 0 = 25%, 1 = 50%, 2 = 100%, and other = 0.
--Display the calculated amount.
DECLARE
    payment_plan_code NUMBER(1);
    --0 = one-time (lump sum) payment, 1 = monthly payments over one year, and 2 = monthly payments over two years.
    payment_amount NUMBER(8, 2);
    calculate_percent NUMBER(3, 2);
BEGIN
    --promt payment plan code
    payment_plan_code := :payment_plan_code;
    
    --promt payment amount
    payment_amount := :payment_amount;
    
    CASE payment_plan_code
        WHEN 0 THEN
            calculate_percent := 0.25;
            DBMS_OUTPUT.PUT_LINE('Lump Sum');
        WHEN 1 THEN
            calculate_percent := 0.50;
            DBMS_OUTPUT.PUT_LINE('Over one year');
        WHEN 2 THEN
            calculate_percent := 1;
            DBMS_OUTPUT.PUT_LINE('Over two year');
        ELSE
            calculate_percent := 0.25;
            DBMS_OUTPUT.PUT_LINE('Payment Pan is not identified');
    END CASE;
    
    DBMS_OUTPUT.PUT_LINE(' - $'||payment_amount*calculate_percent);
END;

--Assignment 2-13: Using Nested IF Statements
--An organization has committed to matching pledge amounts based on the donor type and pledge amount.
--Donor types include I = Individual, B = Business organization, and G = Grant funds.
--The matching percents are to be applied as follows:
--Donor Type I: [100-249: 50%], [250-499: 30%], [500-: 20%]
--Donor Type B: [100-499: 20%], [500-999: 10%], [1000-: 5%]
--Donor Type G: [100-: 5%] 
--Create a PL/SQL block using nested IF statements to accomplish the task.
--Input values for the block are the donor type code and the pledge amount.
DECLARE
    donor_type CHAR(1); --I: Individuatl, B: Business organization, G: Grant funds;
    pledge_amount NUMBER(7,2);
    matching_percents NUMBER(3, 2);
BEGIN
    donor_type := :donor_type;
    pledge_amount := :pledge_amount;
    
    IF donor_type = 'I' THEN
        IF pledge_amount >= 100 AND pledge_amount < 250 THEN
            matching_percents := 0.5;
        ELSIF pledge_amount >= 250 AND pledge_amount < 500 THEN
            matching_percents := 0.3;
        ELSIF pledge_amount >= 500 THEN
            matching_percents := 0.3;
        END IF;
    ELSIF donor_type = 'B' THEN
        IF pledge_amount >= 100 AND pledge_amount < 500 THEN
            matching_percents := 0.2;
        ELSIF pledge_amount >= 500 AND pledge_amount < 1000 THEN
            matching_percents := 0.1;
        ELSIF pledge_amount >= 1000 THEN
            matching_percents := 0.05;
        END IF;
    ELSIF donor_type = 'G' THEN
        IF pledge_amount >= 100 THEN
            matching_percents := 0.2;
        END IF;
    END IF;
    DBMS_OUTPUT.PUT_LINE('Donor Type: '||donor_type||', Pledge amount: '||pledge_amount||', Matching Percents: '||matching_percents*100||'%');
END;