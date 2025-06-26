/*
MCQ - 21
What will be the output of this code, if the user enters Chef?

class Codechef {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String s = read.nextLine();
        System.out.println("Your name is: " + s);
    }
}

Correct Answer:
Your name is: Chef
Explanation:
The code reads the input "Chef" using read.nextLine().
It then concatenates this input with the string "Your name is: " and prints it using System.out.println(), resulting in "Your name is: Chef".
So, the output of the code when the user enters "Chef" is "Your name is: Chef".

MCQ - 22
What will be the output of this code, if the user enters a = 5 and b = 9?

import java.util.*;
class Codechef {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int a = read.nextInt();
        int b = read.nextInt();
        System.out.println(a + "" + b + "" + (a + b)); // "" is empty string and not single space
    }
}

Correct Answer:
5914
Explanation:
Now, if the user enters "a = 5" and "b = 9", here's what happens:
The code reads 5 as the value of a and 9 as the value of b.
Then, it concatenates the values of a, b, and their sum, but since they are integers, it performs arithmetic addition rather than string concatenation. So, the sum of a and b (5 + 9 = 14) is added to the string formed by concatenating the values of a and b.
Therefore, the output of the code will be: "59" + "14" = "5914".

MCQ - 23
What will be the output of this code, if the user enters 
5 and 9 when asked for input for a and b respectively?

class Codechef {
  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);
    int a = read.nextInt();
    int b = read.nextInt();
    int c = a + 2;
    int d = c + b;
    System.out.println(d);
  }
}

Correct Answer:
16
Explanation:
int a = read.nextInt(); // user enters 5
int b = read.nextInt(); // user enters 9
int c = a + 2;  // c = 5 + 2 = 7
int d = c + b;  // d = 7 + 9 = 16
*/