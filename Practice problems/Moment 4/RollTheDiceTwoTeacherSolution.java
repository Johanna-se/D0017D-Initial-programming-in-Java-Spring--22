import java.util.Scanner;

public class RollTheDiceTwoTeacherSolution
{
  public static void main (String [] args)
  {
    // Variable declaration
    int nrOfThrows, currentThrow;
    int [] frequency = new int [7];
    
    Scanner keyboard = new Scanner (System.in);
    
    System.out.print ("Number of casts:");
    nrOfThrows = keyboard.nextInt ();
    
    // Roll the dice
    for (int roll = 0; roll <nrOfThrows; roll ++)
    {
        currentThrow = (int) (Math.random () * 6) +1;
        System.out.print (currentThrow + "");
        
        frequency [currentThrow] = frequency [currentThrow] + 1;
    }
    // Print diagram
    for (int diceNr = 1; diceNr <= 6; diceNr ++)
    {
        System.out.print ("\n" + diceNr + ":");
        
        // Number of outcomes saved in the array position in
        for (int i = 0; i <frequency [diceNr]; i ++)
        {
            System.out.print ("#");
        }
    }
    keyboard.close (); // Closes the inflow, may only be done at the very end of the program!
  }
}
