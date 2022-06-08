/**
*
* psudocode
* create scanenr
* main method:
*    declare variables
*    print Welcome user
*    call method printRules
*    print: how many players?
*        howManyPlayers = Method inputInt()
*    Call method createPlayers (int howManyPlayers)
*    Call method createScoreArray (int howManyPlayers)
*    while (wouldLikeToExit != -1 & EndGame != true)
*        While (wouldLikeToExit != -1 & howManyThrows != 3) //A users turn
*            Method manageDice (array dice, valueToSave)
*            valueToSave = -2
*            while valueToSave == -2
*                Print: would you like to save any of the values on the dice?
*                valueToSave = Method inputChoseDice()
*                    if valueToSave == -1
*                        wouldLikeToExit = valueToSave
*                howManyThrows++
*        call Method displayScore
*        call Method addScore
*        if wouldLikeToExit != -1 //reset for next turn
*            print: would you like to continue to next player or exit (enter -1)?
*            wouldLikeToExit = Method input
*            Method resetDice (array dice)
*            valueToSave = 0
*            if playersTurn = howManyPlayers
*                playersTurn = 0
*            else
*                playersTurn++
*            howManyThrows = 0;
*            EndGame = Method shouldGameEnd (int [][] playerScores, int [] dice)
*            print here is the score
*            Call Method displayScore
*            print: next its is playersTurn time to play
*    call Method displayScore
*
*
*
* Method inputInt()
*    int answer
*    while answer = 0
*        if has next int
*            answer = user input
*        Else
*            give error 
*            answer = 0
*        readnextline
*    return answer
*
* Method inputChoseDice()
*    call method inputInt()
*    switch
*        case: -1-6
*            break
*        default:
*            print error
*            answer = 0
*    return answer
*
* Method printRules
*
* Method createPlayers (int howManyPlayers)
*    create array with number of player slots
*    for loop array.lenght
*        enter player name
*    return array playerName
*
* Method createScoreArray (int howManyPlayers)
*    create [9][howManyPlayers] array playerScores
*    return array playerScores
*
* Method manageDice (array dice, valueToSave)
*    int howManyDice = 5
*    int thisThrow
*    if valueToSave !=0
*        howManyDice = 5-dice[valueToSave-1]
*    while howManyDice > 0
*        thisThrow = Method throwDice
*        dice[thisThrow-1]++
*        howManyDice--
*    print array dice
*
* Method throwDice
*    int throwValue
*    throwValue random number 1-6
*    return throwValue
*
* Method displayScore (int array playerScores, Strint [] playerName, Strint [] scoreLable)
*    for-loop playerName-array
*        print all playerName
*    for-loop playerScores
*        print playerScores
*
* Method addScore (int array playerScores,array dice ,boolean GameEnd,int playersTurn, String [] playerName)
*    int userChoice
*    boolean succsess = false
*    if GameEnd = true
*        Add final score and bonus to playerScores [8-9][all players]
*    else
*        while succsess == false
*            Print: where would you like to add your score?
*            userChoice = user input
*            if userChoice playerScores [playersTurn][userChoice] == 0
*                playerScores [playersTurn][userChoice] = dice [userChoice]
*                succsess = true
*            else
*                give error, let user try again
*
* Method resetDice (array dice, valueToSave)
*    for dice.lengt
*        dice = 0
*
* Method shouldGameEnd (int array playerScores)
*    GameEnd = true
*    if playerScores != full
*        GameEnd = false
*    if GameEnd = true
*        playersTurn = 0
*        Call Method addScore (int array playerScores,array dice ,boolean, GameEnd, playersTurn)
*    return GameEnd
*        
*
* @author Johanna Petersson
*/

import java.util.Scanner; // program uses class Scanner
import java.lang.Math;

class Main
{
    private static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args)
    {
        //declare variables
        int howManyThrows = 0;
        int valueToSave = 0;
        int howManyPlayers = 0;
        int wouldLikeToExit = 0;
        int playersTurn = 0;
        boolean endGame = false;
        
        int [] dice = new int[7];
        int [][] playerScores;
        String [] playerName;
        String [] scoreLable = new String [9];

        //Welcome user and print rules
        System.out.printf("_________________________________________%n"); 
        System.out.printf("%nWELCOME TO BEGINNERS YATSY!!%n");
        System.out.printf("_________________________________________%n");
        printRules();

        //How many players?
        System.out.printf("First things first, how many of you are playing? ");
        while (howManyPlayers <= 0)
        {
            howManyPlayers = inputInt();
            if (howManyPlayers <= 0)
                System.out.printf("%nYou can not be a negative amount of players. Please try again: ");
        }

        //create arrays for the players
        playerName = createPlayers (howManyPlayers);
        playerScores = createScoreArray (howManyPlayers, scoreLable);
        

        //run game
        while (wouldLikeToExit != -1 & endGame != true)
        {
            //users turn
            while (wouldLikeToExit != -1 & howManyThrows != 3)
            {
                //Throw dice
                manageDice (dice, valueToSave);
                valueToSave = -2;
                
                //Ask user what to save
                while (valueToSave == -2)
                {
                    
                     System.out.printf("%nWould you like to save any of the values on the dice? (To re-throw all enter 0 and to quit enter -1) ");   
                    valueToSave = inputChoseDice();
                    //check if quit
                    if (valueToSave == -1)
                    {
                        wouldLikeToExit = valueToSave;
                    }
                    else if (valueToSave > 0)
                    {
                        System.out.printf("%nAll the %d will be saved.%n", valueToSave);
                    }
                    else
                    {
                        System.out.printf("%nAll the dice will be re-thrown");
                    }
                }
                howManyThrows++;
            }//exit while-loop users turn

            //resets stats for next rount
            if (wouldLikeToExit != -1)
            {
                //Handel the new score
                displayScore (playerScores, playerName, scoreLable);
                addScore (playerScores, dice , endGame, playersTurn, playerName);

                //Next player or quit?
                System.out.printf("%nWould you like to continue to next player (enter 2) or exit (enter -1)?.");
                wouldLikeToExit = inputInt();

                if (wouldLikeToExit != -1)
                {
                    //resets stats for next rount
                    valueToSave = 0;
                    resetDice (dice, valueToSave);
                    howManyThrows = 0;

                    //next player
                    if (playersTurn == howManyPlayers-1)
                    {
                        playersTurn = 0;
                    }
                    else 
                    {
                        playersTurn++;
                    }

                    //boolean end game
                    endGame = shouldGameEnd (playerScores, dice, playerName);

                    if (endGame != true)
                    {
                        System.out.printf("%nHere is the current score:");
                        displayScore (playerScores, playerName, scoreLable);

                        System.out.printf("%nNext its is %ss time to play.", playerName[playersTurn]); 
                    }
                }
            }
        }//exit while-loop game
        System.out.printf("%nThank you for playing. Here is the final score: ");
        displayScore (playerScores, playerName, scoreLable);         
    }


    
    /**
    * Method for geting the users input. will return a int, give error if not a int.
    * @return answer - int
    */  
    public static int inputInt()
    {
        int answer = 0;
        //loop for input of data
        while (answer == 0)
        {    
            //If the user has inputed a interger value
            if (userInput.hasNextInt())
            {
                answer = userInput.nextInt(); 
                userInput.nextLine(); 
            }
             // if user enters incorrect value  
            else
            {
                System.out.printf("Invalid entry. Please enter an interger: ");
                userInput.nextLine(); 
                answer = 0;
            }
        } 
        return answer;   
    }


    /**
    * Method for geting the users input of what dice.
    * @return answer - int users chosen dice
    */  
    public static int inputChoseDice()
    {
        int answer = 0;
        //loop for input of data
        while (answer == 0)
        {    
            answer = inputInt();

            switch (answer)
            {
                case -1:
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:    
                    break;
                default:
                    System.out.printf("%nIn correct entry, please chose 0-6 (-1): ");
                    answer = 0; 
            }  
        } 
        return answer;   
    }
    
    /**
    * Method for printing the rules.
    */  
    public static void printRules()
    {
        System.out.printf("%nHere are the rules:");
        System.out.printf("%nFive dice till be thrown, you can choose which to keep and which to toss again.");
        System.out.printf("%nExample: you get 1 , 2 , 6 , 6 , 6. You choose to keep the 6es and rethrow the 1 and 2.");
        System.out.printf("%nYou have a total of 3 throws to get as many of one sort as possible.%n");
        System.out.printf("%nYou then choose which number to save the results too.");
        System.out.printf("%nExample if you get 4 6es and choose to store them in the score-sheat, you will get a score of 24 points (6*4).");
        System.out.printf("%nBUT! you can only choose each number ones. So after you have stored the 6es you can not store the results again if you were to get 5 of them later.%n");
        System.out.printf("%nThe winner is the one with the highest score");
        System.out.printf("%nOh! and you get a bonus of 50 points if you reach a total of 63 or more.");
        System.out.printf("%nLetse begin.%n%n");
    }

    /**
    * Method for getting and storing the players names. 
    * @param howManyPlayers - int
    * @return String[]playerName - an array with the players names
    */ 
    public static String[] createPlayers (int howManyPlayers)
    {
        String [] playerName = new String [howManyPlayers];

        //Ask user to enter player name
        for (int i = 0; i < playerName.length; i++)
        {
            System.out.printf("Please enter %d players name: ", i+1);
            playerName[i] = userInput.nextLine();
        }
        return playerName;
    }

    /**
    * Method for creating an score array with reqired numbers of players
    * playerScores [0] = ones
    * playerScores [1] = twos
    * playerScores [2] = threes
    * playerScores [3] = foures
    * playerScores [4] = fives
    * playerScores [5] = sixes
    * playerScores [6] = Summe
    * playerScores [7] = Bonus
    * playerScores [8] = Total points
    *
    * @param howManyPlayers - int
    * @param howManyPlayers - int
    * @return playerName - int [][]
    */ 
    public static int[][] createScoreArray (int howManyPlayers, String[]scoreLable)
    {
        //create the score array
        int [][] playerScores = new int[9][howManyPlayers];

        //sett all to -2, our default value.
        for (int i = 0; i < playerScores.length; i++)
        {
            for (int j = 0; j < playerScores[i].length; j++)
            {
                playerScores[i][j] = -2;
            }
        }

        //create lable-array to accopany score-array
        scoreLable [0] = "Ones";
        scoreLable [1] = "Twos";
        scoreLable [2] = "Threes";
        scoreLable [3] = "Foures";
        scoreLable [4] = "Fives";
        scoreLable [5] = "Sixes";
        scoreLable [6] = "Summe";
        scoreLable [7] = "Bonus";
        scoreLable [8] = "Total points";

        return playerScores;
    }

    /**
    * Method for managing the dice //FIX!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    * @param dice - int []
    * @param valueToSave - int, the value the users wishes to save ex all 6es.
    */
    public static void manageDice (int[]dice, int valueToSave)
    {
        int howManyDice = 5;
        int howManyToSave;
        int thisThrow;

        //How many dice to throw
        if (valueToSave > 0)
        {
            howManyDice = 5-dice[valueToSave];
        }

        //reset dice, NOTE not the value to save
        resetDice (dice, valueToSave);

        //Make the throw
        while (howManyDice > 0)
        {
            thisThrow = throwDice ();
            dice[thisThrow]++;
            howManyDice--;
        }

        //print the dice
        System.out.printf("The dice are: ");
        for (int i = 0; i < dice.length; i++) 
        {
            if (dice[i] > 0)
            {
                for (int j = 0; j < dice[i]; j++)
                {
                    System.out.printf("%d, ", i);
                }
            }
        }
    }

    /**
    * Method for the simulates a thrown dice
    * @return throwValue
    */
    public static int throwDice ()
    {
        int throwValue;

        //randomize a number 1-6
        throwValue = (int) (Math.random () * 6) +1; 

        return throwValue;
    }

    /**
    * Method for printing the current score
    * @param playerScores - int[][]
    * @param playerName - Strint[]
    */
    public static void displayScore (int[][] playerScores, String[]playerName, String[]scoreLable)
    {
        System.out.printf("%n"); //New line for readability
        
        //Print names
        System.out.printf("%-15s", "         "); //Space for readability
        for (int i = 0; i < playerName.length; i++)
        {
            System.out.printf("%-15s", playerName[i]);
        }

        //Print Scores
        for (int i = 0; i < playerScores.length; i++)
        {
            System.out.printf("%n%-15s ", scoreLable[i]);
            for (int j = 0; j < playerScores[i].length; j++)
            {
                if (playerScores[i][j] == -2)
                {
                    System.out.printf("%-15c", '-');
                }
                else
                {
                    System.out.printf("%-15d ", playerScores[i][j]);
                }
                
            }
        }
    }


    /**
    * Method for ADD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    * @param playerScores - int[][]
    * @param playerName - Strint[]
    */
    public static void addScore (int [][] playerScores, int [] dice, boolean gameEnd, int playersTurn, String[]playerName)
    {
        int userChoice;
        boolean succsess = false;

        if (gameEnd == true)
        {
            //Check which players has a summe above 63, if so give bonus.
            for (int i = 0; i < playerScores[6].length; i++)
            {
                if (playerScores[6][i] >= 63)
                {
                    playerScores[7][i] = 50;
                    System.out.printf("%s got a bonus!", playerName[i]);
                }
            }
        }
        else
        {
            while (succsess == false)
            {
                System.out.printf("%nWhere would you like to add your score, %s? ", playerName[playersTurn]);
                userChoice = inputChoseDice();
                if (playerScores [userChoice-1][playersTurn] == -2)
                {
                    playerScores [userChoice-1][playersTurn] = dice [userChoice] * userChoice;
                    succsess = true;
                }
                else
                {
                    System.out.printf("incorrect entry, please choose again: ");
                }
            }
        }
    }

    /**
    * Method for ADD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    * @param int[] dice
    * @param int valueToSave
    */
    public static void resetDice (int[] dice, int valueToSave)
    {
        for (int i = 0; i < dice.length; i++)
        {
            if(i != valueToSave)
            {
                dice[i] = 0;
            }
        }
    }

    /**
    * Method for ADD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    * @param int[] dice
    * @param int valueToSave
    */
    public static boolean shouldGameEnd (int [][] playerScores, int [] dice, String[]playerName)
    {
        boolean isScoreFull = true;
        int playersTurn;

        //Check if all the numbers have a score
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < playerScores[i].length; j++)
            {
                if (playerScores[i][j] == -2)
                {
                    isScoreFull = false;
                }
            }
        }

        //Adds the final score
        if (isScoreFull == true)
        {
            playersTurn = 0;
            addScore (playerScores, dice ,isScoreFull, playersTurn, playerName);
        }

        return isScoreFull;
        
    }
}
