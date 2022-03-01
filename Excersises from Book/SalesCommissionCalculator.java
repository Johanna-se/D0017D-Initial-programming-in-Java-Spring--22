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
*6. While itemCounter != -1
*7. 	if itemcounter = 1
*8.			totalSale += ITEM_ONE
*9.		if itemCounter = 2
*10.		totalSale += ITEM_TWO
*11.	if itemCounter = 3
*12.		totalSale += ITEM_TRE
*11.	if itemCounter = 4
*12.		totalSale += ITEM_FOUR
*13.	Else
*14.		print "Not a valid item number, the correct items are 1, 2, 3 and 4."
*15. 	As user: "Would you like to add an item? To do so enter number 1-4, to exit enter -1"
*16.		itemCounter = user input
*17. Calculate: percentOfSale = totalSale * PERCENT_COMMISSION
*18. Calculate the persons salery as totalSalery = BAS_SALERY + percentOfSale
*19. Print: "The total sale was " + totalSale + "which generated a commision of " + percentOfSale + "."
*20. Print: "The final salery was " + totalSalery + "."
*/

import java.util.Scanner; // program uses class Scanner

class SalesCommissionCalculator
{
	public static void main(String[] args)
	{
	}
}