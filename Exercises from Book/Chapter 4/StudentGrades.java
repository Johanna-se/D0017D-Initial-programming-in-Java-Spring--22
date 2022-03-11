/**
* Exercise 4.17 From the book:
* (Student Grades) A group of five students earned the following grades: Student 1, ‘A’; student 2, ‘C’;
* student 3,‘B’; student 4, ‘A’and student 5, ‘B’. Write an application that reads a series
* of pairs of numbers as follows:
* 		a) student name
*		b) student letter grade
* Your program should use a switch statement to determine how many students got a grade of ‘A’,
* how many got a grade of ‘B’, how many got a grade of ‘C’, and how many got a grade of ‘D’. Use a
* loop as needed to input the five student grades, and then finally display the results.
*/

import java.util.Scanner; // program uses class Scanner

class StudentGrades
{
	public static void main(String[] args)
	{
		//create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);
    
		//declare variables
		String studentName;
		char grade;
		int NumberOfA = 0;
		int NumberOfB = 0;
		int NumberOfC = 0;
		int NumberOfD = 0;
    
		//Loop for entering student name, grade and determine how many students got each grade
		for (int counter = 1; counter <= 5 ; counter++)
		{
			//Ask for students name
			System.out.print("Enter students name: ");
			studentName = input.nextLine();

			//Ask for studens grade
			System.out.print("Enter students grade [Capital Letter]: ");
			grade = input.next().charAt(0);
			input.nextLine();

			//sort grade in a switch, default (not a valid input) will ask user to try again and set counter to counter-1
			switch (grade)
			{
				case 'A':
					++NumberOfA;
					break;
				case 'B':
					++NumberOfB;
					break;
				case 'C':
					++NumberOfC;
					break;
				case 'D':
					++NumberOfD;
					break;
				default:
					System.out.println("Not a valid grade, please try again");
					counter--;
			}//exit switch    
        
		}//exit loop

		//print results
		System.out.printf("The number of student that got an A: %d; B: %d; C: %d and D: %d%n", NumberOfA, NumberOfB, NumberOfC, NumberOfD);
	}
}
