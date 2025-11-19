import java.util.Scanner;

class Input_codechef1
{
	public static void main (String[] args)
	{
		// your code goes here
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println(name);
	}
}


























/*https://www.codechef.com/learn/course/java/LTJPP11/problems/USRJ1V2 */
/*Java uses the Scanner class found in java.util package to get user input. You have to import the package to use the Scanner class.

In Java, the import keyword is used to bring in classes or entire packages from external libraries or modules into your current source file, allowing you to use their functionality without having to fully qualify their names every time.

import java.util.Scanner;
To use the Scanner class, you have to create an object of the class and use any of the methods to read string, numbers etc.

Scanner objName = new Scanner(System.in);
The method nextLine() is used to read a line of text from input and return it in string format. The following line will read a string input from user. We will also see how to read integers and other data types later on.

String varName = objName.nextLine();
Click on 'Submit' in the IDE to run the code.

Sample 1:
Input
John
Output
John */