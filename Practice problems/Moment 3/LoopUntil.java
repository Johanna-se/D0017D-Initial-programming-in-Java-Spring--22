/**
* From LTU: Exercise 4.6 - Initial exercises on repetition sets
*
*    1. Construct a loop that is executed until the user enters a number that is not greater than zero.
*    2. Modify the loop so that the number must be less than zero to achieve termination.
*
*pseudocode:
* initiate Scanner
* initiate varible number = 1
* while number > 0
*	ask user to input a number
*		number = user input
* Print: That was fun, let's do another
* while number >= 0  
*	ask user to input a number
*		number = user input
*/

import java.util.Scanner; // program uses class Scanner

class LoopUntil
{
	public static void main(String[] args)
	{
		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		//initiate variabls
		int number = 1;

		// processing phase
		// Exit can be 0 or negative int
		while (number > 0)
		{
			System.out.print("Enter a integer number (to exit enter 0): ");
			number = input.nextInt();
		}
		
		System.out.println("That was fun, let's do another");
		
		//Alt: Exit must be a negative int
		while (number >= 0)
		{
			System.out.print("Enter a integer number: (to exit enter a negative integer: )");
			number = input.nextInt();
		}
	}
}
	