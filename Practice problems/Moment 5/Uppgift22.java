import java.util.Scanner; // program uses class Scanner

public class Uppgift22 
{
    private static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args)
    {
        float answer = 0;

        answer = getInputFloat("Skriv in ett float tal");
        System.out.println(answer);
    }

    /**
    * Metod som returnerar ett flyttal samt uppmärksammar användaren på felaktig inmatning
    * @param message - uppmaning till användaren
    * @return - flyttal
    */
    public static float getInputFloat(String message)
    {
        float number = Float.MAX_VALUE;
        while (number == Float.MAX_VALUE)
        {
            System.out.println(message);
            if(userInput.hasNextFloat())
            {
                number = userInput.nextFloat();
            }
        userInput.nextLine(); // remove rest of line (including error input)
        }
    return number;
    }
    
}
