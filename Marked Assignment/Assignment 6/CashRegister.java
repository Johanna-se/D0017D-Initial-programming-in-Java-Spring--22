/**
* A program that works as a simple cash register system. In the program you are able to 
* add / remove articles, sell articles and present sales history.
*
* psudocode:
* create Scanner
* Method Main
*    create variables, constants and arrays
*    Do-While loop that exits if user enters 7 from method Menu. This ends the program.
*        Initiate method menu. Will return the users choice of action.
*        Use a Switch to sort the differetn actions user can select.
*        Case 1: Add new article
*            Ask user for the amount of new items to create.
*            Use method input to get a positiv int.
*            Use method insertArticles for addind the reqired new articles
*        Case 2: remove article
*            Use Method removeArticle
*        Case 3: Show the existing articles
*            Use method printArticles
*        Case 4: Sell an article
*            Use method sellArticle
*        Case 5: Show order history
*            Use method printSales
*        Case 6: Sort order history
*            Use method sortedTable
*        Case 7: Exit
*
* Methods other than main
* menu()
*    While loop that exits when number != -1
*    Print the menu
*    Ask for users choice
*    store in number = method input
*    Use Switch to check user input
*        if number = 1-7, break
*        if number != 1-7,
*            give error
*        if user enters 0
*            give error
*            reset number = -1 (the loop will not exit)
*    return number
* input()
*    while number == 0
*        If user has entered an int
*            number = user input
*            number = absolut number
*        Else 
*            give error
*        If user has entered 0
*            give error
*    return number
* insertArticle (int[][]articles, int articleNumber, int noOfArticles)
*    create constants and variables
*    Use method numberOfOccupied to see how many slots in array has article number.
*    Add the number of previous articles and the amount the user wants to add
*    Use method checkFull to see if array is large enough.
*    Use For loop to circle the array
*        If there is an avalible slote (I.E the value is 0) and noOfArticles != 0
*            New article number
*            Random new number of that article (1-10)
*            random price of new article (100-1000)
*            NOTE: If an article has been previously removed, this slot will be filled again.
*            noOfArticles--
*    return int[][]articles
* checkFull(int[][]articles, int noOfArticles)
*    If number of article are more than array.lenght
*        create new array large enough
*        copy array with method copyTwoDArray
*    return int[][]articles
* removeArticle (int[][]articles) 
*    create variables
*    Ask user what item to remove
*    Get user answer from method input
*    Use for loop to circle array, look for users input
*        If found
*            Set article number, units and price to 0
*            Set control of error to 1
*    If control of error != 1 I.E the item was not found
*        give error message.
* printArticles (int[][]articles)
*    circle array  
*        print article number, units and price for each.
* sellArticle(int[][]sales, Date[] salesDate, int[][]articles)
*    create variables
*    create date object
*    Ask user what item to sell
*    get user answer from method input
*    Ask user how many of the item to sell
*    get user answer from method input
*    Use for loop to circle array
*        If the article number is found
*            If there is enough of the item in stock
*                Make sale
*            Else
*                Set errorMessageNrSell =1 (there was not enough in stock)
*            Set errorMessageArtNr = 1 (mening that the item was found)
*    If sale was ok, I.E error check was ok
*        Store in sale array and date array
*    If error check not ok
*        give error message     
* printSales(int[][]sales, Date[] salesDate)
*    Print header
*    Use for-loop to circle array
*        Print sold article, units, total sale price and time
* sortedTable(int[][]sales, Date[] salesDate)
*    Create variables and array
*    NOTE: Will create a new array so that the old sorting of data (time) can be displayed as well.
*    Copy sale and date array in to 2 new arrays with Method copyTwoDArray
*       Use for-loop to circle array
*            min = i
*            circle array with for-loop
*                if i+1 < min
*                    min = i+1
*        Switch places of min and i in Sale Array (with temp array)
*        Switch places om min and i in date array 
*    Print the sorted array with method printSales
* numberOfOccupied(int[][]array, int position)
*    create counter
*    circle array
*        if slote is != 0
*            counter ++
*    return counter
* copyTwoDArray (int[][]arrayOrg, int[][]arrayNew)
*    cirkle array with for loop
*        copy nested array with method System.arraycopy
*    return int[][]arrayNew
*
*  @author: Johanna Petersson @ojoepe
*/

import java.util.Scanner;
import java.lang.Math;
import java.util.Date;
 
public class Main 
{
    private static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) 
    {
        // create variables
        int noOfArticles = 0;
        int userChoice = 0;

        //create constants
        final int START_ARTICLE_NUMBER = 1000;

        //create array
        int [][] articles = new int[10][3];
        int [][] sales = new int [1000][3];
        Date [] salesDate = new Date [1000];

        //do-while loop that will exit when user chooses 7 from method menu
        do
        {
            System.out.printf("%n"); //New line for readability
            
            //Ask user what they would like to do. 
            userChoice = menu();

            //Use switch for the different options
            switch (userChoice)
            {
                case 1:
                {
                    //Ask user how many article to add
                    System.out.printf("How many new articales would you like to add? ");
                    noOfArticles = input();

                    //Use method insertArticles for addind the reqired new articles
                    articles = insertArticles (articles, START_ARTICLE_NUMBER, noOfArticles);
                    break;
                }
                case 2:
                {
                    removeArticle (articles);
                    break;
                }
                case 3:
                {
                    printArticles (articles);
                    break;
                }
                case 4:
                {
                    sellArticle(sales, salesDate, articles);
                    break;
                }
                case 5:
                {
                    printSales(sales, salesDate);
                    break;
                }
                case 6:
                {
                    sortedTable(sales, salesDate);
                    break;
                }
                case 7:            
                {
                    break;
                }     
            } 
        } while (userChoice != 7);
    }


    
    /** 
    * Method for displaying the menu-options that the user can select from.
    * @return number - positive integer, users choice.
    */
    public static int menu()
    {
        //create variables
        int number = 0;

        //loop for input of data, will exit when user has input int 1-7
        while (number == 0)
        {    
            //Ask for user input
            System.out.printf("%n1. Add an article%n");
            System.out.printf("2. Remove an article%n");
            System.out.printf("3. Show articles%n");
            System.out.printf("4. Sell article%n");
            System.out.printf("5. Order history%n");
            System.out.printf("6. Sort order history table%n");
            System.out.printf("7. Exit%n");
            System.out.printf("What is your choice? ");
            number = input();
            
            //Use switch to check that users entry is valid, if not give error message and loop again.
            switch (number)
            {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6: 
                case 7:            
                {
                    break;
                }     
                default:
                {
                    number = 0;
                    System.out.printf("Incorrect entry, choose 1-7%n");
                }
            }
        }
        return number;
    } //Exit method menu


    
    /**
    * Metod for input of data from user.
    * @return number - positive integer
    */
    public static int input()
    {
        //declare variable
        int number = -1;

        //loop for input of data
        while (number == -1)
        {
            //If user has input int other than 0
            if (userInput.hasNextInt())
            {
                number = userInput.nextInt();
                
                //Makes sure the int is positive
                number = Math.abs(number);
                
                userInput.nextLine(); 
            }          
            // if user enters incorrect value, give error message and ask user to try again.  
            else
            {
                userInput.nextLine();
                System.out.printf("%nInvalid entery, must be an integer%n");
                System.out.printf("Pleace try again: ");
            }
            

            //If user has entered zero, give error
            if (number == 0)
            {
                System.out.printf("%nInvalid entery, can not be zero.%n");
                System.out.printf("Pleace try again: ");
                number = -1;
            }
        } 
        return number;      
    } //Exit input method


    
    /** 
    * Method for adding new article (Article nr, units and price) to the 2D article array.
    * @param articles - 2D int array, the array to store the data
    * @param articleNumber - interger, starting point of article number. 
    * @param noOfArticles - interger, number of new items wanted.
    * @return articles - array [][]
    */
    public static int[][] insertArticles (int[][]articles, int articleNumber, int noOfArticles)
    {
        //create constants
        final int NEW_UNITS_MAX = 10; //Max number of new units that can be added
        final int NEW_UNITS_MIN = 1; //Min number of new units that can be added
        final int NEW_PRICE_MAX = 1000; //Max price the new article
        final int NEW_PRICE_MIN = 100; //Min price the new article
        final int UNITS_RANGE = NEW_UNITS_MAX - NEW_UNITS_MIN + 1;
        final int PRICE_RANGE = NEW_PRICE_MAX - NEW_PRICE_MIN + 1;

        //Create variables
        int counter = 0;
        int numberOfSlotsNeeded = 0;
        
        //Check how many slots in the articles array has an article number whit method numberOfOccupied.
        counter = numberOfOccupied(articles, 0);

        numberOfSlotsNeeded = noOfArticles + counter;
        
        //Use method checkFull to check of that the array is long enough. 
        articles = checkFull(articles, numberOfSlotsNeeded);

        //add the new articles
        for (int i = 0; i < articles.length; i++)
        {
            //add a new artical if the slote is avalible and the number of new articles is not down to 0.
            if (noOfArticles != 0 & articles[i][0] == 0)
            {
                //add a new article number
                articles[i][0] = articleNumber + i;
                System.out.printf("%nNew articale: %d", articles[i][0]);

                /* 
                Add number of units of new article, randomly selected (1-10 pcs), 
                use Math.random for this by "Math.random () * range) + min" 
                where range = max - min + 1;
                */           
                articles[i][1] = (int) (Math.random () * UNITS_RANGE) + NEW_UNITS_MIN;
                System.out.printf(", units: %d", articles[i][1]);
                
                /*
                Add the article price of new article , randomly selected (SEK 100-1000 / pc), 
                use Math.random in the same way as above. 
                */
                articles[i][2] = (int) (Math.random () * PRICE_RANGE) + NEW_PRICE_MIN;
                System.out.printf(", price: %d", articles[i][2]);
                
                //remove one from noOfArticles as there is now one less item to add.
                noOfArticles--;
            }          
        }
        return articles;
    } // Exit method insertArticles

    
    
    /** 
    * Method for checking if the avalible slots in a 2D array ar enough, 
    * if so will return org array. 
    * If not, will create a new array with required number of slots and retur it. 
    * @param articles - 2D int array, the array to be checkt.
    * @param noOfArticles - interger, number of positions required.
    * @return articles - 2D int array
    */
    public static int[][] checkFull(int[][]articles, int noOfArticles)
    {
        //Create a new array that has the desired number of slots.
        int[][] temporaryArray = new int[noOfArticles][3];
        
        //If the desired number of slots are not available, create a new array
        if (noOfArticles > articles.length)
        {
            //Us method copyTwoDArray to copy old data to new
            articles = copyTwoDArray(articles, temporaryArray);
        }
    return articles;
    } //EXIT method checkFull


    
    /** 
    * Method for removing a articale in a 2D array. Will ask user for Artical number, 
    * search the array for it in the [0]-nested position. 
    * If found will sett all related slots to 0. If not found will give error message. 
    * @param articles - 2D int array
    */
    public static void removeArticle (int[][]articles)
    {
        //create variables
        int articalToRemove;
        int errorMessage = 0;

        //Ask user what item to remove
        System.out.printf("What article would you like to remove? ");
        articalToRemove = input();

        for (int i = 0; i < articles.length; ++i)
        {
            if (articles[i][0] == articalToRemove)
            {
                articles[i][0] = 0;
                articles[i][1] = 0;
                articles[i][2] = 0;
                errorMessage = 1;
            }
        }
        //Check if errorMessage != 1, which means that the article was not found. If so informed user
        if (errorMessage != 1)
        {
            System.out.printf("Sorry, the article nr could not be found");
        }
    }//Exit method removeArticle 

    

    /**
    * Method for printing the items Articale number, units and price in a 2D array.
    * @param articles - 2D int array
    */    
    public static void printArticles (int[][]articles)
    {
        System.out.printf("%nArticle nr:   Units:       Price:   ");
        for(int i = 0; i < articles.length; ++i)
        {
            if (articles[i][0] > 0)
                
            {
                System.out.printf("%n%d %14d %13d",articles[i][0], articles[i][1], articles[i][2]);
            }
        }    
    }



    /** 
    * Method for registering a sale of items in array article into the sales array and a dependent date of sale array. 
    * @param sales - 2D int array, store what item, units and sum of sale.
    * @param salesDate - int array, store the time of sale.
    * @param article - 2D int array, has the items for sale.
    */     
    public static void sellArticle(int[][]sales, Date[] salesDate, int[][]articles)
    {
        //create variables
        int articaleNumber = 0;
        int numberToSell = 0;
        int summeSales = 0;
        int errorMessageArtNr = 0;
        int errorMessageNrSell = 0;
        int counter = 0;

        // Create a date object
        Date dateOfSale = new Date();

        //Ask user what item to sell
        System.out.printf("%nWhat article would you like to sell? ");
        articaleNumber = input();

        //Ask user how many to sell
        System.out.printf("%nHow many would you like to sell? ");
        numberToSell = input();

        //use for-loop to seach the articles array for the correct article nr.
        for (int i = 0; i < articles.length; ++i)
        {
            //Find the right articale nr
            if (articles[i][0] == articaleNumber)
            {
                //Check if there is enough items in stock for the sale
                if (articles[i][1] >= numberToSell)
                {
                    //remove the number of items to sell from article array
                    articles[i][1] = articles[i][1] - numberToSell;
                    
                    //What is the total summe of the sale?
                    summeSales = articles[i][2] * numberToSell;
                }
                else
                {
                    errorMessageNrSell = 1; //will result in error message below.
                }                
                errorMessageArtNr = 1;
            }
        }

        //Check if the sale was a success i.e no errorMessage was thrown.
        if (errorMessageArtNr == 1 & errorMessageNrSell == 0)
        {
            //find what slot to enter the next sale in in sale-array and date-array with method numberOfOccupied.
            counter = numberOfOccupied(sales, 0);

            //Add articale number to first avalible slot in sales array
            sales[counter][0] = articaleNumber;

            //Add the number of sold items to sales array
            sales[counter][1] = numberToSell;

            //Add the total sum of sold items to sales array
            sales[counter][2] = summeSales;

            //Add the date to the date array;
            salesDate[counter] = dateOfSale;
        }
        
        //Check if errorMessageArtNr != 1, which means that the article was not found. If so informed user
        if (errorMessageArtNr != 1)
        {
            System.out.printf("Sorry, the article nr could not be found");
        }

        //Check if errorMessageNrSell == 1, which means that there where not enough items in stock. 
        if (errorMessageNrSell == 1)
        {
            System.out.printf("Sorry, there is not enough items in stock");
        }
        
    } //Exit method sellArticle



    /** 
    * Method for printing a 2D array together whit a dependent singel array
    * @param sales - 2D int array, the main array to be printed. 
    * @param salesDate - int array, the dependent array to be printed according to the sales array
    */ 
    public static void printSales(int[][]sales, Date[] salesDate)
    {
        System.out.printf("%nArticle nr:   Numbers sold:   Total sum of sales:   Date of sale:");
        //Use for-loop to chech the sales-array
        for (int i = 0; i < sales.length; ++i)
        {
            //Print if there is a sale registered on the i-slot in the sales-array i.e not zero
            if (sales[i][0] != 0)
            {
                System.out.printf("%n%d %10d %18d %21tY/%tm/%td T: %tT", sales[i][0], sales[i][1], sales[i][2], salesDate[i], salesDate[i], salesDate[i], salesDate[i]);
            }  
        }  
    } //Exit method printSales


    
    /** 
    * Method for sorting an 2D array according to the [0] nested position. 
    * The method will create a new array for printing to preserve the org sorting.
    * @param sales - 2D int array, the main array to be searched and sorted. 
    * @param salesDate - int array, the dependent array to be sorted according to the sales array
    */ 
    public static void sortedTable(int[][]sales,  Date[] salesDate)
    {
        //Create variables
        int min = 0;
        Date temp;

        //Create array
        int [] tempArray = new int [3];
        int [][] salesForPrint = new int [sales.length][3];
        Date [] salesDateForPrint = new Date [salesDate.length];

        //transfer the sales and salesDate arrays to the printing version, this will preserve the original sorted data. 
        salesForPrint = copyTwoDArray(sales, salesForPrint);
        System.arraycopy(salesDate, 0, salesDateForPrint, 0, salesDateForPrint.length);

        //sort the array
        for (int i = 0; i < salesForPrint.length; i++)
        {
             min = i;

            //Find the smallest number remaning in the [0] position in the nested array
            for (int k = i+1; k < salesForPrint.length; k++)
            {
                if (salesForPrint[k][0] < salesForPrint[min][0])
                {
                    min = k;
                }
            }
            
            //Switch places between current nested array (i) and the one with smallest number (min), use method System.arraycopy
            //Copy inte [i] position inte the temp array.
            System.arraycopy(salesForPrint[i], 0, tempArray, 0, tempArray.length);
            // Copy the [min] position inte the [i] position.
            System.arraycopy(salesForPrint[min], 0, salesForPrint[i], 0, salesForPrint[i].length);
            // Copt the temp array into the [min] position
            System.arraycopy(tempArray, 0, salesForPrint[min], 0, salesForPrint[min].length);  

            //Switch places in the date array aswell
            temp = salesDateForPrint[i];
            salesDateForPrint[i] = salesDateForPrint[min];
            salesDateForPrint[min] = temp;
        }
        //print the sorted results using method printSales
        printSales(salesForPrint, salesDateForPrint);
    }



    /** 
    * Method for checking how many slots in an 2D array are occupied, i.e not 0
    * @param array - 2D int array, the array to be searched.
    * @param position - interger, what position in nested array that is to be searched.
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
    * Method for copying a 2 D array into a new 2D array
    * @param arrayOrg - 2D int array, the original array
    * @param arrayNew - 2D int array, the new array 
    * @return arrayNew - 2D int array
    */
    public static int[][] copyTwoDArray(int[][]arrayOrg, int[][]arrayNew)
    {
        for(int i = 0; i < arrayOrg.length; ++i) 
        {
            //Copy the original arrays data into the arrayNew
            System.arraycopy(arrayOrg[i], 0, arrayNew[i], 0, arrayNew[i].length);
        }
        return arrayNew;
    }
}
