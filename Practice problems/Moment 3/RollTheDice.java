/**
* From LTU: Logic - Roll the dice
* Write a program where the user is first asked to enter the number of dice rolls desired. 
* The program must then partly print the results, 
* partly illustrate the number of 1s, 2s, etc. with horizontal # characters.
*
* Example ( 10 is the number entered by the user):
*	Number of throws: 10
*
*	1 6 5 3 6 6 4 3 1 1
*
*	1: ###
*	2: 
*	3: ##
*	4: #
*	5: #
*	6: ###
*
*pseudocode:
* initiate Scanner
* initiate constants MAX=6 MIN=1
* initiate varibles numberOfRolls, diceRoll, countOnes , countTwos, countTre, countFours, countFives, countSixs
* print: ask user for number of dice rolls
*	numberOfRolls = user input
* for (counter = 1; counter <= numberOfRolls, counter++)
*	Roll the dice with: diceRoll = (int) (Math.random () * (MAX-MIN+1) +MIN;
*	print: diceRoll
*	Uppdate static with:
*	if (diceRoll = 1)
*		countOnes++
*	else if (diceRoll = 2)
*		countTwos++
*	else if (diceRoll = 3)
*		countTre++
*	else if (diceRoll = 4)
*		countFours++
*	else if (diceRoll = 5)
*		countFives++
*	else
*		countSixs++
* print the number of 1-6 rolls
*/

import java.util.Scanner; // program uses class Scanner
import java.lang.Math;  // program uses class Math

class RollTheDice
{
	public static void main(String[] args)
	{
		//create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		//initiate variabls and constants
		final int MAX = 6; //number of sides on the dice
		final int MIN = 1; // for calculate of random roll

		int numberOfRolls;
		int diceRoll;
		int countOnes = 0;
		int countTwos = 0;
		int countTre = 0;
		int countFours = 0;
		int countFives = 0;
		int countSixs = 0;

		//processing phase
		//Ask user for number of rolls to make
		System.out.print("Number of rolls: ");
		numberOfRolls = input.nextInt();

		//roll the dice, count and print the throws
		for (int counter = 1; counter <= numberOfRolls; counter++)
		{
			diceRoll = (int) (Math.random () * (MAX-MIN+1) +MIN);

			//print the roll
			System.out.print(diceRoll + " ");

			//static of rolls
			if (diceRoll == 1)
			{
				countOnes++;
			}
			else if (diceRoll == 2)
			{
			countTwos++;
			}
			else if (diceRoll == 3)
			{
				countTre++;
			}
			else if (diceRoll == 4)
			{
				countFours++;
			}
			else if (diceRoll == 5)
			{
				countFives++;
			}
			else
			{
				countSixs++;
			}
		}//Exit dice roll loop
    
		//print results
		
		//print a # for every 1 (and the do the same for 2-6)
		System.out.print("\n1: ");
		for (int counter = 1; counter <= countOnes; counter++)
		{
			System.out.print("#"); 
		}

		System.out.print("\n2: ");
		for (int counter = 1; counter <= countTwos; counter++)
		{
			System.out.print("#"); 
		}

		System.out.print("\n3: ");
		for (int counter = 1; counter <= countTre; counter++)
		{
			System.out.print("#"); 
		}

		System.out.print("\n4: ");
		for (int counter = 1; counter <= countFours; counter++)
		{
			System.out.print("#"); 
		}

		System.out.print("\n5: ");
		for (int counter = 1; counter <= countFives; counter++)
		{
			System.out.print("#"); 
		}

		System.out.print("\n6: "); 
		for (int counter = 1; counter <= countSixs; counter++)
		{
			System.out.print("#"); 
		}
	}
}
