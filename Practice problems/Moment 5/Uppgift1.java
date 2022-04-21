/**
*Task 6.1 - Min / max problem
*
*Write a method max that takes two integers as input parameters and returns that of the numbers which is the greater of the two.
*/

import java.util.Scanner; // program uses class Scanner

class Uppgift1 {
    private static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) 
    {
        
        //declare variables
        int one = 0;
        int two = 0;
        int answer = 0;

        System.out.print("What is the first interger?: ");
        one = userInput.nextInt();
        userInput.nextLine();

        System.out.print("What is the second interger?: ");
        two = userInput.nextInt();
        userInput.nextLine();

        answer = getMax(one, two);

        System.out.println("The max of the two intergers is: " + answer);

        
    }

    /**
    *Method that returns the larger of two ints
    * @param numberOne - first interger for comparison
    * @param numberTwo - second interger for comparison
    * @return - interger
    */
    public static int getMax(int numberOne, int numberTwo)
    {
        int number = numberOne;
        if (numberTwo>numberOne)
        {
            number = numberTwo;
        }
        return number;        
    }
}