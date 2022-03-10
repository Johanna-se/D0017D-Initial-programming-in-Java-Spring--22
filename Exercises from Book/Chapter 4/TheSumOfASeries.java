/**
* Exercise 4.13 From the book:
* (The Sum of a Series) Find the summation of the sequence of numbers 1, 2, 3 … n, where n
* ranges from 1 to 100. Use type long. Display the results in a tabular format that shows n and the corresponding
* sum. If this were a product instead of a sum, what difficulty might you encounter with the
* variable that accumulates the product?
*/

class TheSumOfASeries
{
	public static void main(String[] args)
	{
		//initiate constants
		final int RANGE = 100;
    
		//initiate variabls
		long sum = 0;

		// processing phase
		System.out.printf("%s%13s%n", "n:th number", "sum"); //Print a headline
		for (long number = 1; number <= RANGE ; number++)
		{
			sum = number + sum; 

			System.out.printf("%4d%20d%n", number, sum);
		}
	}
}
