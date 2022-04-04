import java.util.Scanner;

public class TemperatureTwoTeacherSolution 
{
    public static void main (String [] args)
  {
    // Declare variables needed
    int noOfDays, day, nrOfDaysOverAverage, maxDay = 0, minDay = 0;
    double sum, max, min, average = 0;
    double [] temp;

    // Enter the number of days
    Scanner keyboard = new Scanner (System.in);
    System.out.print ("How many days does the month have?");
    noOfDays = keyboard.nextInt ();
    keyboard.nextLine (); // Clear the input buffer

    // Initiate variables
    sum = 0.0;
    max = -100;
    min = 100;
    nrOfDaysOverAverage = 0;

    // How big the array should be, an extra place as we do not use index 0 (place 1)
    // We put day 1 on index 1 (place 2 in the array)
    temp = new double [noOfDays + 1];

    // PROCESSING
    for (day = 1; day <= noOfDays; day ++)
    {
    // Enter temp for day 'day'
      System.out.print ("Enter the temperature for day" + day + ":");
      temp [day] = keyboard.nextDouble (); // Save in the correct "box"
      keyboard.nextLine (); // Clear the input buffer

      // Add temp to sum
      sum = sum + temp [day];

      // Is the temp lower than the lowest?
      if (temp [day] <min)
      {
        min = temp [day]; // New minimum temperature
        minDay = day;
      }
      // Is the temp higher than the highest?
      if (temp [day]> max)
      {
        max = temp [day]; // New maximum temperature
        maxDay = day;
      }
    }

    // Calculate the mean
    average = sum / noOfDays;

    // Go through the array to count the number of days above the mean
    for (int i = 1; i <= noOfDays; i ++)
    {
      if (temp [i]> average)
      {
        nrOfDaysOverAverage ++;
      }
    }

    // PRINTING
    System.out.println ("Maximum temperature was" + max + "° C");
    System.out.println ("Maximum temperature was on day" + maxDay);
    System.out.println ("Lowest temperature was" + min + "° C");
    System.out.println ("Lowest temperature was on day" + minDay);
    System.out.println ("Average temperature was" + average + "° C");
    System.out.println ("Number of days when the temperature exceeded the average was" + nrOfDaysOverAverage);

    keyboard.close (); // Closes the inflow, may only be done at the very end of the program!
  }
    
}
