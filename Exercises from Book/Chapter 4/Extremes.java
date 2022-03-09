/**
*Exercise 4.11 From the book:
* Write an application that finds the minimum and maximum amongst several
* integers and then computes the sum of the two extremes. The user will be prompted to input how
* many values the application should ask the user to input.
*
*pseudocode:
* initiate Scanner
* initiate varibles max = -10 000, min = 10 000, sum, number, howMany
* Ask user how main integers are to be enterd
* 	howMany = user input
* for (int counter = 1; counter <= howMany; counter++)
*	Ask user for next number
*	number = user input
*	if (number > max)
*		number = max
*	if (number < min)
*		number = min
* sum = max + min
* print sum	
*/

import java.util.Scanner; // program uses class Scanner

class Extremes
{
	public static void main(String[] args)
	{
		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		//initiate variabls
		int max = -10000;
		int min = 10000;
		int sum;
		int number;
		int howMany;

		// processing phase
		// Ask user for how many integers to add.
		System.out.print ("How main integers are to be enterd? ");
		howMany = input.nextInt();

		//loop for entering numbers and finding max and min value
		for (int counter = 1; counter <= howMany ; counter++)
		{
			System.out.print ("Enter next integer (0 - 1000): ");
			number = input.nextInt();

			//Check if the number is larger than the previos max, if so store number in max
			if (number > max)
			{
			max = number;
			}

			//Check if the number is smaller than the previos min, if so store number in min
			if (number < min)
			{
			min = number;
			}
		}//exit loop

		//calculate sum with the values from the loop.
		sum = max + min;

		//print results
		System.out.println ("The sum of the max " + max + " and min " + min + " is: " + sum);
	}
}
