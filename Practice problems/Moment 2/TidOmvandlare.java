/**
*Från LTU
*Skriv ett Javaprogram som frågar efter antal timmar, minuter och sekunder, 
*använd Scanner-klassen med kolon-tecknet : som separator (se nedan). 
*Programmet ska sedan beräkna och skriva ut hur många sekunder det blev totalt.
*Exempel (röd text betyder att användaren matar in):
*Mata in tim, min och sek på formen (tt:mm:ss): 02:40:15
*Det blir 9615 sekunder
*/
import java.util.Scanner;

class TidOmvandlare
{
	public static void main(String[] args)
	{
		//Påbörja skanning
		Scanner userInput = new Scanner(System.in);
		userInput.useDelimiter("[:/\\s]+"); // Bryter vid tecknet ':'

		//Deklarera varabler
		int time, minut, sekund, sum;

		//Fråga efter information från användaren
		System.out.print("Mata in tim, min och sek på formen (tt:mm:ss): ");

		//Användar Input
		time = userInput.nextInt();
		minut = userInput.nextInt();       
		sekund = userInput.nextInt();

		//Räkna om timmar och minuter till sekunder
		minut = minut *60;
		time = time*60*60;

		//beräkna totala sekunder
		sum = time + minut + sekund;

		//Printa resultat till användaren:
		System.out.println("Det blir " + sum + " sekunder");  
	}
}
