//Taking input of an array from user using BufferedReader and InputStreamReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input_array3
{
    public static void main(String[] args) throws IOException 
    {
        // Initializing the object InputStreamReade 
         
        InputStreamReader in = new InputStreamReader(System.in);
        
        // Initializing the object of BufferedReader 
        BufferedReader br = new BufferedReader(in);

        // Take the array size from the user
        System.out.println("Enter the size of the array: ");
        int s = 0;
        try {
            s = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for array size. Please enter a valid integer.");
            return;
        }

        // Initialize the array's
        // size using user input
        int[] arr = new int[s];

        // Take user elements for the array
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < s; i++) {
            try {
                arr[i] = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for array element. Please enter a valid integer.");
                return;
            }
        }

        System.out.println("The elements of the array are: ");
        for (int i = 0; i < s; i++) {
          
            System.out.print(arr[i] + " ");
        }

        // Close the BufferedReader
        br.close();
    }
}