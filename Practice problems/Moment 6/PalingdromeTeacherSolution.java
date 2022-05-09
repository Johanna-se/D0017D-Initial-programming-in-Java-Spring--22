import java.util.Scanner;

public class PalindromeTeacherSolution 
{
    public static void main(String[] args)
	{
		//Variable Declaration
		String phrase = "";
		String reversePhrase = "";
		
		//Inmatning
		phrase = input();
		
		phrase = eliminateBlanks(phrase);
		
		phrase = convertToLowerCase(phrase);
		
		//Skapa omvänd sträng
		reversePhrase = reverse(phrase);
		
		//Utskrift
		if(isPalindrome(phrase, reversePhrase))
		{
			System.out.println("Palindrome!");
		}
		else
		{
			System.out.println("Not a palindrome!");
		}
		
		
				
	}
	
	public static String eliminateBlanks(String thePhrase)
	{
		return thePhrase.replace(" ", "");
	}
	
	public static String convertToLowerCase(String thePhrase)
	{
		return thePhrase.toLowerCase();
	}
	
	public static boolean isPalindrome(String thePhrase, String theReversePhrase)
	{
		return thePhrase.equals(theReversePhrase);
	}
	
	public static String reverse(String thePhrase) 
	{
		String reverseString = "";
		
		for(int i=0; i < thePhrase.length(); i++)
		{
			reverseString = thePhrase.substring(i, i+1) + reverseString; 
		}
		return reverseString;
	}
	
	public static String input()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the work/phrase to be tested: ");
		return keyboard.nextLine();
	}

}