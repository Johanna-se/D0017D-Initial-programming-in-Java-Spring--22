/**
* the teachers solution to the dice roll
*/

import java.util.Scanner;
import java.lang.Math;

class RollTheDiceTeacherSolution
{
	public static void main(String[] args)
	{
		// Variable declaration
		int nrOfThrows, currentThrow;
		int nrOfOnes = 0;
		int nrOfTwos = 0;
		int nrOfThrees = 0;
		int nrOfFours = 0;
		int nrOfFives = 0;
		int nrOfSixs = 0;

		Scanner keyboard = new Scanner (System.in);

		System.out.print ("Number of throws: ");
		nrOfThrows = keyboard.nextInt ();

		// Roll the dice
		for (int roll = 0; roll <nrOfThrows; roll ++)
		{
			// Random a throw 1-6
			currentThrow = (int) (Math.random () * 6) +1;
			// Print the cast
			System.out.print (currentThrow + "");

			// Update statistics
			if (currentThrow == 1) // If we got a one
			{
				nrOfOnes ++; // Increase the number of ones by 1
			}
			else if (currentThrow == 2) // Otherwise if we got a second
			{
				nrOfTwos ++; // Increase the number of twos by 1
			}
			else if (currentThrow == 3)
			{
				nrOfThrees ++;
			}
			else if (currentThrow == 4)
			{
				nrOfFours ++;
			}
			else if (currentThrow == 5)
			{
				nrOfFives ++;
			}
			else // Otherwise it must be a six
			{
			nrOfSixs ++;
			}
		}

		// Present the number of ones
		System.out.print ("\n1: ");
		// Prints a # for every one
		for (int i = 0; i <nrOfOnes; i ++)
		{
			System.out.print ("#");
		}

		// Present the number of twos
		System.out.print ("\n2: ");
		for (int i = 0; i <nrOfTwos; i ++)
		{
			System.out.print ("#");
		}

		// Present the number of threes
		System.out.print ("\n3: ");
		for (int i = 0; i <nrOfThrees; i ++)
		{
			System.out.print ("#");
		}

		// Present the number of fours
		System.out.print ("\n4: ");
		for (int i = 0; i <nrOfFours; i ++)
		{
			System.out.print ("#");
		}

		// Present the number of fives
		System.out.print ("\n5: ");
		for (int i = 0; i <nrOfFives; i ++)
		{
			System.out.print ("#");
		}

		// Present the number of sixes
		System.out.print ("\n6: ");
		for (int i = 0; i <nrOfSixs; i ++)
		{
			System.out.print ("#");
		}
	}
}