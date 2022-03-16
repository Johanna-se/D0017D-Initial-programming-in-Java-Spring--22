/**
*The program askes the user for date and time for sun up and down. 
* It uses the information to calculate how much money the users 
* solar cells generates per day. Place: Skellefteå Month: june or july.
* 
* pseudokod for project:
* 1. Declare constants and variables
* 2. Creat Scanner
* 3. Ask user for date and check if entered correctly
* 4. Ask user for sun up and down. Check if sun down is after sun up.
* 5. calculates hours of sunshine. 
* 6. calculate produktion.
* 7. calculate profit of the sale of the production.
* 8. Return information to user.
*
* @author Johanna Petersson, ojoepe-5
*/

import java.util.Scanner;


class AssignmentTwo 
{
	public static void main(String[] args) 
	{
    
		//Declare constants and variables
		int month;
		int day; 
    
		float hour;
		float minut;

		float sunUp;
		float sunDown;
		float sunHours;

		float produktion;
		float value;

		final float EFFICIENCY_SOLAR_CELL = 0.2f; //Constant for the efficiency of the solar cells given to 20% of solar radiation
		final float SOLAR_RADIATION = 0.166f; // Solar radiation in Skellefteå on a sunny day (June/July) as 0,166 kWh/m^2/hour.
		final float AREA_SOLAR_CELL = 26f* 1.7f * 1f; //Area for 26 solar cells which each has area 1,7m*1m.
		final float ELECTRICITY_PRICE = 0.9f; //The price of electricity at 0.9 SEK/kWh.
    


		// Creating scanner object
		Scanner userInput = new Scanner(System.in);

		// Set delimiter to '-' or ':' or whitespace 
		userInput.useDelimiter("[-:\\s]+"); 



		//Ask user for todays date. Check that the month is june or juli. If not, exit.
		System.out.print ("Skriv dagens datum [mm-dd]: ");
		month = userInput.nextInt();
		day = userInput.nextInt();

		if (month < 6) //Check if month is before june
		{
			System.out.print ("Felaktig månad, månad måste vara juni eller juli");
			System.exit(0);
		}
		if (month > 7) //Check if month is after july
		{
			System.out.print ("Felaktig månad, månad måste vara juni eller juli");
			System.exit(0);
		}



		//Ask user for time of sun up
		System.out.print ("Skriv in tidpunkt soluppgång [hh:mm]: ");
		hour = userInput.nextFloat();
		minut = userInput.nextFloat();
		userInput.nextLine(); //Remove return character
		sunUp = hour + (minut/60f); // calculates sun up and converts minuts to hour

		//Ask user for time of sun down
		System.out.print ("Skriv in tidpunkt solnedgång [hh:mm]: ");
		hour = userInput.nextFloat();
		minut = userInput.nextFloat();
		userInput.nextLine(); //Remove return character
		sunDown = hour + (minut/60f); // calculates sun down and converts minuts to hour

		//check that the time for sun down is after sun up. If not, exit. 
		if (sunDown<sunUp)
		{
			System.out.print ("Solnedgång måste vara efter soluppgång.");
			System.exit(0);
		}

		//calculate hours of sunshine
		sunHours = sunDown - sunUp;



		//calculate produktion as Production (kWh) = Solar radiation (kWh / m2 / hour) x efficiency x surface (m2) x hours of sunshine
		produktion = SOLAR_RADIATION * EFFICIENCY_SOLAR_CELL * AREA_SOLAR_CELL * sunHours;

		//calculate profit of the sale of production.
		value = produktion * ELECTRICITY_PRICE;



		//Creates a string for printing of date.
		String outStrDate = day + "/" + month;

		//Return to user what date, sun hours, production and the value.
		System.out.printf("Soltimmar: %.2f timmar %n", sunHours);
		System.out.printf("Produktionen den %s är: %.2f kWh till ett värde av: %.2f kr%n", outStrDate, produktion, value);
 
	}
}
