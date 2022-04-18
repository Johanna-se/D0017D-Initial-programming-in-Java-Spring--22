/**
* From LTU: Arrays - Sorting
* Instructions
*
* One, of several, ways of sorting the elements in a field is to consider the field as two subfields, 
* where one part is sorted and the other part is unsorted. 
* The principle is to find the largest element in the unsorted part and place it last in the sorted part.
*
* This sorting algorithm is called selection sort.
*
* Write a program that randomizes 30 integers in the range 1 to 100 into an array a, 
* sorts them and prints them. Below is the pseudocode and flow chart for the sorting algorithm:
*
* len = the length of the array a
* i goes from 0 to len - 1
*     max = i
*     k goes from i + 1 to len
*         om a [k]> a [max]
*             max = k
*     temp = a [i]
*     a [i] = a [max]
*     a [max] = temp
*
*/

import java.lang.Math; 

class Sorting 
{
    public static void main(String[] args) 
    {
        //declare and initiate constants
        final int MAX = 100; //max random number that can be assignd
        final int MIN = 1; // min random number
  
        //declare variables
        int max = 0;
        int temp = 0;
        
        //declare array
        int [] array = new int [30];

        //assign random numbers to array objects and print them
        for (int counter = 0; counter < array.length; counter++)
        {
            //randomize the number and assign it
            array [counter] = (int) (Math.random () * (MAX-MIN+1) +MIN);
            System.out.print(array[counter] +", ");
        }

        //New line for readability
        System.out.print("\n\n");

        //sort the array
        for (int i = 0; i < array.length; i++)
        {
             max = i;

            //Find the largest number remaning in the array
            for (int k = i+1; k < array.length; k++)
            {
                if (array[k] > array[max])
                {
                    max = k;
                }
            }

        //print the max number
        System.out.print(array[max] +", ");
      
        //Switch places between current number (i) and the largest number (max)
        temp = array[i];
        array[i] = array[max];
        array[max] = temp;
        }
    }
}
