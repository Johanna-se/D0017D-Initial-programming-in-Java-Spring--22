/**
* The program handles random numbers. The user must first enter 
* as many random numbers.
* Then the program should randomize the specified number of numbers and place these in an array.
* The program must first print the numbers in the order in which they were randomized. 
* Then program the random numbers so that they are in the order of least even integers 
* to largest even integers and then largest odd integers to least odd integers.
* Finally, the program should print the numbers in the order they are in the array 
* with a punctuation mark between even and odd numbers and the number of even and odd numbers.
*
* psudocode:
* declare constants, variables and arrays
* Use try
*    ask for how many random numbers
*    numberOfRandom = user input
*    if 0 or negative 
*        give error message and exit program
*    else 
*        create array
* Use catch for exceptions "OutOfMemoryError" and "InputMismatchException"
*    give error message and exit program
* Use for-loop to assign random numbers to array.
* Print the unsorted random numbers.
* Use for-loop to seperate even and odd number
*    if even, place it at the start of temp array
*    if odd, place att the end of temp array
* Use for-loop to sort the even numbers att the start of "temp array" into "number array", lest to largest
* Use for-loop to sort the odd numbers at the end of "temp array" (after the even numbers) into "number array", largest to leats.
* Print the sorted numbers
*    For-loop for even numbers
*    For-loop for odd numbers
* 
*  author: Johanna Petersson @ojoepe
*/

import java.util.*; 
import java.lang.Math;

class Main 
{
    public static void main(String[] args) 
    {
        //create scanner object
        Scanner input = new Scanner(System.in);
        
        //declare constants
        final int MAX = 999; //max random number that can be assignd
        final int MIN = 0; // min random number

        //declare variables
        int numberOfRandom = 0;
        int countEven = 0;
        int countOdd = 0;
        int largest = 0;
        int smallest = 0; 
        int temp = 0;

        //declare and initialize array 
        int[] numberArray = new int[0];
        int[] temporaryArray = new int[0];


        
        //ask user to input how many random numbers to initialize array, checks to see if number is within allowd range. 
        try 
        {
            //Ask user to input "how many random numbers"
            System.out.printf("How many random numbers in the range 0 - 999 are desired? ");
            numberOfRandom = input.nextInt();
            //if user enters 0 or negative, give error message and exit.
            if (numberOfRandom <= 0)
            {
                System.out.printf("Can not generate zero or negative numbers, please run the program again. %n");
                System.exit(0);
            }
            //if user enters positive number, creat number array and temp array.
            else 
            {
                //initialize array
                numberArray = new int[numberOfRandom];
                temporaryArray = new int[numberOfRandom];
            }
        }
        catch (OutOfMemoryError e)
        {
            System.out.printf("The number selected is to large for computer memory, please run the program again. %n");
            System.exit(0);
        }
        catch (InputMismatchException e)
        {
            System.out.printf("The number selected is out out of range for interger max value, please run the program again. %n");
            System.exit(0);
        }
        //New line for readability
        System.out.printf("%n");


        
        //generate random numbers for array object
        System.out.printf("Here are the random numbers: %n");
        for (int counter = 0; counter < numberArray.length; counter++)
        {
            //randomize the number and assign it
            numberArray[counter] = (int) (Math.random() * (MAX-MIN+1) +MIN);
        }


        
        // Print the unsorted random numbers in numberArray
        for (int i = 0; i < numberArray.length; i ++)
        {
            System.out.printf("%d, ",numberArray[i]);
        }
        //New line for readability
        System.out.printf("%n%n");



        //Sort the Arrays - even and odd
        //Check if number is even or odd, if even place at start of temp array, if odd place at the end of temp array
        for (int i = 0; i < numberArray.length; i++)
        {
            if (numberArray[i] % 2 == 0)
            {
                temporaryArray[countEven] = numberArray[i];
                countEven++;
            }
            else
            {
                temporaryArray[numberOfRandom-1-countOdd] = numberArray[i];
                countOdd++;
            }
        }
       
        //Sort the arrays - according to size
        //Sort even numbers at the start of temp array, from lest to largest into start of number array
        for (int i = 0; i < countEven; i++)
        {
            smallest = i;

            //Find the smallest number remaning in the array
            for (int k = i+1; k < countEven; k++)
            {
                if (temporaryArray[k] < temporaryArray[smallest])
                {
                    smallest= k;
                }
            }
            //Switch places between current number (i) and the smallest number (smallest)
            temp = temporaryArray[i];
            temporaryArray[i] = temporaryArray[smallest];
            temporaryArray[smallest] = temp;
            
            //place the smallest even number in the number arrat [i]
            numberArray[i] = temporaryArray[i];
        }
        
        //Sort odd numbers at the end of temp array from largest to least into the end of number array (after the even numbers)
        for (int i = countEven; i < temporaryArray.length; i++)
        {
            largest = i;

            //Find the largest number remaning in the array
            for (int k = i+1; k < temporaryArray.length; k++)
            {
                if (temporaryArray[k] > temporaryArray[largest])
                {
                    largest = k;
                }
            }

            //Switch places between current number (i) and the largest number (largest)
            temp = temporaryArray[i];
            temporaryArray[i] = temporaryArray[largest];
            temporaryArray[largest] = temp;
            
            //place the largest odd number in the number arrat [i]
            numberArray[i] = temporaryArray[i];
        }



        // Print sorted numbers
        System.out.printf("Here are the random numbers arranged:%n");
        
        //Print the even numbers
        for (int i = 0; i < countEven; i ++)
        {
            System.out.printf("%d ", numberArray[i]);
        }
        
        //Print punctuation mark between even and odd numbers
        System.out.printf(" - ");
        
        //Print the odd numbers
        for (int i = countEven; i < numberArray.length; i ++)
        {
            System.out.printf("%d ", numberArray[i]);
        }
        
        System.out.printf("%n%nOf the above %d, %d were even and %d odd", numberOfRandom, countEven, countOdd);
    }
}
