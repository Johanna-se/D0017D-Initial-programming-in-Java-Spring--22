/**
* the teachers solution to the Social Security Number
*
* Check if the last digit of the social security number is correct
* Susanne Fahlman
*/

import java.util.Scanner; // program uses class Scanner

class SocialSecurityNumberTeacher
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner (System.in);

		int sum = 0; // Used to sum all the numbers

		long socSecNr; // Entered social security number
		long divider = 1000000000; // Used to share the remaining social security number with
		// to isolate the first digit socSecNr

		// Input
		System.out.print ("Enter your social security number (10 digits)");
		socSecNr = in.nextLong ();

		// Go through the first nine digits
		for (int i = 1; i <10; i ++)
		{
			// Retrieves the first digit in socSecNr
			int nextDigit = (int) (socSecNr / divider);

			// Multiply every other digit by 2 and every other by 1 more with digit number 9 in the order.
			// The first digit must be multiplied by 2.
			if (i % 2 != 0) // Odd numbers give true
			{
				nextDigit = nextDigit * 2;

				// If a result after the multiplication is over 9 then delete the tens
				// and keep the singular and add 1.
				if (nextDigit> 9)
				{
					// Delete the tens
					nextDigit = nextDigit % 10;
					// Add with 1
					nextDigit = nextDigit + 1;
				}
			}

			// Add the number to the sum
			sum = sum + nextDigit;

			// Delete the number that is finished
			socSecNr = socSecNr% divider;

			// Remove a zero from the divider because socSecNr is now one digit shorter before the next round
			divider = divider / 10;
		}

		// Calculation of the check digit according to: 10-singular
		int controlNr = 10 - (sum% 10);

		// Special case, the calculated check digit will be 10 if it were 0
		if (controlNr == 10)
			controlNr = 0;

		// Checks for equals and presents the result
		// NOTE, socSecNr now contains only the last digit
		if (controlNr == socSecNr)
			System.out.println ("The social security number is correct!");
		else
			System.out.println ("The social security number is incorrect!");
    
		in.close ();
	}
}