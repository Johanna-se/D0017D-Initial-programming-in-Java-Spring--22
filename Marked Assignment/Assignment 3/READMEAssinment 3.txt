Assignment 3 - Dice game

Learning outcomes
The student must show ability and skill in using logical expressions (conditions), selections (choices) and iterations (repetitions).

Prerequisites
The assignment presupposes that you have studied the material in step 3 and bring with you knowledge and feedback from previous assignments.

Task
You will create a program that simulates the dice game 12

Begin the task by constructing a flow chart and program logic on paper. 
Then describe your structure in text form (pseudocode) in the comment header of the program 
so that an outsider can understand what the program does and how your logic / algorithm works.

The game consists of three dice and involves the sum of 12 (on any number of dice) in each round. Each dice can only be rolled once per round.

In each round, the player must be able to choose between:

    1 to roll the dice 1
    2 to roll the dice 2
    3 to roll the dice 3
    q to exit the game

The program must randomly find a value on the selected dice and then calculate the score. 
The program should also present the number of wins and the number of rounds lost. 
The program should continue until the user chooses to cancel the game. 
The definition of profit is when the sum of the dice is 12 (regardless of the number of dice) 
and the definition of loss is a sum exceeding 12 after all three dice have been rolled. 
If the sum after three rolls is less than 12, there will be no profit or loss, but you go straight to the next round.

Example Scenario

Welcome to the game 12. You must roll 1-3 dice and try to get the sum 12 ... 
Enter which dice you want to roll [1,2,3] (exit with q): 1
6 0 0 sum: 6 #win: 0 # loss: 0 
Enter which dice you want to roll [1,2,3] (exit with q): 2
6 1 0 sum: 7 # win: 0 # loss: 0 
Enter which dice you want to hit [1,2,3 ] (exit with q): 3
6 1 2 sum: 9 #win: 0 #loss: 0 
Next round! 
Enter which dice you want to roll [1,2,3] (exit with q): 1
6 0 0 sum: 6 #win: 0 # loss: 0 
Enter which dice you want to roll [1,2,3] (exit with q): 2
6 3 0 sum: 9 #win: 0 #loss: 0 
Enter which dice you want to roll [1,2,3] (exit with q): 3
6 3 3 sum: 12 #win: 1 #loss: 0 
Next round! 
Enter the dice you want to roll [1,2,3] (exit with q): q
Game Over!
Welcome to the game 12. You must roll 1-3 dice and try to get the sum 12 ... 
Enter which dice you want to roll [1,2,3] (exit with q): 1
6 0 0 sum: 6 #win: 0 # loss: 0 
Enter which dice you want to roll [1,2,3] (exit with q): 2
6 1 0 sum: 7 # win: 0 # loss: 0 
Enter which dice you want to hit [1,2,3 ] (exit with q): 3
6 1 2 sum: 9 #win: 0 #loss: 0 
Next round! 
Enter which dice you want to roll [1,2,3] (exit with q): 1
6 0 0 sum: 6 #win: 0 # loss: 0 
Enter which dice you want to roll [1,2,3] (exit with q): 2
6 3 0 sum: 9 #win: 0 #loss: 0 
Enter which dice you want to roll [1,2,3] (exit with q): 3
6 3 3 sum: 12 #win: 1 #loss: 0 
Next round! 
Enter the dice you want to roll [1,2,3] (exit with q): q
Game Over!

In this task, you must check / manage the user's entries and provide relevant feedback if incorrect entry occurs. 
The program should not crash no matter what the user enters. In one round, you can only roll each dice once. Use constants for values ​​that do not change.
