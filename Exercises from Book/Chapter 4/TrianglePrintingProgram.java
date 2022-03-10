/**
* Exercise 4.15 From the book:
* (Triangle Printing Program) Write an application that displays the following patterns separately,
* one below the other. Use for loops to generate the patterns. All asterisks (*) should be printed
* by a single statement of the form System.out.print('*'); which causes the asterisks to print side
* by side. A statement of the form System.out.println(); can be used to move to the next line. A
* statement of the form System.out.print(' '); can be used to display a space for the last two patterns.
* There should be no other output statements in the program. [Hint: The last two patterns require
* that each line begin with an appropriate number of blank spaces.]
*   (a)          (b)         (c)         (d)
*    *           **********  **********           *
*    **          *********    *********          **
*    ***         ********      ********         ***
*    ****        *******        *******        ****
*    *****       ******          ******       *****
*    ******      *****            *****      ******
*    *******     ****              ****     *******
*    ********    ***                ***    ********
*    *********   **                  **   *********
*    **********  *                    *  **********
*/

class TrianglePrintingProgram
{
	public static void main(String[] args)
	{
		// print header
		System.out.println("(a)");
    
		// loop for printing the 10 lines in pattern a
		for (int lines = 1; lines <= 10; lines++)
		{
			//loop for printing "*"
			for (int counter = 1; counter <= lines; counter++ )
			{
				System.out.print("*");
			}  
			System.out.println();
		}

      
		System.out.println();    

    
		// print header
		System.out.println("(b)");
    
		// loop for printing the 10 lines in pattern b
		for (int lines = 1; lines <= 10; lines++)
		{
			//loop for printing "*"
			for (int counter = 10; counter >= lines; counter--)
			{
				System.out.print("*");
			}  
			System.out.println();
		}

		System.out.println();

		// print header
		System.out.println("(c)");
    
		// loop for printing the 10 lines in pattern d
		for (int lines = 1; lines <= 10; lines++)
		{
			//loop for printing " " before the "*"
			for (int counter = 1; counter <= lines; counter++)
			{
				System.out.print(" ");
			} 
			//loop for printing "*"
			for (int counter = 10; counter >= lines; counter--)
			{
				System.out.print("*");
			}  
			System.out.println();
		}

    
		System.out.println();

		// print header
		System.out.println("(d)");
    
		// loop for printing the 10 lines in pattern d
		for (int lines = 1; lines <= 10; lines++)
		{
			//loop for printing " " before the "*"
			for (int counter = 10; counter >= lines; counter--)
			{
				System.out.print(" ");
			} 
			//loop for printing "*"
			for (int counter = 1; counter <= lines; counter++)
			{
				System.out.print("*");
			}  
			System.out.println();
		}
	}
}
