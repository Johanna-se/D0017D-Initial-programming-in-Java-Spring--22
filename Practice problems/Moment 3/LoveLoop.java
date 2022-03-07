/**
* From LTU: Task 4.8 - Control termination in the while construction
* 
* 	1.	Try to implement a while loop that prints the love message "love, love everywhere" 
*		10 times partly by updating the index inside the while block, 
*		partly by directly updating with preincrement in the condition statement.  
*	2.	Does it matter if you use preincrement (++ i) or postincrement (i ++) 
*		in the condition? Try changing the way you make the increments 
*		and test run your application again with the new enumeration.
*
*pseudocode:
* initiate varible counter=1
* while counter <= 10
*	print: love, love everywhere
*	counter++ 
* alt:
* while ++counter <= 10
*	print: love, love everywhere
* alt:
* while counter++ <= 10
*	print: love, love everywhere
*/


class LoveLoop
{
	public static void main(String[] args)
	{
		
		int counter = 1; 

		//alt 1
		while (counter <= 10)
		{
		System.out.println ("love, love everywhere");
		counter++;
		}
    
		//alt 2
		System.out.println ("\nThat was fun, let´s go again! \n");
		counter = 1; //reset counter
    
		while (++counter <= 10)
		{
			System.out.println ("love, love everywhere");
		}

		//alt 3
		System.out.println ("\nHey! That was only 9 times!");
		System.out.println ("Once more with feeling! \n");
		counter = 1; //reset counter

		while (counter++ <= 10)
		{
			System.out.println ("love, love everywhere");
		}
    
		System.out.println ("\nThere you go!");
	}
}
