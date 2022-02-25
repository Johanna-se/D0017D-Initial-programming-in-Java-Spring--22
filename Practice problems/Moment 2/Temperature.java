/**
*Instructions
*
*The temperature task that was structured on Practice Problem 1 (Available only on Canvas) will now be partially implemented. 
*The basic structure is represented by the code in Main.java. 
*Fill in the code under the headings "declaration of variables", "start" and "print" while "processing" is saved to practice problem 4 (in moment 3, the next unit in replit).
*/

import java.util.Scanner; 

public class Temperature
{
  public static void main(String[] args) 
  {
	// declaration of variables
	int noOfDays, sum = 0, min = 100, max = -100, day = 1;

	// Start

	// Creating scanner object for reading from input stream 
	Scanner userInput = new Scanner(System.in);

	//Ask User for days
	System.out.print("Antal dagar i månaden?: ");
	noOfDays = userInput.nextInt();
	System.out.println(noOfDays); //TEST
	// processing
	// Print
	System.out.print("Månades max temperatur var " + max + " och min temperatur var " + min + " medans medeltemperaturen var " +sum);
  }
 }