import java.util.Scanner;

public class MenuTeacherSolution
{
  public static void main (String [] args)
  {
    int theChoice = 1;

    while(theChoice != 4)
    {
      theChoice = menu ();
      switch (theChoice)
      {
        case 1:
          System.out.println("You selected \"Deposit Money\"");
          break;
        case 2:
          System.out.println("You selected \"Withdraw Money\"");
          break;
        case 3:
          System.out.println("You selected \"Balance Message\"");
          break;
        case 4:
          System.out.println("You selected \"Exit\"");
          break;
        default:
          System.out.println("Select something in the menu, a number between 1-4");
          break;
      }
    }
  }

    public static int menu ()
    {
      Scanner keyboard = new Scanner (System.in);
      int choice = 0;

      System.out.println ("1. Deposit money");
      System.out.println ("2. Withdraw Money");
      System.out.println ("3. Balance Message");
      System.out.println ("4. Exit");
      System.out.print ("Your choice: ");

      choice = keyboard.nextInt ();

    // NOTE! We can NOT close the keyboard here as we will probably use the input more times

      return choice;
    }
}