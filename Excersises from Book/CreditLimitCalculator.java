/**
*Exercise 3.18 From the book:
*Develop a Java application that determines whether any of several
*department-store customers has exceeded the credit limit on a charge account. For each customer,
*the following facts are available:
*	a) account number
*	b) balance at the beginning of the month
*	c) total of all items charged by the customer this month
*	d) total of all credits applied to the customer’s account this month
*	e) allowed credit limit.
*The program should input all these facts as integers, calculate the new balance (= beginning balance
*+ charges – credits), display the new balance and determine whether the new balance exceeds the
*customer’s credit limit. For those customers whose credit limit is exceeded, the program should display
*the message "Credit limit exceeded".
*
*Psudocode:
*1. initiate Scanner
*2. Initiate customer account, account balance, item charges, customer credits, credit limit, new balance
*3.	Ask user for account number, to exit enter -1
*4.		account number = user input
*5. While != -1
*6.		Ask user for account number, to exit enter -1
*7.			account number = user input
*8.		Ask user for balance at the beginning of the month
*9.			account balance = user input
*10.	Ask user for total of all items charged by the customer this month.
*11.		item charge = user input
*12.	Ask user for total of all credits applied to the customer’s account this month.
*13.		customer credits = user input
*14.	Ask user for the accounts allowed credit limit.
*15.		credit limit = user input
*16.	calculate new balance = account balance + item charge - customer credits
*17.	If new balance > credit limit
*18.		Display: "The inital balance for account " + account number + " was " + account balance + "." 
*19.		Display: "This months purchases was " + item charged + " and the total credits applied was " + customer credit + "."
*20.		Display: "The customer has exceeded the credit limit of" + credit limit + "."
*21. 	Else
*22.		Display: "The inital balance for account " + account number + " was " + account balance + "." 
*23.		Display: "This months purchases was " + item charged + " and the total credits applied was " + customer credit + "."
*24.		Display: "The customer is within the credit limit of" + credit limit + "."
*25.		Ask user for account number, to exit enter -1
*26.			account number = user input
*27. Display: you have exited the program. 	
*/

class CreditLimitCalculator 
{
	public static void main(String[] args)
	{
	}
}