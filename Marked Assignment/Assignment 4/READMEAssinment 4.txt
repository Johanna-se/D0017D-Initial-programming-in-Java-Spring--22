Assignment 4 - Random number

##Learning outcomes The student must show ability and skill in creating and using arrays in their program logic.
Prerequisites

The assignment presupposes that you have studied the material in step 4 and bring with you knowledge and feedback from previous assignments.

Task: You must write a program that handles random numbers. The user must first enter as many random numbers in the range 0 - 999 as desired (unlimited number, 0 - Integer.MAX_VALUE). Then the program should randomize the specified number of numbers and place these in an integer array int [] that has exactly the required size - ie neither larger nor smaller. The program should not crash no matter what the user enters.

    NOTE 1: It is not permitted to use ArrayList, Vector or any other similar Java class in this task.

    NOTE 2: Not all systems cannot allocate large amount of memory, which gives an error message "java.lang.OutOfMemoryError". In this case you should try to find out what is the maximum a system can handle.

The program must first print the numbers in the order in which they were randomized. Then program the random numbers so that they are in the order of least even integers to largest even integers and then largest odd integers to least odd integers. It is allowed to use a temporary array of the same size as the original. Finally, the program should print the numbers in the order they are in the array with a punctuation mark between even and odd numbers and the number of even and odd numbers.

Begin the task by constructing a flow chart and program logic on paper. Then describe your structure in text form (pseudocode) in the comment header of the program so that an outsider can understand what the program does and how your logic / algorithm works.



Example run of the program

Below you can see what a run of the program should look like:

How many random numbers in the range 0 - 999 are desired? 11

Here are the random numbers:
326 300 309 791 260 341 500 2 495 548 960

Here are the random numbers arranged:
2 260 300 326 500 548 960 - 791 495 341 309

Of the above 11 numbers, 7 were even and 4 odd



Tip

To check if a number is even, you can use integer division with 2 and test if the residual term is zero. The residual term is given by the operator modulus%.

For sorting, see practice problem - Arrays - Sorting.

To copy values ​​between two arrays, you can create a loop and copy one value at a time or use Java's built-in function System.arraycopy ()
