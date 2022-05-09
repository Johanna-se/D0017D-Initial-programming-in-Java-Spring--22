/**
* Java Standard Library - Palindrome
* 
* Instructions
* A palindrome is a word or sentence that becomes the same backwards as forwards:
*
* Ex: ada, naturrutan, I Reval sitta ni i natt i slaveri
*
* Write a program that determines if a entered word is a palindrome. 
* The entered word or sentence entered should be handled as a string.
*
* Start by making a program that manages the palindrome check for words with only lowercase letters (lowercase letters). 
* Build the program so that it can also handle spaces and a mixture of lowercase and uppercase letters.
* 
Use methods to divide the problem into smaller parts.
 */

import java.util.Scanner;

public class Palindrome 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        //declare varibles 
        String str;
        String comp;

        //ask for user input
        System.out.println("Enter a string:");
        str = input.nextLine();
        
        //call method to reverse
        comp = reversed (str);

        //call method to compare
        compare (str,comp);
    }

    /**
    *Method for reversing the order of characters in a string
    */
    public static String reversed (String args)
    {
        String rev = "";

        for (int i = args.length() - 1; i >= 0; i--)
        {
            rev += args.charAt(i);
        }

        return rev;
    }

    /**
    * Method for comparing and printing answer
    */
    public static void compare (String args, String rev)
    {
        //use method replace() to remove any space before comparing
        args = args.replace(" ", "");
        rev = rev.replace(" ", "");
        
        if (args.equalsIgnoreCase(rev))
        {
            System.out.println("The string is a palindrome");
        }
        else
        {
            System.out.println("The string is not a palindrome");
        }
    }
    
}
