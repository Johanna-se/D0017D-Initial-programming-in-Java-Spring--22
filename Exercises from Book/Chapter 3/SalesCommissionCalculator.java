/**
*Exercise 3.19 From the book:
*A large company pays its salespeople on a commission basis.
*The salespeople receive $200 per week plus 9% of their gross sales for that week. For example, a
*salesperson who sells $5,000 worth of merchandise in a week receives $200 plus 9% of $5,000, or
*a total of $650. You’ve been supplied with a list of the items sold by each salesperson. The values of
*these items are shown in Fig. 3.15. Develop a Java application that inputs one salesperson’s items
*sold for last week and calculates and displays that salesperson’s earnings. There’s no limit to the number
*of items that can be sold.
* Figur 3.15:
*	Item 	Value
*	1 		239.99
*	2 		129.75
*	3 		99.95
*	4 		350.89
*
*pseudocode:
*1. initiate Scanner
*2. Initiate constants BAS_SALERY = 200, ITEM_ONE = 239.99, ITEM_TWO = 129.75, ITEM_TRE = 99.95 , ITEM_FOUR = 350.89, PERCENT_COMMISSION = 0,09
*3. Initiate varibles totalSale = 0, totalSalery, percentOfSale, itemCounter
*4. As user: "Would you like to add an item? To do so enter number 1-4, to exit enter -1"
*5.		itemCounter = user input
*6. While itemCounter != -1 (use nested if...else)
*7. 	if itemcounter = 1
*8.			totalSale += ITEM_ONE
*9.			else itemCounter = 2
*10.			totalSale += ITEM_TWO
*11.			else itemCounter = 3
*12.				totalSale += ITEM_TRE
*11.				else itemCounter = 4
*12.					totalSale += ITEM_FOUR
*13.					else
*14.						print "Not a valid item number, the correct items are 1, 2, 3 and 4."
*15. 	As user: "Would you like to add an item? To do so enter number 1-4, to exit enter -1"
*16.		itemCounter = user input
*17. Calculate: percentOfSale = totalSale * PERCENT_COMMISSION
*18. Calculate the persons salery as totalSalery = BAS_SALERY + percentOfSale
*19. Print: "The total sale was " + totalSale + " which generated a commision of " + percentOfSale + "."
*20. Print: "The final salery was " + totalSalery + "."
*/

import java.util.Scanner; // program uses class Scanner

class SalesCommissionCalculator
{
	public static void main(String[] args)
	{
		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);
		
		//initiate canstants
		final float BAS_SALERY = 200f;
		//Sett constants of item prices
		final float ITEM_ONE = 239.99f;
		final float ITEM_TWO = 129.75f;
		final float ITEM_TRE = 99.95f;
		final float ITEM_FOUR = 350.89f;
		//Sett contant for 9% commission of total sale
		final float PERCENT_COMMISSION = 0.09f;

		//initiate variabls
		float totalSale = 0f;
		float totalSalery = 0f;
		float percentOfSale = 0f;
		int itemCounter;

    
		// processing phase
		// prompt for input and read item number from user
		System.out.print("Would you like to add an item? To do so enter number 1-4, to exit enter -1: ");
		itemCounter = input.nextInt();

		// loop until sentinel value read from user
		while (itemCounter != -1) 
		{
			//Add the choosen item to total sale with nested if ... else statements
			if (itemCounter < 2)
			{
				totalSale += ITEM_ONE;
			}
			else 
			{
				if (itemCounter < 3) 
				{
				totalSale += ITEM_TWO;
				}
				else 
				{
					if (itemCounter < 4)
					{
						totalSale += ITEM_TRE;
					}
					else 
					{
						if (itemCounter < 5)
						{
							totalSale += ITEM_FOUR;
						}
						//if not entered correctly
						else 
						{
							System.out.println("Not a valid item number, the correct items are 1, 2, 3 and 4.");
						}
					}
				}
			} //exit nested added items
			System.out.print("Would you like to add an item? To do so enter number 1-4, to exit enter -1: ");
			itemCounter = input.nextInt();
		} // exit total sales loop
    
		//Calculations commission and total salery
		percentOfSale = totalSale * PERCENT_COMMISSION;
    
		totalSalery = BAS_SALERY + percentOfSale;
    

		//termination phase, return to user
		System.out.println(); // added line for readability 
		System.out.printf("The total sale was %.2f which generated a commision of %.2f. %n" , totalSale, percentOfSale );
		System.out.printf("The final salery was %.2f . %n", totalSalery);
	}
}
