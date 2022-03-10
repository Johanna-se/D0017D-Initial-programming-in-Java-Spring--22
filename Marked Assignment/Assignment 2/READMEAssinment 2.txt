Assignment 2 - Calculation

LEARNING OUTCOME
The student must show ability and skill in structuring their code so that it is clear and easy to follow for another programmer, 
to read in input from the user and convert to a suitable data type for further processing, 
to print formatted data to the user and to handle the String data type.

PREREQUISITES
The assignment presupposes that you have studied the material in step 2 and bring with you knowledge and feedback from Assignment 1.

TASK
You will create a program that calculates how much money your solar cells generate per day based on the number of hours of sunshine.

Begin the task by constructing a flow chart and program logic on paper. 
Then describe your structure in text form (pseudocode) in the comment header of the program 
so that an outsider can understand what the program does and how your logic / algorithm works.

You have installed solar cells on your roof and want to calculate how much you earn on a sunny summer day. 
You have bought 26 solar panels that are each 1.7x1 m in size and can produce a maximum of 290 W.

ASSUMPTIONS

    1. You have installed your solar panels in a straight south position and have an ideal roof angle (35-45 degrees).
    2. The solar radiation in Skellefteå on a sunny summer day (June / July) is on average 166 Wh / m2 / hour.
    3. The efficiency of the solar cell (Thermal efficiency) is assumed to be 20% (of the solar radiation).
    4. The electricity price is assumed to be SEK 0.9 / kWh (including 60 öre tax rebate).

Production (Wh) = Solar radiation (Wh / m2 / hour) x efficiency x surface (m2) x hours of sunshine

The user enters what time the sun rises and what time it sets. Use Scanner for input (not dialog boxes). The time is entered in the form hh: mm.

The program must first calculate the number of hours of sunshine, then what production takes place and finally what profit the sale of the entire production gives.

Present the results to two decimal places, use printf to format the printout.

We assume in the program that all entered times are valid for the same day. 
You should check entered values ​​so that the "date" is in June / July (month 6 or 7) and that the time of sunset is later than sunrise. 
For all other values, the program should give an error message and quit.


Example run

Enter today's date [mm-dd]> 06-22
Enter time of sunrise [hh: mm]> 01:46
Enter time of sunset [hh: mm]> 23:28
========================================== 
Sun hours: 21.70 hours 
The production on 22/6 is: 31.84 kWh to a value of: SEK 28.66
Enter today's date [mm-dd]> 06-22
Enter time of sunrise [hh: mm]> 01:46
Enter time of sunset [hh: mm]> 23:28
========================================== 
Sun hours: 21.70 hours 
The production on 22/6 is: 31.84 kWh to a value of: SEK 28.66


