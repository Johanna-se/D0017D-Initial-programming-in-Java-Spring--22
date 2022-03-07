/**
* From LTU: Logic - Temperature
* The temperature task that was previously structured (moment 2) and to some extent implemented must now be clearly implemented. 
* The basic structure is represented as shown in Main.java
*
* Code under the headings "declaration of variables", "start" and "print" you have already made in the previous unit/momet. 
* Now fill in the code under the heading "processing".
*
*pseudocode:
* initiate Scanner
* initiate varibles noOfDays, sum = 0, min = 100, max = -100, temp, avarage = 0
* Ask user for number of days in the month
*	noOfDays = user input
* for (int day = 1 ; day <= noOfDays ; day++)
*	print: enter the temperature of day + day
*	temp = user input
'	sum = sum + temp
*	if sum < min
*		min = temp
*	if sum > max
*		max = temp 
* avarage = sum / noOfDays
* Print: "The months max temperature was " + max + " while the min temperature was " + min + " and the avarage temperature was " +sum	
*/

import java.util.Scanner; // program uses class Scanner

class Temperature
{
	public static void main(String[] args)
	{
		
		// declaration of variables
		int noOfDays; 
		int sum = 0;
		int min = 100; 
		int max = -100; 
		int temp; 
		int avarage = 0;

		// Creating scanner object for reading from input stream 
		Scanner userInput = new Scanner(System.in);

     
		// Start
		//Ask User for days
		System.out.print("How many days of this month? ");
		noOfDays = userInput.nextInt();

     
		// processing
		for (int day = 1 ;day <= noOfDays; day++)
		{
			// Ask user for todays temp
			System.out.print("Enter the temperature of day " + day + ": ");
			temp = userInput.nextInt();

			// Add todays temp to total
			sum = sum + temp;

			//Is it the lowest temp so far? If so store it in min
			if (temp < min)
			{
				min = temp;
			}

			//Is it the highest temp so far? If so, store it in max
			if (temp > max)
			{
				max = temp;
			}
      
		} //Exit loop

		// calculate the avarage temp of the month
		avarage = sum / noOfDays;

     
		// Print
		System.out.print("The months max temperature was " + max + " while the min temperature was " + min + " and the avarage temperature was " + avarage);

	}
}
