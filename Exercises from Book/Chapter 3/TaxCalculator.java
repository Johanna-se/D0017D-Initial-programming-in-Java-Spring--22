/**
*Exercise 3.20 From the book:
* Develop a Java application that determines the total tax for each of three
* citizens. The tax rate is 15% for earnings up to 30,000 USD earned by each citizen and 20% for all
* earnings in excess of that ceiling. You are given a list with the citizens’ names and their earnings in a
* given year. Your program should input this information for each citizen, then determine and display
* the citizen’s total tax. Use class Scanner to input the data.
*
*pseudocode:
* initiate Scanner
* initiate constants TAX_LOWER, TAX_HIGHER, TAX_BREAKING_POINT
* initiate varibles taxPayerCounter = 0, higherTaxLevel, earnings, tax
* while taxPayerCounter != 3 
* 	taxPayerCounter add 1
*	Print: "What is the earning of taxpayer " + taxPayerCounter
*	ernings = user input
*	if ernings <= TAX_BREAKING_POINT
*		tax = earnings * TAX_LOWER
*		Print "Tax for tax payer " + taxPayerCounter + " was " + tax 
*	else
*		higherTaxLevel = ernings - TAX_BREAKING_POINT
*		tax = (higherTaxLevel * TAX_HIGHER) + (TAX_BREAKING_POINT * TAX_LOWER)
*		Print "Tax for tax payer " + taxPayerCounter + " was " + tax 
*		
*/

import java.util.Scanner; // program uses class Scanner

class TaxCalculator
{
	public static void main(String[] args)
	{
		//create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		//initiate canstants
		final float TAX_LOWER = 0.15f; 
		final float TAX_HIGHER = 0.2f;
		final int TAX_BREAKING_POINT = 30000;

		//initiate variabls
		int higherTaxLevel;
		int earnings;
		int taxPayerCounter = 0;
		float tax = 0;
    
		// processing phase
		// loop until taxPayerCounter reaches 3
		while (taxPayerCounter != 3) 
		{
			//Add one to tax payers
			taxPayerCounter++;

			// Ask for earnings of taxpayer #taxPayerCounter from user
			System.out.print("What is the earning of taxpayer nummer " + taxPayerCounter + "?: ");
			earnings = input.nextInt();

			//if taxpayer only reaches the lower tax level
			if (earnings <= TAX_BREAKING_POINT)
			{
				tax = (float) earnings * TAX_LOWER;
				System.out.printf("Tax for taxpayer %d was %.2f.%n%n",  taxPayerCounter, tax );
			}
			//if taxpayer reaches the higher level
			else
			{
				higherTaxLevel = earnings - TAX_BREAKING_POINT;
				tax = ((float) higherTaxLevel * TAX_HIGHER) + ((float) TAX_BREAKING_POINT * TAX_LOWER);
				System.out.printf("Tax for taxpayer %d was %.2f.%n%n",  taxPayerCounter, tax );
			}
		} // exit loop
	}
}
