/**
* From LTU: Task 4.4 - Combined logical expressions
* For a certain program, you want to use an entered time value to tell whether it is lunchtime or not. 
* Lunch time is defined as the interval between the times 1200 -1300.
*
*    1. Think about how you with logical operators and comparison operators can describe a 
*		compound logical expression to talk about whether it is lunch or not for the entered time. 
*		In this case, you can advantageously represent the time as an integer given that you do not use a semicolon.
*    2. Show an alternative solution where you replace your logical operator with a nested if statement (one if statement in another if statement)
*
*pseudocode:
* initiate Scanner
* initiate constant HIGH_TIME_BREAK, LOW_TIME_BREAK, 
* initiate varible time
* Ask user for the time
* if LOW_TIME_BREAK <= time <= HIGH_TIME_BREAK
*	Print: "It is lunch time!"
* Else
*	Print: "Nope, it is not time for lunch"
*
* Alt:
* Ask user for time
*if time > LOW_TIME_BREAK
* 	if time < HIGH_TIME_BREAK
*		print: "It is lunch time!"
*	else
*		Print: "Nope, it is not time for lunch"
*/


import java.util.Scanner; // program uses class Scanner

class LunchTime
{
	public static void main(String[] args)
	{
		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		//initiate constants 
		final int LOW_TIME_BREAK = 1200; //when lunch starts
		final int HIGH_TIME_BREAK = 1300; //When lunch ends

		//initiate variabls
		int time;

		// processing phase
		//ask user to input time
		System.out.print("What is the time? (enter format: 1200): ");
		time = input.nextInt();

		//Return to user 2 different outcome using logical operators and comparison operators.
		if (time >= LOW_TIME_BREAK & time <= HIGH_TIME_BREAK )
		{
			System.out.println("It is lunch time! \n");
		}
		else
		{
			System.out.println("Nope, it is not time for lunch \n");
		}

    
		//Alt solutions with nested if statements
		//ask user to input time again
		System.out.println("This was fun! Lets do it again!");
		System.out.print("What is the time? (enter format: 1200): ");
		time = input.nextInt();

		//Return to user 2 different outcome
		if (time >= LOW_TIME_BREAK)
		{
			if (time <= HIGH_TIME_BREAK)
			{
				System.out.println("It is lunch time!");
			}
			else
			{
				System.out.println("Nope, it is not time for lunch \n");
			}
		}
		else
		{
		System.out.println("Nope, it is not time for lunch \n");
		}
	}
}
