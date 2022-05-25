/**
* A program for booking seats in a small airplane. The seating are as follows.
* 1 A B   C D E 
* 2 A B   C D E 
* 3 A B   C D E 
* 4 A B   C D E 
* 5 A B   C D E 
* 6 A B   C D E
*
* A booked seat is marked with #
* Ex: 1 # B   C D E 
* The user is able to enter a row followed by a seat Ex 1A.
* If the seat is not booked already the booking will be a success and a receipt will be printed 
* The user can also choose to book several seats on the same row Ex 2A-D
 */
import java.util.Scanner; // program uses class Scanner
public class AirBooking 
{
    private static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) 
    {
        
        //declare variables
        String bookSeat = "";
        char[][] availableSeatsArray = new char[6][5];
        int[] bookingRowCol = new int[3];
        boolean bookingSuccess = false;
        boolean allBooked = false;

        //Method that gives the seating array its initital seats. 
        startSeatLetters(availableSeatsArray);

        //Print initial greating to user. 
        System.out.printf("Welcome to the flight booking system.%n");

        //do-while loop 
        do
        {
            //Print the seats
            printBookingArray(availableSeatsArray);

            //Print instruktions to user
            System.out.printf("%nThe seats already occupied are marked with a #.");
            System.out.printf("%nYou book a seat by giving the row followed by the seat letter ex 1A.");
            System.out.printf("%nIf you wish to book several seats on the same row, you enter the format: 1A-C.");
            System.out.printf("%nWhat seat would you like to book? Enter -1 to quit: ");

            //User data stored in string
            bookSeat = userInput.nextLine();

            //check if user has ented -1, if so exit
            if(bookSeat.equals("-1"))
            {
				break;
            }

            //Get the booking info from users string entery by using method getRowAndColumns
            bookingRowCol = getRowAndColumns(bookSeat);

            //Make the booking and return if it was a success or not.
            bookingSuccess = seatBooking(availableSeatsArray, bookingRowCol);

            //If booking worked, print recept, else error. ADD!!!!!!!!!!!!!!!!!!!
            if (bookingSuccess == true)
            {
                printReceipt(bookingRowCol);
            }
            else
            {
                System.out.printf("%nSorry, incorrect enterd data. Try again. %n");
            }
            //check if all the seats have been booked, if so print them and exit.
            allBooked = isEverySeatBooked(availableSeatsArray);
            if (allBooked == true)
            {
                printBookingArray(availableSeatsArray);
                System.out.printf("%nAll the seats have been booked.");
                break;
            }
        } while (true);
        System.out.printf("%nThank you for the visit, please come again.");
    }

    /**
    * Method that resets the booking array at start of round
    * @param char[][]array - the array where the seats are stored.
    */
    public static void startSeatLetters(char[][]array)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i][0] = 'A';
            array[i][1] = 'B';
            array[i][2] = 'C';
            array[i][3] = 'D';
            array[i][4] = 'E';
        }
    }


    /**
    * Method for printing the seat chart stored in bookingArray
    * @param char[][]array - the array where the seats are stored.
    */
    public static void printBookingArray(char[][]array)
    {
        final int AISLE_LOCATION = 2;
        
        //Print every row
        for(int row = 0; row < array.length; row++)
        {
            System.out.printf("%n%d: ", row+1);
            //Print every column
            for(int col = 0; col < array[row].length; col++)
            {
                //If at C print double space for aisle before continuing
                if (col == AISLE_LOCATION)
                {
                    System.out.printf("  ");
                }
                // Print seat
                System.out.printf("%c ", array[row][col]);
            }
        }
    }

    
    /**
    * Method for checking if all seats are booked.
    * @param char[][]array - the array where the seats are stored.
    * @return full - boolean, will return true if all seats are booked.
    */
    public static boolean isEverySeatBooked(char[][]array)
    {
        final int ALL_SEATS_BOOKED = 30;
        int counter = 0;
        boolean full = false;

        // Count how many seats are occupied
        for(int row = 0; row < array.length; row++)
        {
            for(int col = 0; col < array[row].length; col++)
            {
                if (array[row][col] == '#')
                {
                    counter++;
                }
            }
        }

        if (counter == ALL_SEATS_BOOKED)
        {
            full = true;
        }

        return full;
    }

    /**
    * Method for getting the booking info frpn users string entering. Return it as a array
    * @param inString - String with the booking info
    * @return int[] seating - in 0-pos is the row, in 1-pos is seat 1 and in 2-pos is the last seat
    */
    public static int[] getRowAndColumns(String inString)
    {
        char c;
        String row = "";
        int place = 0;
		char first = 0;
		char last = 0;
        int[] seating = new int[3];
        char[] charArray = inString.toCharArray(); //convert the string into an array.

        inString.trim(); // Removes any space character at start and end

        //Find the row digit in the inString (located now in the charArray)
        for(place = 0; place < charArray.length; place++)
        {
            //Store the character on position i in the charArray in c.
            c = charArray[place];

            //If c is a digit
            if (Character.isDigit(c))
            {
                row += c;
            }
            //Exit loop when the digit is found.
            else
            {
                break;
            }
        }

        //Find first seat, stor it in first
		if(charArray.length > place)
        {
			first = charArray[place++];
        }

        //If there are more char I.E the user has enterd the format A-E
        if(charArray.length > place)
        {
			if(charArray[place++] == '-')
            {
				last = charArray[place++];
            }
        }

        // Convert the row char digit to an int and store in seating-arrays first position.
		if(row.length() > 0)
        {
			seating[0] =  Integer.parseInt(row)-1;
        }
		else
        {
			seating[0] = -1;
        }

        //Convert the first seat into a position I.E 'A' => 0 'B' => 1. Store in seating-array
        if(first != 0)
        {
			seating[1] = first - 'A'; 
        }
		else
        {
			seating[1] = -1;
        }

        //Convert the second seat (if any) into a position I.E 'A' => 0 'B' => 1. Store in seating-array
        if(last != 0)
        {
			seating[2] = last - 'A'; 
        }
		else
        {
			seating[2] = seating[1];
        }

        return seating;
    }

    /**
    * Method for booking the seats
    * @param SeatsArray - array with the existing seating
    * @param bookingRowCol - array with booking info
    * @return boolean - returns true if the booking was a succsess
    */
    public static boolean seatBooking(char[][] SeatsArray, int[] bookingRowCol)
    {

        //Check if any value in the bookingRowCol-array is less than 0, if so the user did not enter the correct data. 
        if(bookingRowCol[0] < 0 || bookingRowCol[1] < 0 || bookingRowCol[2] < 0)
        {
            return false;
        }

        //Check that the row-number is within scope.
        if(bookingRowCol[0] >= SeatsArray.length)
        {
            return false;
        }

        //Check if seats are avalible, if not return false
        for (int i = bookingRowCol[1]; i <= bookingRowCol[2]; i++)
        {
            //Check that the seats are within scope
            if (i < SeatsArray[bookingRowCol[0]].length)
            {
                if (SeatsArray[bookingRowCol[0]][i] == '#')
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
                
        }

        //Book the seats
        for (int i = bookingRowCol[1]; i <= bookingRowCol[2]; i++)
        {
            SeatsArray[bookingRowCol[0]][i] = '#';
        }
        
	    return true;
    }

    /**
    * Method for printing booking receipt
    * @param bookingArray - array with booking info
    */
    public static void printReceipt(int [] bookingArray) //ADD!!!!!!!!!!!!!!!!!!!!
    {
        int row = bookingArray[0]+1;
        int firstSeat = bookingArray[1];
        int lastSeat = bookingArray[2];
        int noOfSeats;
        char seat1;
		char seat2 ;

        
        //convert the seats to letters
        seat1 = (char)(firstSeat + 'A');
        seat2 = (char)(lastSeat + 'A');

        //How many seats were booked?
        noOfSeats = lastSeat - firstSeat +1;
    
        //Print receipt
        System.out.printf("%n--------------------------------------------");
        System.out.printf("%n Your booking was a success.");
        System.out.printf("%n--------------------------------------------");
        System.out.printf("%n You booked ");

        // more than 1 print seats
        if (noOfSeats == 1)
        {
            System.out.printf("%d seat. ", noOfSeats);
        }
        else
        {
            System.out.printf("%d seats. ", noOfSeats);
        }

        //Print which seats were chosen
        System.out.printf("%n You choose row %d seat %c", row, seat1);
        if (noOfSeats > 1)
        {
            System.out.printf(" to seat %c.%n", seat2);
        }
        else
        {
            System.out.printf(".%n", seat2);
        }
    }
}
