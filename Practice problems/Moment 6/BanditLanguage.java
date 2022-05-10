/**
* Java Standard Library - Bandit Language
* 
* Instructions
* 
* In The Master Detective Kalle Blomqvist by Astrid Lindgren, the so-called robber language appears. 
* In the language of the robber, a text is encrypted so that a consonant is followed by an "o" and the same consonant again, while vowels remain unchanged.'
*
* Tothohe qoquicockok bobrorownon fofoxox jojumompopsos ovoveror tothohe lolazozy dodogog
* 
* Write a program that converts a sentence into robber language, use methods.
*/

import java.util.Scanner;
public class BanditLanguage 
{
    public static void main(String[] args) 
    {
        //declare variabls
        String text;
        String robberText;

        //get user from method input
        text = input();

        //convert to robber language
        robberText = robber(text);

        //remove none wanted extra ex ".o." becomes "."
        robberText = eliminateExtra(robberText);

        //print
        System.out.println("In the robber language that would be: " + robberText);
    }

    //Method for input from user
    public static String input()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: ");
		return input.nextLine();
	}

    //Method to convert the string 
    public static String robber(String text)
    {
        String convert = "";
        
        for (int i = 0; i < text.length(); i++)
        {
            if (isItVowel(text.charAt(i)) == false)
            {
                convert = convert + consonant(text.charAt(i));
            }
            else
            {
                convert = convert + text.charAt(i);
            }
        }

        return convert;
    }

    //Method to convert ex "t" to "tot"
    public static String consonant(char con)
    {
        String convert; 
        
        convert = con + "o" + con;
        
        return convert;
    }

    //Method to check for vowel
    public static boolean isItVowel(char text)
    {
        boolean answer; 
        switch (text)
        {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'å':          
            case 'ä':            
            case 'ö':
            {
                answer = true;
                break;
            }     
            default:
            {
                answer = false;
            }
        }
        return answer;
    }

    //remove non wanted extra
    public static String eliminateExtra(String phrase)
	{
		phrase = phrase.replace(" o ", " ");
        phrase = phrase.replace(".o.", ".");
        phrase = phrase.replace("?o?", "?");
        phrase = phrase.replace("!o!", "!");
        phrase = phrase.replace(",o,", ",");
        phrase = phrase.replace(";o;", ";");
        return phrase;
	}
    
}
