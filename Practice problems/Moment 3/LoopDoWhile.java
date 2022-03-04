/**
* From LTU: Task 4.7 - The Do-While construction
* For a given loop, you always want to run the loop at least once 
* before the user's input of an integer causes the loop to end. 
* Enter the following example on your own and see that the loop is 
* run at least one lap before the condition is checked.
*
* int number = 0; 
* do 
* { 
*    System.out.print ("Enter an integer:"); 
*    tal = userInput.nextInt (); 
*    System.out.println ("Number:" + number); 
* } while (number > 0);
*
*/

import java.util.Scanner; // program uses class Scanner

class LoopDoWhile
{
	public static void main(String[] args)
	{
		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);
		
		//initiate variabls
		int number = 0; 
		
		// processing phase
		do 
		{ 
			System.out.print ("Enter an integer: "); 
			number = input.nextInt(); 
			System.out.println ("Number: " + number); 
		} while (number > 0);
	}
}
