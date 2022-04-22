/**
*Task 6.2
*
*Write methods such as:
*
*    takes in an integer and returns the first digit of the number
*    takes in an integer and returns the last digit of the number
*    takes in an integer and returns the number of digits that the number consists of
*/

import java.util.Scanner; // program uses class Scanner

class Uppgift2 
{
    private static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) 
    {
        
        //declare variables
        int one = 0;
        int firstDigit = 0;
        int lastDigit = 0;
        int numberOfDigit = 0;

        System.out.print("What is the interger?: ");
        one = userInput.nextInt();
        userInput.nextLine();

        firstDigit = getFirstDigit(one);
        lastDigit = getLastDigit(one);
        numberOfDigit = getNumberDigit(one);

        System.out.printf("The first digit is %d, the last digit is %d and the number of digits are %d", firstDigit, lastDigit, numberOfDigit );

        
    }

    /**
    *Method that returns the first digit in an interger
    * @param number - interger 
    * @return - first digit of the the number interger
    */
    public static int getFirstDigit(int number)
    {
        while(number >= 10)
        {
            number = number/10;
        }
        return number; 
    }

    /**
    *Method that returns the last digit in an interger
    * @param number - interger 
    * @return - last digit of the the number interger
    */
    public static int getLastDigit(int number)
    {
        return number % 10;        
    }

    /**
    *Method that returns the number of digit in an interger
    * @param number - interger 
    * @return - interger
    */
    public static int getNumberDigit(int number)
    {
        int counter = 0; 
        while (number != 0)
        {
            counter++;
            number = number/10;
        }

        return counter; 
    }
}