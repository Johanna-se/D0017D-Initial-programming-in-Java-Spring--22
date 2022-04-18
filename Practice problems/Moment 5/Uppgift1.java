
import java.util.Scanner; // program uses class Scanner

class Uppgift1
{
    private static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args)
    {
        //declare variables
        final int MIN = 1;
        final int MAX = 5;
        int answer = 0;

        answer = getInputInt("Skriv in ett heltal mellan 1 och 5", MIN, MAX);
        System.out.println(answer);

    }

    /**
    * Metod som returnerar ett heltal samt uppmärksammar användaren på felaktig inmatning
    * @param message - uppmaning till användaren
    * @param minValue - nedre gräns för giltigt tal
    * @param maxValue - övre gräns för giltigt tal
    * @return - heltal
    */
    public static int getInputInt(String message, int minValue, int maxValue)
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
           if(number>maxValue || number<minValue)
           {
                number = Integer.MAX_VALUE;
                System.out.printf("Talet behöver vara mellan %d och %d, försök igen%n", minValue, maxValue);
           }
        }
        return number;        
    }
}
