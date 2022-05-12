/**
* A program for performing various mathematical tasks: 
* Area and volume of a cone in the first part and fractions in the second.
*
* psudocode:
* import scanner and Math
* creat Scanner object
* Method Main:
*     create variables and array
*     Greet the user to the first section of the program
*     do-while loop for volume and area calulations. It exits to the next section when user enters q.
*         get radius from method input
*         get height from method input
*         do calulations
*            get baseArea from method area(int)
*            get surfaceArea from method area(int, int)
*            get volume from method volume
*        print the results
*     Greet the user to the second section of the program
*     do-while loop for Fractions calulations. It exits when user enters q.
*        get nominator from method input
*        get denominator from method input
*        get fractionArray from method fraction
*        print results with the help of method printFraction
* Method Input: a method for getting user input
*    while true
*        if user enters a interger
*            number = user input, if user enters negative number convert to positiv
*        if user enters q
*            number = -1 this will exit the loop in Main method
*        if user enters invalid input (not a int or q) give error message
* Method area (int)
*     calculating Base area as area = PI * r^2
*     return area
* Metod area (int, int)
*    get hypotenuse from method pythagoras
*    calculating Surface area as area = PI * radius * hypotenuse
*    return area
* Metod Pythagoras
*    calculating Pythagoras' theorem radius^2 + height^2 = c^2
*    return c
* Metod volume
*    calculating the volume as volum = (PI * radius^2 * height)/3
*    return volume
* Metod fraction
*    if denominator = 0
*        return null 
*    else
*        get the quota as numerator/denominator;
*        get the fraction as numerator % denominator
*        get commonDivider with method gcd
*        divide the fraction and the denominator with the commonDivider
*        place the quota, fraction and the denominato in fractionArray
*        return fractionArray
* Method gcd
*    finding the largest common divider using Euclide's algorithm.
* Method printFraction
*    if method fraction return "null" - will print an error message
*    else
*        prints the integer array as "integer numerator / denominator".
*
*  @author: Johanna Petersson @ojoepe
*/


import java.util.Scanner;
import java.lang.Math;

public class MathematicalMethods 
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        // create variables
        int radius;
        int height;
        int nominator;
        int denominator; 
        
        float baseArea;
        float surfaceArea;
        float volume;

        //create Arrays
        int [] fractionArray;


        
        //processing
        
        //first section of program: test of area and volume methods
        //Message to user
        System.out.printf("Test of area and volume methods (to progress to the next section; enter q)%n");
        
        //loop that will exit if user enters q in the input method. 
        do
        {
            //Get radius and height from user with the input method which returns positiv interger. Check if the method returns -1 which means the user has enterd q.
            radius = input();
            if (radius == -1)
            {
                break;
            }
            
            height = input();
            if (height == -1)
            {
                break;
            }

            
            //make the calcuations for areas and volume
            baseArea = area(radius);
            surfaceArea = area(radius, height);
            volume = volume(radius, height);

            
            //Print the results
            System.out.printf("r = %d h = %d%n", radius, height);
            System.out.printf("Base area: %.2f%n", baseArea);
            System.out.printf("Surface area: %.2f%n", surfaceArea);
            System.out.printf("Volume: %.2f%n%n", volume);
            
        } while (true);


        
        //second section of the program: Test of the fractional methods
        //Message to user
        System.out.printf("Test of fractional methods (to exit; enter q)%n");
                
        //loop that will exit if user enters q in the input method. 
        do
        {
            //Get nominator and denominator from user with the input method which returns positiv interger. Check if the method returns -1 which means the user has enterd q.
            nominator = input();
            if (nominator == -1)
            {
                break;
            }
            
            denominator = input();
            if (denominator == -1)
            {
                break;
            }

            //make the calcuations
            fractionArray = fraction(nominator, denominator);
            
            //Print the results
            System.out.printf("%d/%d = ", nominator, denominator);
            printFraction(fractionArray);
            System.out.printf("%n");
            
            
        } while (true);       
    } //Exit main metod

    

    //Method used in both sections of the main method
    
    /**
    * Metod for input of data from user. It returns a positive interger or -1 if user enters q. 
    * @return number - positive integer
    */
    public static int input()
    {
        //declare variable
        int number = 0;

        //loop for input of data
        while (true)
        {    
            //If the user has inputed a interger value
            if (userInput.hasNextInt())
            {
                number = userInput.nextInt(); 
                number = Math.abs(number);
                break;
            }
            
            //If the user has inputed q (to quit)
            else if (userInput.next().equalsIgnoreCase("q"))
            {
                number = -1;
                break;
            }
            
            // if user enters incorrect value  
            else
            {
                System.out.printf("Invalid entery.%n");
            }
        } 
        return number;        
    } //Exit input method


    
    //Mehods used in the first section of the main-method
    
    /**
    * Metod for calculating Base area as area = PI * r^2
    * Method uses Math.PI and Math.pow
    * @param radius - interger
    * @return area - float
    */
    public static float area(int radius) 
    {
        //declare variable
        float area;
        final double EXPONENT = 2; //used in Math.pow

        //calculate area as area = PI (NOTE uses Math.PI for this) * radius ^ 2
        area =  (float) Math.PI * (float) Math.pow((double) radius, EXPONENT);
        return area; 
    } 

    /**
    * Metod for calculating Surface area as area = PI * radius * hypotenuse
    * hypotenuse is obtained in the metod pythagoras
    * Method uses Math.PI
    * @param radius - interger
    * @param height - interger
    * @return area - float
    */
    public static float area(int radius, int height)
    {
        //variables
        float hypotenuse;
        float area;

        //get s from method pytagoras
        hypotenuse = pythagoras(radius, height);

        // calculate the surface area
        area = (float) Math.PI * (float) radius * hypotenuse;

        return area;       
    } 

    /**
    * Metod for calculating Pythagoras' theorem a^2 + b^2 = c^2
    * Method uses Math.pow for a^2 and b^2
    * Method uses Math.sqrt to calc c from c^2
    * @param sideA - interger radius
    * @param sideB - interger height
    * @return sideC - float (the hypotenuse)
    */
    public static float pythagoras(int sideA, int sideB)
    {
        //variables
        float sideC;
        double sideCSqrt;
        final double EXPONENT = 2; //used in Math.pow
        
        //first calculate c^2
        sideCSqrt = (double) Math.pow((double) sideA, EXPONENT) + (double) Math.pow((double) sideB, EXPONENT);

        //calculate c by square root (with Math-method) of sideCSqrt
        sideC = (float) Math.sqrt(sideCSqrt);

        return sideC;       
    } 

    /**
    * Metod for calculating the volume as volum = (PI * radius^2 * height)/3
    * Method uses Math.PI and Math.pow
    * @param radius - interger 
    * @param height - interger 
    * @return volume - float 
    */
    public static float volume(int radius, int height)
    {
        //variables
        float volume;
        final double EXPONENT = 2; //used in Math.pow

        //calculate the volum
        volume = ((float) Math.PI * (float) Math.pow((double) radius, EXPONENT) * (float) height) / 3;

        return volume;        
    }



    //Methods used in the second section of the main method
    
    /**
    * Metod for calculating fraction
    * Method uses metod gcd to find the largest common divide
    * @param nominator - interger 
    * @param denominator - interger 
    * @return fractionArray - integer array with [0] = quota; [1] = fraction (after division with commonDivider); [2] = denominator (after division with commonDivider)
    */
    public static int[] fraction(int numerator, int denominator)
    {
        //variables
        int quota;
        int fraction;
        int commonDivider;
        int [] fractionArray = new int[3];

        //if denominator is 0 return null, else proceed
        if (denominator == 0)
        {
            return null;
        }
        else
        {
            //calculate the quota
            quota = numerator/denominator;
        
            //calulate the the fraction
            fraction = numerator % denominator;
            
            //Find the largest common divider between the fraction and the denominator with metod gcd and place in commonDivider
            commonDivider = gcd(fraction, denominator);

            //As long as commonDivider is not 0, use it to divide the fraction and the denominator.
            if (commonDivider != 0)
            {
                fraction = fraction / commonDivider;
                denominator = denominator / commonDivider;
            }

            //place in the array
            fractionArray [0] = quota;
            fractionArray [1] = fraction;
            fractionArray [2] = denominator;

            return fractionArray;
        }
    } //Exit fraction method

    /**
    * Metod for Shortening (finding the largest common divider using Euclide's algorithm)
    * pseudokod provided by teacher:
    * 1. Make sure that  a > b (change place if necessary)
    * 2. As long as b is not 0 (use a while loop)
    *        2.1 c = a % b
    *        2.2 a = b
    *        2.3 b = c
    * 3. return a
    * @param a - interger 
    * @param b - interger 
    * @return a - integer (when b = 0)
    */
    public static int gcd(int a, int b)
    {
        //variables
        int c;

        //Check that a > b , if not change place with the help of c as place holder for a
        if (b > a)
        {
            c = a;
            a = b;
            b = c;
        }

        //Loop as long as b is not 0
        while (b != 0)
        {
            c = a % b;
            a = b;
            b = c;
        }
        
        return a;
    }

    /**
    * Metod for printing fraction, will prints the integer array as "integer numerator / denominator".
    * if method fraction returned "null" - will print a error message
    * @param parts - interger array
    * return void
    */
    public static void printFraction(int[] parts) 
    {
        //If the fraction method returns null, print error; else proceed with printing
        if (parts == null)
        {
            System.out.printf("Error");            
        }
        else
        {
            if (parts [0] != 0)
            {
                System.out.printf("%d",parts [0]);
            }
            if (parts [1] != 0)
            {
                System.out.printf(" %d/%d", parts [1], parts [2]); 
            }
            if (parts [0] == 0 && parts [1] == 0)
            {
                System.out.printf(" 0"); 
            }
        }
    }  
}
