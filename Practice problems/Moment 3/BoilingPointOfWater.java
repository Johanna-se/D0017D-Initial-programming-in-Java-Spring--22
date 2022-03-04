/**
* From LTU: Task 4.2 - Continuation of relationship operations
* The boiling point of water is exactly 100 degrees. 
* For a certain immersion heater, you want to switch off the power supply when the immersion heater reaches the critical boiling point. 
* Write a program that, given a given temperature value, tells you when the power supply is on or off. 
* If the temperature is more than 100 degrees, the program should give an error message about incorrect temperature.
* If the temperature is exactly 100 degrees, the program should tell you that the water is boiling.
*
*pseudocode:
* initiate Scanner
* initiate constant BOILING_POINT
* initiate varible temperature
* Ask user for temperature of water
* If temperature < BOILING_POINT
*	print: the power is on and the water is heating up
* Else if temperature == BOILING_POINT
*	print: the power is off and the water is boiling
* Else
*	print: error, incorrect temperature
*
*/

import java.util.Scanner; // program uses class Scanner

class BoilingPointOfWater
{
	public static void main(String[] args)
	{
		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		//initiate constants
		final int BOILING_POINT = 100;

		//initiate variabls
		int temperature;

		// processing phase
		//ask user to input age
		System.out.print("What is the temperature of the water? (entered as an integer): ");
		temperature = input.nextInt();

		//Return to user 3 different outcome
		if (temperature < BOILING_POINT)
		{
			System.out.println("The power is on and the water is heating up ");
		}
		else if (temperature == BOILING_POINT)
		{
			System.out.println("The power is off and the water is boiling");
		}
		else
		{
			System.out.println("Error, incorrect temperature");
		}	
	}
}
