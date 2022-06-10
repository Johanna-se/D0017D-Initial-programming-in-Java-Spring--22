/*
* Name: @Johanna Petersson
* Exam-problem from Luleå University of Technology, LTU spring 2022
*
* Note. This is the unfinished version which was what I turned in within the exam time of 6h. There is a finished version of this program aswell.
*
* Instructions: 
* The  task  is  to  implement  a  bidding  system  for  real  estate. 
* The  program  is  supposed  to  handle information about different realestate objects, as well as the bidding process.
*
* Menu: At the start, the program should print a menu of options that can be selected by the user. It should be possible to exit the program by pressing  q.
*
* Registering an object: An object is registered by providing its address, type, as well as its asking price. 
* In the system, it is identified by using a unique randomized ID (in range 1000-9999). 
* Make sure that multiple objects do not end up with the same ID number.
*
* Bidding registration: Once an object is registered, it should be possible to bid on the property. 
* An object is referenced by the ID number which was generated in previous step. 
* A bid should be higher than the current highest bid, but it can be lower than the asking price. 
* Bidder’s name should be registered by the system. Note that the system should provide an error message if there is no object with provided ID.
*
* Ending of bidding process: Once the seller is satisfied with the highest bid, it should be possible to end the bidding process. 
* In order to be able to end the bidding process, there should be at least one (1) bid present for the object. 
* Note: it should be possible to abort the ending of the bidding process by typing ”No”.
*
* Printing of bidding history: It should be possible to print bidding history of an object. 
* If the object is sold, the accepted bid should be highlighted in some way.
*
* Printing all unsold objects: It should be possible to print all unsold objects.
*
* Printing all sold objects (sorted by highest price): Finally, there should be an option to print all sold objects. 
* The output should be sorted by the selling price (lowest to highest).
*/

import java.util.Scanner; // program uses class Scanner

class BiddingSystemExamVersion
{
	private static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        //declare variables
        final int NUMBER_OF_ESTATES = 1000; //NOTE: the higest number of estates that can be entered. A constant for easy change.
        final int MAX_NUMBER_BID = 100; //NOTE: I am assuming that no more that a 100 bids are made for any one estate.
        
        char choice;

        String[][] addressAndType = new String[NUMBER_OF_ESTATES][2];
        String[][] bidderName = new String[NUMBER_OF_ESTATES][MAX_NUMBER_BID];
        int[] startingPrice = new int[NUMBER_OF_ESTATES]; //I chose int (and not lond) for the price as the max is 2 147 483 647 which is above moste estate selling price. 
        int[][] objectIDArray = new int[NUMBER_OF_ESTATES][2]; //NOTE: if an estate is sold the [i][1]-position will have a 1 else 0.
        int[][] bidArray = new int[NUMBER_OF_ESTATES][MAX_NUMBER_BID];

        //Welcome user 
        System.out.printf("_________________________________________%n"); 
        System.out.printf("%nLTU REAL ESTATE%n");
        System.out.printf("_________________________________________%n");

        do
        {
            choice = menu ();
            switch (choice)
            {
                case'1':
                    System.out.printf("%n1. Register new object");
                    enterNewEstate(addressAndType, startingPrice, objectIDArray);
                    break;
                case'2':
                    System.out.printf("%n2. Register bid");
                    enterNewBid(bidderName, objectIDArray, bidArray);
                    break;
                case'3':
                    System.out.printf("%n3. End bidding process");
                    break;
                case'4':
                    System.out.printf("%n4. Print bidding history for object");
                    printBidHistory (bidderName, bidArray, objectIDArray);
                    break;
                case'5':
                    System.out.printf("%n5. Print all unsold objects");
                    break;
                case'6':
                    System.out.printf("%n6. Print all sold objects (by price)");
                    break;
                case'Q':
                    choice = 'q';
                case'q':
                    System.out.printf("%nThank you for today, please come again!");
                    break;
                default:
                    System.out.printf("%nInvalid entry, please try again! ");
                    
            }
        }while(choice != 'q');
    }

    /**
    * Method for printing menu and getting user choice. 
    * @return choice - char
    */ 
    public static char menu ()
    {
        //create variables
        char choice = 0;

        //Print menu
        System.out.printf("%n1. Register new object");
		System.out.printf("%n2. Register bid");
		System.out.printf("%n3. End bidding process");
		System.out.printf("%n4. Print bidding history for object");
		System.out.printf("%n5. Print all unsold objects");
		System.out.printf("%n6. Print all sold objects (by price)");
		System.out.printf("%nq. End program");
		    
        //user input
        System.out.printf("%nEnter your option: ");
        choice = userInput.next(".").charAt(0);
        userInput.nextLine();

        return choice;
    }

    /**
    * Method for getting the users input. Will print the question and check for a min and max value. 
    * If not in range will give error message. 
    * @return answer - int
    */  
    public static int inputIntMinMax(String text, String error, int min, int max)
    {
        //create variables
        int choice = min-1;

        System.out.printf(text);
        do
        {
            choice = inputInt();

            if (choice < min | choice > max)
            {
                System.out.printf(error);
                choice = min-1;
            }
        } while (choice == min-1);
        
        return choice;
    }


    
    /**
    * Method for generating a random number
    * @param min
    * @param max
    * @return number - int
    */  
    public static int randomIntMinMax(int min, int max)
    {
        //create variables
        int number; 

        //get random number
        number = (int) (Math.random () * (max - min + 1)) + min;
            
        return number;
    }


    
    /**
    * Method for getting the users input. will return a int, 
    * give error if not a int.
    * @return answer - int
    */  
    public static int inputInt()
    {
        //create variables
        int answer = 0;
        
        //loop for input of data
        while (answer == 0)
        {    
            //If the user has inputed a interger value
            if (userInput.hasNextInt())
            {
                answer = userInput.nextInt(); 
                userInput.nextLine(); 
            }
             // if user enters incorrect value  
            else
            {
                System.out.printf("Invalid entry. Please enter an interger: ");
                userInput.nextLine(); 
                answer = 0;
            }
        } 
        return answer;   
    }


    
    /**
    * Method for printing prompt and returning answer
    * @return String - user input
    */  
	public static String inputText(String text)
	{
		System.out.printf(text);
		return userInput.nextLine();
	}


    
    /**
    * Method for adding a new estate
    * @param - addressAndType, store the new address and typ
    * @param - startingPrice
    * @param - objectIDArray
    */  
    public static void enterNewEstate(String[][] addressAndType, int[] startingPrice, int[][] objectIDArray)
    {
        //create variables
        int counter = 0;

        //Find the next avalible slot
        counter = numberOfOccupied(objectIDArray, 0);

        //Get info from user
        addressAndType[counter][0] = inputText("%nEnter property's address: ");
        addressAndType[counter][1] = inputText("Enter type's address(Apartment, House or Commercial): ");
            
        startingPrice[counter] = inputIntMinMax("Enter starting price: ", "%nPlease enter a number between 0 and 2'147'483'647: ", 0, Integer.MAX_VALUE);
        
        objectIDArray[counter][0] = newObjectID(objectIDArray);
        System.out.printf("%nObject ID: %d", objectIDArray[counter][0]);
    }



    /**
    * Method for creating a new object ID
    * @param - objectIDArray
    * @return - objectID
    */  
    public static int newObjectID(int[][] objectIDArray)
    {
        //create variables
        boolean success;
        int objectID;

        do
        {
            success = true;
            objectID = randomIntMinMax(1000, 9999);

            //check if occupide
            for (int i = 0; i < objectIDArray.length; i++)
            {
                if (objectID == objectIDArray[i][0])
                {
                    success = false;
                }
            }
        }while (success = false);

        return objectID;
    }


    /** 
    * Method for checking how many slots in an 2D array are occupied
    * @param array - 2D int array
    * @param position - int
    * @return counter - interger, the number of slots occupied.
    */  
    public static int numberOfOccupied(int[][]array, int position)
    {
        //create variables
        int counter = 0; 
        
        //Check how many slots in the array that are occupied i.e not 0   .
        for (int i = 0; i < array.length; i++)
        {
            if (array[i][position] > 0)
            {
                counter++;
            }
        }
        return counter;    
    }

    /** 
    * Method for checking how many bids have been made on a object
    * @param array - 2D int array
    * @param position - int
    * @return counter - interger, the number of slots occupied.
    */  
    public static int howManyBids(int[][]array, int ObjectID)
    {
        //create variables
        int counter = 0; 
        
        //Check how many slots in the array that are occupied i.e not 0   .
        for (int i = 0; i < array[ObjectID].length; i++)
        {
            if (array[ObjectID][i] > 0)
            {
                counter++;
            }
        }
        return counter;    
    }


    /**
    * Method for adding a new estate
    * @param - String[][] bidderName names of bid histry
    * @param - int[][] objectIDArray
    * @param - int[][] bidArray - bid history
    */  
    public static void enterNewBid(String[][] bidderName, int[][] objectIDArray, int[][] bidArray)
    {
        String name; 
        int objectID;
        int counter;
        int bid;
        int positionObject = 0;
        int positionHighBid = 0;
        int highestBid = 0;

        objectID = inputIntMinMax("%nEnter object's ID number: ", "%nPlease enter a number between 0 and 2'147'483'647: ", 0, Integer.MAX_VALUE);
        if (hasObjectID(objectIDArray, objectID))
        {
            if (SoldObjectID (objectIDArray, objectID))
            {
                //circle the array to find Object ID
                for (int i = 0; i < objectIDArray.length; i++)
                {
                    if (objectIDArray[i][0] == objectID)
                    {
                        positionObject = i;
                        //Find next avalible slot to add new bid
                        counter = howManyBids(bidArray, positionObject);
                        
                        //get user input
                        name = inputText("%nEnter bidder's name: ");
                        bid = inputIntMinMax("Enter bid: ", "%nPlease enter a number between 0 and 2'147'483'647: ", 0, Integer.MAX_VALUE);

                        //check what the higest bid is
                        for (int j = 0; j < bidArray[positionObject].length; j++)
                        {
                            if (bidArray[positionObject][j] > highestBid)
                            {
                                positionHighBid = j;
                                highestBid = bidArray[positionObject][j];
                            }
                        }
                        //check if bid is higher than highestbid if so, add to arrays
                        if (bid > highestBid)
                        {
                            bidderName[positionObject][counter] = name;
                            bidArray[positionObject][counter] = bid;
                            System.out.printf("%nBid registerd!");
                        }
                        else
                        {
                                System.out.printf("%nThere is a higher bid present (%d by %s). Bid could not be registerd. ", bidArray[positionObject][positionHighBid], bidderName[positionObject][positionHighBid]);   
                        }
                    }
                }  
            }
            //If estate is sold
            else 
            {
                System.out.printf("%nThe estate is already sold. ");
            }   
        }
        //If estate ID can not be found
        else 
        {
            System.out.printf("%nCould not if Object ID.");
        }
    }


    /**
    * Method for checking if an Object ID exists
    * @param - int[][] objectIDArray, object ID occupies the [i][0]-position.
    * @param - objectID
    * @return boolean
    */ 
    public static boolean hasObjectID (int[][] objectIDArray, int objectID)
    {
        for (int i = 0; i < objectIDArray.length; i++)
        {
            if (objectIDArray[i][0] == objectID)
            {
                return true;
            }
        }
        return false;
    }

    /** 
    * Method for checking if an estat is sold or not
    * @param - int[][] objectIDArray, if an object is sold the will be a 1 in the [objectID][1]-position.
    * @param - objectID
    * @return boolean
    */ 
    public static boolean SoldObjectID (int[][] objectIDArray, int objectID)
    {
        for (int i = 0; i < objectIDArray.length; i++)
        {
            if (objectIDArray[i][0] == objectID)
            {
                if (objectIDArray[i][1] == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /** 
    * Method for printing bid history
    * @param - String[][] bidderName
    * @param - int[][] bidArray
    * @param - int[][] objectIDArray
    */ 
    public static void printBidHistory (String[][] bidderName, int[][] bidArray, int[][] objectIDArray)
    {
        int objectID;
        int posObjectID = 0;

        //Get Object ID from user. 
        objectID = inputIntMinMax("%nEnter object's ID number: ", "%nPlease enter a number between 0 and 2'147'483'647: ", 0, Integer.MAX_VALUE);

        if (hasObjectID(objectIDArray, objectID))
        {
            //location of Object
            for (int i = 0; i < objectIDArray.length; i++)
            {
                if (objectIDArray[i][0] == objectID)
                {
                    if (objectIDArray[i][1] == 0)
                    {
                        posObjectID = i;
                    }
                }
            }
        
            //Print
            System.out.printf("%n The bid history for ObjectID %d is. ", objectID);
            System.out.printf("%n Bidder      Price      Accepted ");
            for (int i = 0; i < bidArray[posObjectID].length; i++)
            {
                if (bidArray[posObjectID][i] > 0)
                {
                    System.out.printf("%n%s %10d", bidderName[posObjectID][i], bidArray[posObjectID][i]);
                }    
            }
        }
        //If estate ID can not be found
        else 
        {
            System.out.printf("%nCould not if Object ID.");
        }
    }
}