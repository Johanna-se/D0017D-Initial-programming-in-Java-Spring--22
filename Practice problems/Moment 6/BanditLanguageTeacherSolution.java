import java.util.Scanner;
public class BanditLanguageTeacherSolution 
{
    public static void main(String[] args)
	{
		// Variable declaration
		String phrase = "";
		String convertedPhrase = "";
		
		// Input
		phrase = input();
		
		// Encoding / Conversion
		convertedPhrase = convert(phrase);
		
		// Print
		System.out.println("In the language of robbers " + phrase + " will be : " + convertedPhrase);
	}
	
	public static String convert(String theString)
	{
		final String CONSONANTS = "bcdfghjklmnpqrstvxzBCDFGHJKLMNPQRSTVXZ";
		String oneChar = "";
		String convertedString = "";
		
		for(int i = 0; i < theString.length(); i++)
		{
			oneChar = theString.substring(i, i+1);
			if(CONSONANTS.indexOf(oneChar) != -1)
			{
				// Konsonant
				convertedString += oneChar + "o" + oneChar.toLowerCase(); 
			}
			else
			{
				// Vokal
				convertedString += oneChar;
			}
		}
		return convertedString;
	}
	
	public static String input()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the phrase to be encrypted/converted: ");
		return keyboard.nextLine();
	}
    
}
