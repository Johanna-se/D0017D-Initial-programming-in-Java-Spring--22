/**
* From LTU: Task 4.3 - Several logical expressions for the same variable
* A kiosk sells scoops of ice cream in the variants one, two or three scoops. 
* A girl who wants to buy one of the variants has a limited weekly allowance. 
* She can therefore buy one of the three variants only if she has enough money. 
* Create a program that gives the girl's weekly allowance and the prices below show which variants the girl can buy.
*
*    1 scoop - 10 kr
*    2 scoops - 15 kr
*    3 scoops - 20 kr
*
*pseudocode:
* initiate Scanner
* initiate constant ONE_SCOOP, TWO_SCOOP, TRE_SCOOP
* initiate varible weeklyAllowance
* Ask user for weekly allowance
* If weeklyAllowance < ONE_SCOOP
*	print: Sorry, you cannot buy any ice cream.
* Else if weeklyAllowance < TWO_SCOOP
*	print: You can buy one scoop of ice cream. It costs 10 kr.
* Else if weeklyAllowance < TRE_SCOOP
*	print: You can buy two scoops of ice cream. It costs 15 kr.
* Else
*	print: You can buy tre scoops of ice cream. It costs 20 kr.
* 
*/

import java.util.Scanner; // program uses class Scanner

class ScoopsOfIceCream
{
	public static void main(String[] args)
	{
		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		//initiate constants ice cream prices
		final int ONE_SCOOP = 10;
		final int TWO_SCOOP = 15;
		final int TRE_SCOOP = 20;

		//initiate variabls
		int weeklyAllowance;

		// processing phase
		//ask user to input weekly allowance
		System.out.print("What is your weekly allowance?: ");
		weeklyAllowance = input.nextInt();

		//Return to user 4 different outcome
		if (weeklyAllowance < ONE_SCOOP)
		{
			System.out.println("Sorry, you cannot buy any ice cream.");
		}
		else if (weeklyAllowance < TWO_SCOOP)
		{
			System.out.println("You can buy one scoop of ice cream. It costs 10 kr.");
		}
		else if (weeklyAllowance < TRE_SCOOP)
		{
			System.out.println("You can buy two scoops of ice cream. It costs 15 kr.");
		}
		else
		{
			System.out.println("You can buy tre scoops of ice cream. It costs 20 kr.");
		}
	}
}
