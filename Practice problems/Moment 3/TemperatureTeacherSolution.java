/**
* The teachers solution to the temperature program. 
*/

import java.util.Scanner;

public class TemperatureTeacherSolution
{
	public static void main (String [] args)
	{

		// Declare variables needed
		int noOfDays, day;
		double sum, max, min, average = 0;

		// Enter the number of days
		Scanner keyboard = new Scanner (System.in);
		System.out.print ("How many days does the month have? ");
		noOfDays = keyboard.nextInt ();
		keyboard.nextLine (); // Clear the input buffer

		// Initiate variables
		sum = 0.0;
		max = -100;
		min = 100;

		// PROCESSING
		for (day = 1; day <= noOfDays; day ++)
		{
			// Enter temp for day 'day'
			System.out.print ("Enter the temperature for day " + day + ": ");
			double temp = keyboard.nextDouble ();
			keyboard.nextLine (); // Clear the input buffer

			// Add temp to sum
			sum = sum + temp;

			// is temp lower than lowest?
			if (temp <min)
			{
				min = temp; // New minimum temperature
			}
			// is temp higher than maximum?
			if (temp> max)
			{
				max = temp; // New maximum temperature
			}
		}

		// Calculate the mean
		average = sum / noOfDays;

		// PRINTING
		System.out.println ("The highest temperature was " + max + "°C\n");
		System.out.println ("The minimum temperature was " + min + "°C\n");
		System.out.println ("Average temperature was " + average + "°C\n");

		keyboard.close (); // Closes the inflow, may only be done at the very end of the program!
	}
}
