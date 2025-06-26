// Java program to take 2D array input from the user
// Using Scanner class and loops
import java.util.Scanner;

public class Input_array2 {
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);

        // Prompt the user for the dimensions of the array
        System.out.print("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int c = sc.nextInt();

        // Create the 2D array
        int[][] arr = new int[r][c];

        // Prompt the user to enter values for the array
        System.out.println("Enter the elements of the array:");

        // Input loop to populate the array
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("The entered 2D array is:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            // Move to the next line for the next row
            System.out.println(); 
        }

        // Close the Scanner object
        sc.close();
    }
}