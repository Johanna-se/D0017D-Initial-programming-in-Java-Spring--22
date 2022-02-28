/**
*Exercise 3,17 From the book:
*Drivers are concerned with the mileage their automobiles get. One driver has
*kept track of several trips by recording the miles driven and gallons used for each tankful. Develop
*a Java application that will input the miles driven and gallons used (both as integers) for each trip.
*The program should calculate and display the miles per gallon obtained for each trip and print the
*combined miles per gallon obtained for all trips up to this point. All averaging calculations should
*produce floating-point results. Use class Scanner and sentinel-controlled iteration to obtain the data
*from the user.
*
*Psudocode
*1. Initiat scanner-object
*2. Initiate int milesDriven = 1, gallonsUsed 
*3. Initiate float totalMilesPerGallon = 0, milesPerGallon
*4. prompt user
*5.		print "How many miles driven for this trip? to exit enter -1"
*6.		milesDriven = user input	
*7. While milesDriven != -1
*8.		print "How many gallons were used for this trip?"
*9.		gallonsUsed = user input
*10.	milesPerGallon = milesDriven / gallonsUsed
*11.	totalMilesPerGallon += milesPerGallon
*12.	print ""The miles per gallon for this trip was " + milesPerGallon + "and the total miles per gallon so far is" + totalMilesPerGallon"
*13.	print "How many miles driven for this trip? to exit enter -1"
*14.	milesDriven = user input 
*15.Print "The total miles per gallon for all trips was" + totalMilesPerGallon
*/
import java.util.Scanner; // program uses class Scanner

class GasMileage 
{
	public static void main(String[] args) 
	{
		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);
    
		//initiate variabls
		int milesDriven = 1;
		int gallonsUsed;
		float milesPerGallon;
		float totalMilesPerGallon = 0;


    
		// processing phase
		// prompt for input and read milesDriven from user
		System.out.print("How many miles were driven for this trip? to exit enter -1: ");
		milesDriven = input.nextInt();

		// loop until sentinel value read from user
		while (milesDriven != -1) {
			System.out.print("How many gallons were used for this trip?: ");
			gallonsUsed = input.nextInt();
      
			milesPerGallon = (float) milesDriven / (float) gallonsUsed;
        
			totalMilesPerGallon += milesPerGallon;

			System.out.println("The miles per gallon for this trip was " + milesPerGallon + " and the total miles per gallon so far is " + totalMilesPerGallon);

			//prompt the user to enter miles or exit the loop
			System.out.print("How many miles were driven for this trip? to exit enter -1: ");
			milesDriven = input.nextInt();
		}

		// termination phase
		System.out.println("The total miles per gallon for all trips was " + totalMilesPerGallon);
	}
 }
 