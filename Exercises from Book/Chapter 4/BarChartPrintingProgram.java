/**
* Exercise 4.16 From the book:
* (Bar-Chart Printing Program) One interesting application of computers is to display
* graphs and bar charts. Write an application that reads five numbers between 1 and 30. For each
* number that’s read, your program should display the same number of adjacent asterisks. For example,
* if your program reads the number 7, it should display *******. Display the bars of asterisks after
* you read all five numbers.
*/

import java.util.Scanner; // program uses class Scanner

class BarChartPrintingProgram
{
	public static void main(String[] args)
	{
		//create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);
    
		//initiate variabls
		int numberOne;
		int numberTwo;
		int numberTre;
		int numberFour;
		int numberFive;
    
		//Ask user for the 5 numbers

		System.out.print("Enter first digit: ");
		numberOne = input.nextInt();

		System.out.print("Enter second digit: ");
		numberTwo = input.nextInt();   

		System.out.print("Enter third digit: ");
		numberTre = input.nextInt(); 

		System.out.print("Enter fourth digit: ");
		numberFour = input.nextInt(); 

		System.out.print("Enter fifth digit: ");
		numberFive = input.nextInt(); 


		//Print the bars

		//First bar
		System.out.println("\nFirst bar:"); //header
		// loop for printing the first number as a bar
		for (int counter = 1; counter <= numberOne ; counter++)
		{
			System.out.print("*");
		}

		//second bar
		System.out.println("\n\nSecond bar:");
		// loop for printing the second number as a bar
		for (int counter = 1; counter <= numberTwo ; counter++)
		{
			System.out.print("*");
		}

		//Third bar
		System.out.println("\n\nThird bar:");
		// loop for printing the third number as a bar
		for (int counter = 1; counter <= numberTre ; counter++)
		{
			System.out.print("*");
		}


		//Fourth bar
		System.out.println("\n\nFourth bar:");
		// loop for printing the fourth number as a bar
		for (int counter = 1; counter <= numberFour ; counter++)
		{
			System.out.print("*");
		}

		//Fifth bar
		System.out.println("\n\nFifth bar:");
		// loop for printing the fifth number as a bar
		for (int counter = 1; counter <= numberFive ; counter++)
		{
			System.out.print("*");
		}
	}
}
