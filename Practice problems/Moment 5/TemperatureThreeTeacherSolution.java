import java.util.Scanner;

public class TemperatureThreeTeacherSolution
{
  public static void main (String [] args)
  {
    // Declaration of variables
    int noOfDays, max, min, nrOfDaysOverAverage;
    double [] temp = new double [32]; // No month has more than 31 days
    double average;

    noOfDays = input (temp);
    max = maxTemp (temp, noOfDays);
    min = minTemp (temp, noOfDays);
    average = average (temp, noOfDays);
    nrOfDaysOverAverage = nrOfDaysPastTemp (temp, average, noOfDays);

    System.out.println ("Maximum temperature was " + temp [max] + "°C");
    System.out.println ("Maximum temperature was during the day " + max);
    System.out.println ("Lowest temperature was " + temp [min] + "°C");
    System.out.println ("Lowest temperature was on day " + min);
    System.out.println ("Average temperature was " + average + "°C");
    System.out.println ("Number of days when the temperature exceeded the average was " + nrOfDaysOverAverage);

    }

    public static int input (double [] temps)
    {
      Scanner keyboard = new Scanner (System.in);
      int day = 0;
      int theNrOfDays = 0;

      System.out.print ("How many days does the current month have? ");
      theNrOfDays = keyboard.nextInt ();

      while (day <theNrOfDays)
      {
        day ++;
        System.out.print ("Enter the temperature for day " + day + ": ");
        temps [day] = keyboard.nextDouble ();
      }

      return theNrOfDays;
    }

    public static double average (double [] temps, int nrOfTemps)
    {
      double theAverage = 0.0;
      double theSum = 0.0;

      for (int i = 1; i <= nrOfTemps; i ++)
      {
        theSum = theSum + temps [i];
      }

      theAverage = theSum / nrOfTemps;

      return theAverage;
    }

    public static int maxTemp (double [] temps, int nrOfTemps)
    {
      int theMaxIndex = 1;

      for (int i = 2; i <= nrOfTemps; i ++)
      {
        if (temps [i]> temps [theMaxIndex])
          theMaxIndex = i;
      }

      return theMaxIndex;
    }

    public static int minTemp (double [] temps, int nrOfTemps)
    {
      int theMinIndex = 1;

      for (int i = 2; i <= nrOfTemps; i ++)
      {
        if (temps [i] <temps [theMinIndex])
          theMinIndex = i;
      }

      return theMinIndex;
    }

    public static int nrOfDaysPastTemp (double [] temps, double theTemp, int nrOfTemps)
    {
      int nr = 0;

      for (int i = 1; i <= nrOfTemps; i ++)
      {
        if (temps [i]> theTemp)
        nr++;
      }
      return nr;
  }
}