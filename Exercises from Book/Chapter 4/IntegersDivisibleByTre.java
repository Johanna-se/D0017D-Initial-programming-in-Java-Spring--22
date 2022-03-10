/**
*Exercise 4.12 From the book:
* Write an application that calculates the sum of those integers between
* 1 and 30 that are divisible by 3.
*
* pseudocode:
* initiate constant RANGE = 30
* initiate varibles sum = 0;
* for (int number = 1; number <= RANGE ; number++)
*	if (number%3 == 0)
*		sum = sum + number;
* print sum
*/

class IntegersDivisibleByTre
{
	public static void main(String[] args)
	{
		//initiate constants
		final int RANGE = 30;
    
		//initiate variabls
		int sum = 0;

		// processing phase
		for (int number = 1; number <= RANGE ; number++)
		{
			if (number % 3 == 0)
			{
				sum = sum + number;
			}
		}
		
		//return to user
		System.out.println (sum);
	}
}
