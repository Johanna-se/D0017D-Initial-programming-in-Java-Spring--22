/**
*From LTU
*Methods - Menu
*Instructions
*
*Construct a method that prints menu below and manages to receive the user's choice which is returned by the method.
*
*    1. Deposit money
*    2. Withdraw money
*    3. Balance sheet
*    4. Finish
*
*Your choice:
*/

import java.util.Scanner; // program uses class Scanner

class Menu 
{
    public static void main(String[] args) 
    {
        int menuChoice = 0;

        menuChoice = menu();
        System.out.print("Your choice was: " + menuChoice);
        
    }

    public static int menu()
    {       
        Scanner userInput = new Scanner(System.in);
        int choice = 0;
        System.out.printf("1. Deposit money %n2. Withdraw money %n3. Balance sheet%n4. Finish%n%n");
        System.out.print("Your choice: ");
        choice = userInput.nextInt();
        return choice;
    }    
}

