/**
* Exercise 4.14 From the book:
* (Modified Compound-Interest Program) Modify the compound-interest application of
* Fig. 4.6 to repeat its steps for interest rates of 5%, 6%, 7%, 8%, 9% and 10%. 
* Use a for loop to vary the interest rate.
*
*/

class ModifiedCompoundInterestProgram
{
	public static void main(String[] args)
	{
		//initiate variabls
		double principal = 1000.0; // initial amount before interest
		double rate = 0.05; // initial interest rate

		// loop for increasing rate of: 5% - 10 %
		for (; rate <=0.1; rate = rate + 0.01)
		{
			// display headers
			System.out.printf("%n%s%.2f%n", "With an interest rate of " , rate);
			System.out.printf("%s%20s%n", "Year", "Amount on deposit");

      
			// calculate amount on deposit for each of ten years
			for (int year = 1; year <= 10; ++year) 
			{
				// calculate new amount on deposit for specified year
				double amount = principal * Math.pow(1.0 + rate, year);

				// display the year and the amount
				System.out.printf("%4d%,20.2f%n", year, amount);
			}
		}
	}
}
