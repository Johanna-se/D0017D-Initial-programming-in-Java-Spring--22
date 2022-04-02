/**
* From LTU: Arrays - Roll of dice
*Instructions
*
* Modify the dice program from the previous unit/moment on Logic, so that the frequency calculation is done using an array.
*
*pseudocode:
* initiate Scanner
* initiate constants MAX=6 MIN=1
* initiate varibles numberOfRolls, diceRoll
* initiate array "result"
* print: ask user for number of dice rolls
*	numberOfRolls = user input
* for (counter = 1; counter <= numberOfRolls, counter++)
*	Roll the dice with: diceRoll = (int) (Math.random () * (MAX-MIN+1) +MIN;
*	print: diceRoll
*	Uppdate static with:
*	if (diceRoll = 1)
*		add one to first array object
*   use "else if" and "else" to do the same for the other possible rolls
* print the number of 1-6 rolls with a for loop
*   print lable ex "1:"
*   use another for loop to print the #
*/

import java.util.Scanner; // program uses class Scanner
import java.lang.Math;  // program uses class Math

class RollTheDiceTwo
{
	public static void main(String[] args)
	{
        //create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);

        //initiate variabls and constants
        final int MAX = 6; //number of sides on the dice
        final int MIN = 1; // for calculate of random roll

        int numberOfRolls;
        int diceRoll;

        //declare and initiate array
        int [] result = new int[6];

        //processing phase
        //Ask user for number of rolls to make
        System.out.print("Number of rolls: ");
		    numberOfRolls = input.nextInt();

        //roll the dice, count and print the throws
        for (int counter = 1; counter <= numberOfRolls; counter++)
        {
            diceRoll = (int) (Math.random () * (MAX-MIN+1) +MIN);

            //print the roll
            System.out.print(diceRoll + " ");

            //static of rolls
            if (diceRoll == 1)
            {
                //adds one to the first array object
                result[0]++;
            }
            else if (diceRoll == 2)
            {
                result[1]++;
            }
            else if (diceRoll == 3)
            {
                result[2]++;
            }
            else if (diceRoll == 4)
            {
                result[3]++;
            }
            else if (diceRoll == 5)
            {
                result[4]++;
            }
            else
            {
                result[5]++;
            }
        }//Exit dice roll loop
    
        //print results
        //for each array (result-array) element output a bar of the chart
        for (int counter = 0; counter < result.length; counter++)
        {
            //print lable
            System.out.print(counter+1 +": ");

            //print bar of #
            for (int symbol = 0; symbol < result[counter]; symbol++)
            {
                System.out.print("#");
            }

            System.out.println();
        } //exit loop for printing results
    
	}
}
