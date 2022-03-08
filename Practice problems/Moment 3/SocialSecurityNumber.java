/**
*
* From LTU:Logic - Social Security Number
* Instructions
*
* Make a program that checks if the last digit of a social security number is correct. 
* The check is made according to the following algorithm:
*
* We take the example as
*
*    Multiply every other digit by 2 and every other by 1 through digit number 9 in the sequence. The first digit must be multiplied by 2.
*
*       Example: The first 9 digits of the personal number 771122-445
*
*        After this step, it will be 14, 7, 2, 1, 4, 2, 8, 4, 10
*
*   If a result after the multiplication is over 9, then delete the ten, keep the singular and add 1.
*
*        Now it is will be 5, 7, 2, 1, 4, 8, 4, 1
*    Now add all the numbers.
*
*        it will be 34
*
*    Keep only the ending number
*
*        it will be 4
*
*    Subtract the number from 10 and you have obtained the last digit in the social security number.
*
*        It will be 10 - 4 = 6
*
*The correct social security number for the example is thus: 771122-4456 
*Special case: if the last digit is to be 0 then 10-0 = 10 which is to be translated to the last digit 0
*
*pseudocode:
* initiate Scanner
* initiate varibles (long)socialNumber, (long) divider, (int)nextDigit, (int) sum = 0; (int) controlNumber
* Ask user for social security number
* 	socialNumber = user input
* for (int counter = 0, counter < 10; counter++)
*	nextDigit = (int)socialNumber / divider
*	if (counter % 2 != 0)
*		nextDigit = nextDigit*2
*	if (nextDigit > 9)
*		nextDigit = (nextDigit % 10) + 1
*	sum = sum + nextDigit
*	socialNumber = socialNumber % divider;
*	divider = divider / 10
* controlNumber = 10 - (sum%10)
* if (controlNumber == 10)
*	controlNumber = 0
* if (socialNumber == controlNumber)
* 	print: correct social number
*else
* 	print: incorrekt social number
*/

import java.util.Scanner; // program uses class Scanner

class SocialSecurityNumber
{
	public static void main(String[] args)
	{
		//create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		//initiate variabls
		long socialNumber;
		long divider = 1000000000;
		int nextDigit;
		int sum = 0;
		int controlNumber;

		// processing phase
		// ask for users input of social security number
		System.out.print("Enter the Social Security Number you wish to check (format 9001010000): ");
		socialNumber = input.nextLong();

		// loop the digits and process them
		for (int counter = 0; counter < 10; counter++)
		{
			//get the next digit 
			nextDigit = (int) (socialNumber / divider);

			//true if counter is an odd number
			if (counter % 2 == 0)
			{
				nextDigit = nextDigit *2;
        
				//check if next digit is larger or equel to 10, extract the remainder and add
				if (nextDigit > 9)
				{
					nextDigit = (nextDigit % 10) +1; 
				}  
			} //exit if-statement for odd numbers
      
		//sum of the digits
		sum = sum + nextDigit;

		// remove the current digit from social number
		socialNumber = socialNumber % divider;

		//adjust the divider
		divider = divider /10;
      
		} //exit loop
    
		//calculate the control number
		controlNumber = 10 - (sum % 10);

		//special if control number is 10
		if (controlNumber == 10)
		{
			controlNumber = 0;
		}

		//print result to user
		// OBS, socialNumber only last digit
		if (controlNumber == socialNumber)
			System.out.println ("correct social number");
		else
			System.out.println ("incorrekt social number");
	}
}
