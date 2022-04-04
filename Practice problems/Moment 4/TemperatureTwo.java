/**
* From LTU: Arrays - Temperature
* Instructions
*
* Modify the temperature data from previous unit/moment on Logic practice problem, 
* so that all temperature values are stored in an array. 
* The program must partly print out which day the highest and lowest temperature were measured and what temperatures it was,
* and partly print out the number of days when the temperature exceeded the average temperature.
*
*/

import java.util.Scanner; // program uses class Scanner

class TemperatureTwo
{
	public static void main(String[] args)
	{
		// declaration of variables
		int noOfDays; 
		int temp; 

		//declar and initiate array
		// the array object represent {sum, min, max, avarage}
		int [] temperature = {0, 100, -100, 0};

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

			// Add todays temp to sum which is stord in temperature array object 0
			temperature [0] = temperature [0]+ temp;

			//Is it the lowest temp so far? If so store it in temperature array object 1
			if (temp < temperature [1] )
			{
				temperature [1] = temp;
			}

			//Is it the highest temp so far? If so, store it in temperature array object 2
			if (temp > temperature [2])
			{
				temperature [2] = temp;
			}
      
		} //Exit loop

		// calculate the avarage temp (stord in temperature [3]) of the month
		temperature [3]= temperature [0] / noOfDays;

     
		// Print
		System.out.print("The months max temperature was " + temperature [2] + " while the min temperature was " + temperature [1] + " and the avarage temperature was " + temperature [3] + "\n");

    }
}
