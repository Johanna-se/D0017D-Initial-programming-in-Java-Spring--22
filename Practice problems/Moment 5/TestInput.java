import java.util.Scanner;

public class TestInput 
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String args[])
    {
       int answer = -1;
 
       while( answer != 0)
       { 
          answer = getInputInt("Skriv in ett heltal: (för att avsluta ange 0");
          System.out.println(answer);
       }
    }

    /**
    * Metod som returnerar ett heltal samt uppmärksammar användaren på felaktig inmatning
    * @param message - uppmaning till användaren
    * @return - heltal
    */
    public static int getInputInt(String message)
    {
        int number = Integer.MAX_VALUE;
        while (number == Integer.MAX_VALUE)
        {
            System.out.println(message);
            if(userInput.hasNextInt())
            {
                number = userInput.nextInt();
            }
        userInput.nextLine(); // remove rest of line (including error input)
        }
    return number;
    }
    
}
