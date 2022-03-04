/**
* From LTU: Task 4.5 - Exclusive OR *
* *- tagged tasks are a little more difficult. 
*    1.	Mammals are normally unisexual, ie either female or male. 
*		Create a logical expression with appropriate relationship operators 
*		that determines whether a particular individual is single or not. 
*		Use two different variables to represent the male. 
*		Thus a Boolean variable that is true about male and a Boolean variable that is true about female. 
*		Show how you with exclusive OR (^) can implement a solution where only one gender at a time gives true.
*    2.	Worms are bisexual hermaphrodites, ie. both male / female. 
*		Complement your solution so that the combination of male and female 
*		simultaneously shows the result of hermaphrodite.
*
*pseudocode:
* initiate Scanner
* initiate varible isItMale, isItFemale
* Ask user if the gender is male, type 1 for yes and 0 for no
* 	isItMale = user input
* Ask user if the gender is female, type 1 for yes and 0 for no
* 	isItFemale = user input
* if isItMale == 1 OR isItFemale == 1
*	Print: The individual has one gender
* else if isItMale == 1 AND isItFemale == 1
*	Print: the individual is a hermaphrodite
* else
*	Print: No gender entered
*/

import java.util.Scanner; // program uses class Scanner

class MaleOrFemale
{
	public static void main(String[] args)
	{
		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		//initiate variabls
		int isItMale;
		int isItFemale;

		// processing phase
		//ask user to input if the gender is male
		System.out.print("Is the individual male? Enter 1 for YES and 0 for NO: ");
		isItMale = input.nextInt();

		//ask user to input if the gender is female
		System.out.print("Is the individual female? Enter 1 for YES and 0 for NO: ");
		isItFemale = input.nextInt();

		if (isItMale == 1 ^ isItFemale == 1)
		{
			System.out.println("The individual has one gender");
		}
		else if (isItMale == 1 & isItFemale == 1)
		{
			System.out.println("The individual is a hermaphrodite");      
		}
		else
		{
			System.out.println("No gender entered");        
		}
	}
}
