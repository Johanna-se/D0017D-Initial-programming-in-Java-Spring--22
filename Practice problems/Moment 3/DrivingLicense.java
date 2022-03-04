/**
* From LTU: Task 4.1 - Exercises with relationship operators
* In Sweden, the driving license age is currently 18 years. 
* Do a program that reads in a certain person's age and then, based on the person's age, 
* talks about whether the person can get a driving license or not.
*
*pseudocode:
* initiate Scanner
* initiate constants DRIVING_AGE
* initiate varibles age
* Ask user for age
* if age >= DRIVING_AGE
*	print: you can get your drivers licens!
* else
*	print. sorry, you have to wait a while before you can get a drivers licens
*/

import java.util.Scanner; // program uses class Scanner

class DrivingLicense
{
	public static void main(String[] args)
	{
		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		//initiate constants
		final int DRIVING_AGE = 18;

		//initiate variabls
		int age;

		// processing phase
		//ask user to input age
		System.out.print("What is your age? ");
		age = input.nextInt();

		//if user is DRIVING_AGE or older
		if (age >= DRIVING_AGE)
		{
		System.out.println("You can get your drivers licens! ");
		}
		//if user is younger
		else
		{
		System.out.println("Sorry, you have to wait a while before you can get a drivers licens");
		}
	}
}
