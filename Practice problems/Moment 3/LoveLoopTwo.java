/**
* From LTU: Task 4.9 - Predefined termination with the pre-construction
* 
*	1.	Try to re-implement the loop that prints the message of love 10 times but this time with a for statement.
*	2.	What do you find useful about the for construction compared to while , do-while ?
*	3.	Try implementing the for statement with index update inside the repetition block, that is, with for (; i <10;). 
*		What conclusions can be drawn with regard for -satsens three parts after running the second example, with the same result.
*
*pseudocode:
* for (int counter = 1; counter <= 10; counter++)
*	print: love, love everywhere
* alt
* for (int counter = 1; counter <= 10)
*	print: love, love everywhere
*	counter++;	
*/


class LoveLoopTwo
{
	public static void main(String[] args)
	{

		for (int counter = 1; counter <= 10 ; counter++)
		{
			System.out.println ("love, love everywhere");
		}
      
		System.out.println ("\nOnce more with feeling! \n");

		for (int counter = 1; counter <= 10;)
		{
			System.out.println ("love, love everywhere");
			++counter;
		}		
	}
}
