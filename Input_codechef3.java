import java.util.Scanner;

class Input_codechef3
{
	public static void main (String[] args)
	{
		// Update the blank in the code below
		Scanner read = new Scanner(System.in);
		int a = read.nextInt();
		int b = read.nextInt();
		int sum = a+b;
		int diff = a-b;
		System.out.println("Sum is: " + sum);
		System.out.println("Difference is: " + diff);
	}
}
















/*
Complete the given program to create a simple calculator that performs addition and subtraction.

Declare 2 integer variables a and b
Initialize the variables a and b with two user inputs.
Declare an integer variable sum - and assign the value of addition of a and b to it.
Declare another integer variable diff - and assign the value of subtraction of a and b to it.
Output sum and diff to the console on separate lines with the same message as given in sample output.
Sample 1:
Input
35
23
Output
Sum is: 58
Difference is: 12
 */