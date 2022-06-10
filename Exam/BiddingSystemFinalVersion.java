/*
* Name: @Johanna Petersson
* Exam-problem from Luleå University of Technology, LTU spring 2022
*
* Note. This is the finished version which i completed after the exam time of 6h.
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

class BiddingSystemFinalVersion
{
	private static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        //declare variables
        final int NUMBER_OF_ESTATES = 1000; //NOTE: the higest number of estates that can be entered. A constant for easy change.
        final int MAX_NUMBER_BID = 100; //NOTE: I am assuming that no more that a 100 bids are made for any one estate.
        
        int choice;

        String[][] addressAndType = new String[NUMBER_OF_ESTATES][2];
        String[][] bidderName = new String[NUMBER_OF_ESTATES][MAX_NUMBER_BID];
        int[][] objectIDAndPrice = new int[NUMBER_OF_ESTATES][3]; //I chose int (and not lond) for the price as the max is 2 147 483 647 which is above moste estate selling price. objectIDAndPrice[0] = objectID, objectIDAndPrice[1] = start price, objectIDAndPrice[2] = sold price, 
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
                case -1:
                    System.out.printf("%nThank you for today, please come again!");
                    break;
                case 1:
                    System.out.printf("%n1. Register new object");
                    enterNewEstate(addressAndType, objectIDAndPrice);
                    break;
                case 2:
                    System.out.printf("%n2. Register bid");
                    enterNewBid(bidderName, objectIDAndPrice, bidArray);
                    break;
                case 3:
                    System.out.printf("%n3. End bidding process");
                    endBidding(bidderName, objectIDAndPrice, bidArray);
                    break;
                case 4:
                    System.out.printf("%n4. Print bidding history for object");
                    printBidHistory (bidderName, bidArray, objectIDAndPrice);
                    break;
                case 5:
                    System.out.printf("%n5. Print all unsold objects");
                    printUnSold(addressAndType, objectIDAndPrice, bidArray);
                    break;
                case 6:
                    System.out.printf("%n6. Print all sold objects (by price)");
                    printSold(addressAndType, objectIDAndPrice);
                    break;
                default:
                    System.out.printf("%nInvalid entry, please try again! ");
                    
            }
        }while(choice != -1);
    }

    /**
    * Method for printing menu and getting user choice. 
    * @return choice - char
    */ 
    public static int menu ()
    {
        //create variables
        int choice = 0;

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
        choice = inputInt();
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
            userInput.nextLine();

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
        int answer = -2;
        
        //loop for input of data
        while (answer == -2)
        {    
            //If the user has inputed a interger value
            if (userInput.hasNextInt())
            {
                answer = userInput.nextInt(); 
                answer = Math.abs(answer);
            }
            
            //If the user has inputed q (to quit)
            else if (userInput.next().equalsIgnoreCase("q"))
            {
                answer = -1;
            }
            
            // if user enters incorrect value  
            else
            {
                System.out.printf("Invalid entery.%n");
                answer = -2;
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
    * @param - objectIDAndPrice
    * @param - objectIDAndPrice
    */  
    public static void enterNewEstate(String[][] addressAndType, int[][] objectIDAndPrice)
    {
        //create variables
        int counter = 0;

        //Find the next avalible slot
        counter = numberOfOccupied(objectIDAndPrice, 0);

        //Get info from user
        addressAndType[counter][0] = inputText("%nEnter property's address: ");
        addressAndType[counter][1] = inputText("Enter type's address(Apartment, House or Commercial): ");
            
        objectIDAndPrice[counter][1] = inputIntMinMax("Enter starting price: ", "%nPlease enter a number between 0 and 2'147'483'647: ", 0, Integer.MAX_VALUE);
        
        objectIDAndPrice[counter][0] = newObjectID(objectIDAndPrice);
        System.out.printf("%nObject ID: %d", objectIDAndPrice[counter][0]);
    }



    /**
    * Method for creating a new object ID
    * @param - objectIDAndPrice
    * @return - objectID
    */  
    public static int newObjectID(int[][] objectIDAndPrice)
    {
        //create variables
        boolean success;
        int objectID;

        do
        {
            success = true;
            objectID = randomIntMinMax(1000, 9999);

            //check if occupide
            for (int i = 0; i < objectIDAndPrice.length; i++)
            {
                if (objectID == objectIDAndPrice[i][0])
                {
                    success = false;
                }
            }
        }while(success == false);

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
    * @param - int[][] objectIDAndPrice, contains [i][0] = ObjectID
    * @param - int[][] bidArray - bid history
    */  
    public static void enterNewBid(String[][] bidderName, int[][] objectIDAndPrice, int[][] bidArray)
    { 
        //create variables
        String name; 
        int objectID;
        int counter;
        int bid;
        int positionObject = 0;
        int positionHighBid = 0;
        int highestBid = 0;

        objectID = inputIntMinMax("%nEnter object's ID number: ", "%nPlease enter a number between 0 and 2'147'483'647: ", 0, Integer.MAX_VALUE);
        if (hasObjectID(objectIDAndPrice, objectID))
        {
            if (SoldObjectID (objectIDAndPrice, objectID) == false)
            {
                //circle the array to find Object ID
                for (int i = 0; i < objectIDAndPrice.length; i++)
                {
                    if (objectIDAndPrice[i][0] == objectID)
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
            System.out.printf("%nCould not find the Object ID.");
        }
    }


    /**
    * Method for checking if an Object ID exists
    * @param - int[][] objectIDAndPrice, object ID occupies the [i][0]-position.
    * @param - objectID
    * @return boolean
    */ 
    public static boolean hasObjectID (int[][] objectIDAndPrice, int objectID)
    {
        for (int i = 0; i < objectIDAndPrice.length; i++)
        {
            if (objectIDAndPrice[i][0] == objectID)
            {
                return true;
            }
        }
        return false;
    }

    /** 
    * Method for checking if an estat is sold or not
    * @param - int[][] objectIDAndPrice, if an object is sold the will be a sell price in the [objectID][2]-position.
    * @param - objectID
    * @return boolean
    */ 
    public static boolean SoldObjectID (int[][] objectIDAndPrice, int objectID)
    {
        for (int i = 0; i < objectIDAndPrice.length; i++)
        {
            if (objectIDAndPrice[i][0] == objectID)
            {
                if (objectIDAndPrice[i][2] > 0)
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
    * @param - int[][] objectIDAndPrice
    */ 
    public static void printBidHistory (String[][] bidderName, int[][] bidArray, int[][] objectIDAndPrice)
    {
        //create variables
        int objectID;
        int posObjectID = 0;
        int acceptedBid = 0;

        //Get Object ID from user. 
        objectID = inputIntMinMax("%nEnter object's ID number: ", "%nPlease enter a number between 0 and 2'147'483'647: ", 0, Integer.MAX_VALUE);

        if (hasObjectID(objectIDAndPrice, objectID))
        {
            //location of Object
            for (int i = 0; i < objectIDAndPrice.length; i++)
            {
                if (objectIDAndPrice[i][0] == objectID)
                {
                    posObjectID = i;
                }
            }

            //If object is sold, find the highest bid.
            if (SoldObjectID (objectIDAndPrice, objectID))
            {
                for (int j = 0; j < bidArray[posObjectID].length; j++)
                {
                    if (bidArray[posObjectID][j] > acceptedBid)
                    {
                        acceptedBid = bidArray[posObjectID][j];
                    }
                }
            }
        
            //Print
            System.out.printf("%nThe bid history for ObjectID %d is. ", objectID);
            System.out.printf("%n%-15s %-15s %-15s", "Bidder", "Price", "Accepted");
            for (int j = 0; j < bidArray[posObjectID].length; j++)
            {
                if (bidArray[posObjectID][j] > 0)
                {
                    System.out.printf("%n%-15s %-15d", bidderName[posObjectID][j], bidArray[posObjectID][j]);
                    if (SoldObjectID (objectIDAndPrice, objectID))
                    {
                        if (bidArray[posObjectID][j] == acceptedBid)
                        {
                            System.out.printf(" %-15s", "yes");
                        }
                    }
                }
                else
                {
                    System.out.printf("%n"); //line for readability
                    break;
                }
            }
        }
        //If estate ID can not be found
        else 
        {
            System.out.printf("%nCould not find the Object ID.");
        }
    }



    /** 
    * Method for printing unsold estate
    * @param - String[][] addressAndType
    * @param - int[][] objectIDAndPrice
    * @param - int[][] bidArray
    */ 
    public static void printUnSold(String[][] addressAndType, int[][] objectIDAndPrice, int[][] bidArray)
    {
        //create variables
        int highestBid = 0;

        //print header
        System.out.printf("%n%-7s %-20s %-15s %-15s %-15s", "ID", "Address", "Type", "Asking price", "Highest bid");

        //print info if it has ObjectId and not sold
        for (int i = 0; i < objectIDAndPrice.length; i++)
        {
            if (SoldObjectID (objectIDAndPrice, objectIDAndPrice[i][0]) == false && objectIDAndPrice[i][0] > 0)
            {
                //Find highest bid
                for (int j = 0; j < bidArray[i].length; j++)
                {
                    if (bidArray[i][j] > highestBid)
                    {
                        highestBid = bidArray[i][j];
                    }
                }
                
                System.out.printf("%n%-7d %-20s %-15s %-15d %-15d ",objectIDAndPrice[i][0], addressAndType[i][0], addressAndType[i][1], objectIDAndPrice[i][1], highestBid);
            }
        }
        
        System.out.printf("%n");
    }



    /** 
    * Method for ending a bidding-process, askes user to accept higest bid (stored in bidArray) and if so store it in [ObjectID][2]-position of objectIDAndPrice.
    * @param - String[][] bidderName names of bid histry
    * @param - int[][] objectIDAndPrice
    * @param - int[][] bidArray - bid history
    */ 
    public static void endBidding(String[][] bidderName, int[][] objectIDAndPrice, int[][] bidArray)
    {
        String userChoice;
        String printingString;
        int objectID;
        int positionObject = 0;
        int positionHighBid = 0;
        int highestBid = 0;

        objectID = inputIntMinMax("%nEnter object's ID number: ", "%nPlease enter a number between 0 and 2'147'483'647: ", 0, Integer.MAX_VALUE);
        if (hasObjectID(objectIDAndPrice, objectID))
        {
            if (SoldObjectID (objectIDAndPrice, objectID) == false)
            {
                //circle the array to find Object ID
                for (int i = 0; i < objectIDAndPrice.length; i++)
                {
                    if (objectIDAndPrice[i][0] == objectID)
                    {
                        positionObject = i;
                        
                        //check what the higest bid is
                        for (int j = 0; j < bidArray[positionObject].length; j++)
                        {
                            if (bidArray[positionObject][j] > highestBid)
                            {
                                positionHighBid = j;
                                highestBid = bidArray[positionObject][j];
                            }
                        }

                        //If there is a bid i.e higher than 0
                        if (highestBid > 0)
                        {
                            //Ask user to accept bid yes/no
                            printingString = "%nAccept bid by " + bidderName[positionObject][positionHighBid] + "(" + bidArray[positionObject][positionHighBid] + ")? (Yes/No): ";
                            userChoice = inputText(printingString);

                            if (userChoice.equalsIgnoreCase("yes"))
                            {
                                System.out.printf("%nBid accepted, object is sold!");
                                //mark the object as sold.
                                objectIDAndPrice[positionObject][2] = highestBid;
                            }
                            else
                            {
                                System.out.printf("%nEnd bidding process aborted.");
                            }
                        }
                        else
                        {
                            System.out.printf("%nThere are no bids on the Object. ");  
                                //System.out.printf("%nThere is a higher bid present (%d by %s). Bid could not be registerd. ", bidArray[positionObject][positionHighBid], bidderName[positionObject][positionHighBid]);   
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
            System.out.printf("%nCould not find the Object ID.");
        }
    }




    /** 
    * Method for printing sold estate, will copy arrays and sort data according to sold price
    * @param - String[][] addressAndType 
    * @param - int[][] objectIDAndPrice
    */ 
    public static void printSold(String[][] addressAndType, int[][] objectIDAndPrice)
    {
        //Create variables
        int min = 0;

        //Create array
        int [] tempArray = new int [3];
        String [] tempString = new String [2];
        int [][] objectIDAndPriceForPrint = new int[objectIDAndPrice.length][3];
        String[][] addressAndTypeForPrint = new String [addressAndType.length][2];

        //copy array to printing version 
        copyTwoDArray(objectIDAndPrice, objectIDAndPriceForPrint);
        copyTwoDArray(addressAndType, addressAndTypeForPrint);
        

        //sort the array by higest sell price ([i][2]-position)
        for (int i = 0; i < objectIDAndPriceForPrint.length; i++)
        {
            min = i;

            //Find the smallest number remaning in the [0] position in the nested array
            for (int k = i+1; k < objectIDAndPriceForPrint.length; k++)
            {
                if (objectIDAndPriceForPrint[k][2] < objectIDAndPriceForPrint[min][2])
                {
                    min = k;
                }
            }
            
            //Switch places between current nested array (i) and the one with higest number (min), use method System.arraycopy
            //Copy inte [i] position inte the temp array.
            System.arraycopy(objectIDAndPriceForPrint[i], 0, tempArray, 0, tempArray.length);
            System.arraycopy(addressAndTypeForPrint[i], 0, tempString, 0, tempString.length);
            
            // Copy the [min ] position inte the [i] position.
            System.arraycopy(objectIDAndPriceForPrint[min], 0, objectIDAndPriceForPrint[i], 0, objectIDAndPriceForPrint[i].length);
            System.arraycopy(addressAndTypeForPrint[min], 0, addressAndTypeForPrint[i], 0, addressAndTypeForPrint[i].length);
            
            // Copy the temp array into the [min] position
            System.arraycopy(tempArray, 0, objectIDAndPriceForPrint[min], 0, objectIDAndPriceForPrint[min].length);
            System.arraycopy(tempString, 0, addressAndTypeForPrint[min], 0, addressAndTypeForPrint[min].length); 

        }

        
        //print the sorted results
        System.out.printf("%n%-7s %-20s %-15s %-15s %-15s", "ID", "Address", "Type", "Asking price", "Sold for");

        for (int i = 0; i < objectIDAndPriceForPrint.length; i++)
        {
            if (SoldObjectID (objectIDAndPriceForPrint, objectIDAndPriceForPrint[i][0]))
            {
                System.out.printf("%n%-7s %-20s %-15s %-15s %-15s",objectIDAndPriceForPrint[i][0], addressAndTypeForPrint[i][0], addressAndTypeForPrint[i][1], objectIDAndPriceForPrint[i][1], objectIDAndPriceForPrint[i][2]);
            }
        }
        
        System.out.printf("%n");
    }



    /** 
    * Method for copying a 2 D int array
    * @param arrayOrg - 2D int array, the original array
    * @param arrayNew - 2D int array, the new array 
    */
    public static void copyTwoDArray(int[][]arrayOrg, int[][]arrayNew)
    {
        for(int i = 0; i < arrayOrg.length; ++i) 
        {
            //Copy the original arrays data into the arrayNew
            System.arraycopy(arrayOrg[i], 0, arrayNew[i], 0, arrayNew[i].length);
        }
    }

    /** 
    * Method for copying a 2 D String array 
    * @param arrayOrg - 2D String array, the original array
    * @param arrayNew - 2D String array, the new array 
    */
    public static void copyTwoDArray(String[][]arrayOrg, String[][]arrayNew)
    {
        for(int i = 0; i < arrayOrg.length; ++i) 
        {
            //Copy the original arrays data into the arrayNew
            System.arraycopy(arrayOrg[i], 0, arrayNew[i], 0, arrayNew[i].length);
        }
    }
}