/**
* Program that allows the user to practice multiplication tables.
* The user should first select a table to work on (1-12).
* The program will generate a random number between 1-12 to multiply it with.
* Ex if user har selected 7-table the program will generate 12*7, 8*7 and so on.
* The user should get the same number correct 3 times,
* after that the number will not apper again. When the user has answerd all numbers correctly 3 times,
* the round will end and stat of number of wrong will apper. 
* The user can then choose a new table or quit.
*
* @author Johanna Petersson
*/

import java.util.Scanner; // program uses class Scanner
import java.lang.Math;

public class MultiplicationTable 
{
    private static Scanner userInput = new Scanner(System.in);
        
    public static void main(String args[])
    {
        //Create variable
        int table = 0;
        int answer = 1;
        int giveNumber = 0;
        boolean correct;
        boolean shouldGameEnd = false;
        int[][] answerArray = new int [12][2];
    
            
        while (answer != 0)
        {
            //ask user what table to work on
            table = table();
    
            //Loop that exit if user enters 0 or if game is complete
            while (answer != 0 & shouldGameEnd == false) 
            {
                //What number to ask the user next I.E X*table
                giveNumber = numberToAsk();
    
                //Check if the givenNumber (x) has been answer correctly 3 times. If so get a new number. 
                if (answerArray [giveNumber-1][0] < 3)
                {
                    //Get answer from user
                    answer = askUserAnswer(table, giveNumber);
                    //check if correct
                    correct = checkAnswer(table, giveNumber, answer);
    
                    //enter stat in answerArray [x][0] if true
                    if (correct == true)
                    {
                        answerArray [giveNumber-1][0]++;
                    }
                    //enter stat in answerArray [x][1] if false
                    else
                    {
                        answerArray [giveNumber-1][1]++;
                    }
                }
            //Check if user has answerd all numbers between 1-12 correctly 3 times
            shouldGameEnd = endGame(answerArray);
            }
    
            //Print users stat
            print(answerArray);
                
            // Ask user to choose a new table or quit
            System.out.printf("%nWould you like to quit (enter 0) or choose a new table (enter 1): ");
            answer = input();
        }   
    }
    
    
        
    /**
    * Method for choosing what table to work on. 
    * @return answer - int, the chosen table
    */      
    public static int table()
    {
        int answer = 0;
    
        while (answer == 0)
        {
            System.out.printf("What table would you like to work on, choose 1-12: ");
            answer = input();
    
            if (answer >= 0 && answer < 13)
            {
                break;
            }
            else
            {
                System.out.printf("%nSorry, incorrect entry. Try again%n");
                answer = 0;
            }
        }
        return answer;
    }
    
    
    
    /**
    * Method for checking the users answer
    * @param table - int, the chosen table the user is working on
    * @param number - int, the random generated number asked
    * @param answer - int, the users answer to table*number
    * @return rightAnswer - boolean
    */ 
    public static boolean checkAnswer(int table, int number, int answer)
    {
        boolean rightAnswer = false;
        int checkAnswer;
    
        checkAnswer = table * number;
    
        if (answer == 0)
        {
            rightAnswer = true;
        }
        else if (answer == checkAnswer)
        {
            rightAnswer = true;
            System.out.printf("Correct! %n");
        }
        else
        {
            System.out.printf("%nNo, the correct answer is %d%n", checkAnswer);
        }
            
        return rightAnswer;
    }
    
    
    
    /**
    * Method for checking if the round should end, I.E the user has answer every number correctly 3 times
    * @param int array[][] - nested array where the stats are stored. 
    * @return endGame - boolean
    */ 
    public static boolean endGame(int array[][])
    {
        boolean endGame = false;
        int counter = 0;
        final int ALL_CORRECT = 36; //12 * 3 means that the user has answer correctly on all 12, 3 times.
    
        for (int i = 0; i < array.length; i++)
        {
            counter = counter + array[i][0];
        }
    
        if (counter == ALL_CORRECT)
        {
            endGame = true;
        }
        return endGame;
    }
    
        
    /**
    * Method for geting the users input. will return a int, give error if not a int.
    * @return number - int
    */  
    public static int input()
    {
        int answer = 0;
        //loop for input of data
        while (true)
        {    
            //If the user has inputed a interger value
            if (userInput.hasNextInt())
            {
                answer = userInput.nextInt(); 
                userInput.nextLine(); 
                break;
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
    * Method generates a number between 1 - 12 that is used to ask the user * table
    * @return number - int, random number 1-12.
    */   
    public static int numberToAsk()
    {
        int number; 
    
        final int MIN = 1;
        final int MAX = 12;
            
        number = (int) (Math.random () * (MAX - MIN + 1)) + MIN;
            
        return number;
    }
    
    
        
    /**
    * Method for asking the user what x*y is and returning the answer.
    * @param table - int number. Is the table that the user is studing
    * @param number - int, a number between 1-12 to multipny with table
    * @return answer - int, return the users answer.
    */
    public static int askUserAnswer(int table, int number)
    {
        int answer; 
            
        //Ask for the users answer
        System.out.printf("%nWhat is %d * %d:", table, number);
        answer = input();
            
        return answer;
    }
    
    
        
    /**
    * Method for printing the number of timse the user got a answer wrong
    * @param array - 2d int array that has the stat stored. 
    */
    public static void print(int[][]array)
    { 
        System.out.printf("Number of wrong answers: ");
        for(int i = 0; i < array.length; ++i)
        {
            System.out.printf("%n%d: wrong %d times ", i+1, array[i][1]);
        }    
    }
}

