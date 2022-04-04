/**
* The program simulates the dice game 12
* The game consists of three dice and involves the sum of 12 (on any number of dice)
* in each round. Each dice can only be rolled once per round.
*
* pseudocode:
* initiate Scanner
* Declar and initiate variabls
* Print a greeting to user
* while (diceRoll is not q)
*   while (sum not 12 And/Or sumDice is 0)
*      Ask user to choose a dice [1,2,3] or quit [q], store input in diceRoll
*      switch (diceRoll)
*        case 1 - 3 
*          roll dice (if not done before) and add it to sum, else error message
*        case q
*          Set sumDice = 1 so that both the while-loops exits
*        default
*          Print: error message
*        //End switch
*      count wins and losses
*      if (diceRoll is not q)
*        print: results of roll 
*        calculate to see if all dice have been rolled 
*    //exit while loop 
*    reset varibles for next round
*    Print: Next round! (if user has not entered "q")
*  //Exit while loop
* Print: Game Over! and exit program
* 
*  author: Johanna Petersson @ojoepe
*/

import java.util.Scanner; 
import java.lang.Math;  

class DiceGame 
{
  public static void main(String[] args) 
  {
    //initiation phase
    //create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);
    
    //Declar and initiate variabls
    char diceRoll = '0';
    int sum = 0;
    int diceOne = 0;
    int diceTwo = 0;
    int diceThree = 0;
    int win = 0;
    int loss = 0;
    int sumDice = 0;


    
    // processing phase
    //initial greetint to the user
    System.out.printf("Welcome to the game 12. You must roll 1-3 dice and try to get the sum 12 ...%n");

   
    //Loop that exits when user input = q, ending the game
    while (diceRoll != 'q')
    {
      //Loop that exits when sum = 12 (a win) or all the dice are rolled, ending the round
      while ((sum != 12) & (sumDice == 0))
      {
        //Ask user what dice [1,2,3] or to quit [q], store in diceRoll
        System.out.printf("Enter which dice you want to roll [1,2,3] (exit with q): ");
			  diceRoll = input.next().charAt(0);        


        //Use a switch for the 5 possible outcomes of diceRoll
        switch (diceRoll)
        {
          //Dice one is choosen by user
          case '1': 
            //if diceOne is 0, the dice has not been rolled
            if (diceOne == 0) 
            {
              //rolls the dice
              diceOne = (int) (Math.random () * 6) +1;
              //add dice 1 too sum
              sum = sum + diceOne; 
            }
            //error message if diceOne has a value other than default
            else 
            {
              System.out.printf("You have already rolled dice 1, please try again%n");
            }
            break;
          
          //Dice two is choosen by user, for comments see case 1  
          case '2': 
            if (diceTwo == 0) 
            {
              diceTwo = (int) (Math.random () * 6) +1;
              sum = sum + diceTwo; 
            }
            else 
            {
              System.out.printf("You have already rolled dice 2, please try again%n");
            }
            break;

          //Dice three is choosen by user, for comments see case 1
          case '3': 
            if (diceThree == 0) 
            {
              diceThree = (int) (Math.random () * 6) +1; 
              sum = sum + diceThree; 
            }
            else 
            {
              System.out.printf("You have already rolled dice 3, please try again%n");
            }
            break; 

          //if user wishes to quit
          case 'q': 
            //sets sumDice to 1 so that the while-loop exits
            sumDice = 1; 
            break; 
          
          //if not a valid entry by user, prompt to try again  
          default: 
            System.out.printf("Not a valid entry, please try again%n");
            break;  
        } //end switch


        //Set up for the result of the roll
        //count wins and losses
        if (sum == 12)
        {
          win++;
        }
        else if (sum > 12)
        {
          loss++;
        }

        // Avoids if user has entered "q"
        if (diceRoll != 'q') 
        {
          //Print the results of the roll
          System.out.printf("%d %d %d sum: %d #win: %d #loss: %d%n", diceOne, diceTwo, diceThree, sum, win, loss );
          
          //calculate the dice to see if all have been rolled (none has default value 0)
          //NOTE: if this is outside of the if-statement the value from switch case q is overwritten and user cannot exit
          sumDice = diceOne * diceTwo * diceThree;
        }

      } //exit while-loop #2 and end of round


      //Set up for next round
      //reset variabls
      sum = 0;
      sumDice = 0;
      diceOne = 0;
      diceTwo = 0;
      diceThree = 0;
    
      //message for next round, avoids if user has entered "q"
      if (diceRoll != 'q')
      {
        System.out.printf("%nNext round!%n");
      }

      
    } //exit while-loop #1 and end of game

    
    //termination phase
    System.out.printf("Game Over!");
  }
}
