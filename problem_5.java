class problem_5 {
    public String longestPalindrome(String s) {
        int n = s.length(); // Get the length of the string.
        boolean[][] dp = new boolean[n][n]; // Create a dynamic programming (DP) table. //Boolean is a data type that can have only two possible values: true or false.
        //Dynamic programming (DP) is a problem-solving technique that breaks down complex problems into smaller, overlapping subproblems and solves each subproblem only once, storing the results for later use. eg. Finding longest common subsequence,Finding the nth Fibonacci number 
        // Initialize all substrings of length 1 (single character) as a palindrome.
        for (boolean[] row : dp) { // For each loop through each row in the DP table.
            Arrays.fill(row, true);
        }
      
        int startIdx = 0; // Starting index of the longest palindromic substring found.
        int maxLength = 1; // Length of the longest palindromic substring found, initialized with length 1.
      
        // Build the DP table in a bottom-up manner.
        for (int i = n - 2; i >= 0; --i) { // Start from the second last character and move backwards.
            for (int j = i + 1; j < n; ++j) { // Compare it with characters ahead of it.
                dp[i][j] = false; // Initialize the current substring (i, j) as not palindrome.
                if (s.charAt(i) == s.charAt(j)) { // If the characters match,
                    dp[i][j] = dp[i + 1][j - 1]; // Check if removing them gives a palindrome.
                    // Update the start position and max length if a larger palindrome is found.
                    if (dp[i][j] && maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        startIdx = i;
                    }
                }
            }
        }
      
        // Extract the longest palindromic substring from the string.
        return s.substring(startIdx, startIdx + maxLength);
    }
    public static class Arrays {
        public static void fill(boolean[] array, boolean value) {
            for (int i = 0; i < array.length; i++) {
                array[i] = value;
            }
        }
    }
    public static void main(String[] args) {
        // Example usage
        problem_5 solution = new problem_5();
        String s = "babad";
        String result = solution.longestPalindrome(s);
      
        // Print the result
        System.out.println("Longest palindromic substring: " + result);
    }
}
/*
Visualization:

### **String: "babad"**

We want to find the longest palindromic substring. The idea is to use a DP table that helps us store whether a given substring is a palindrome or not.

#### **Step 1: Initialize the DP Table**

Start by creating a 2D boolean table, `dp`, where `dp[i][j]` will be `true` if the substring `s[i...j]` is a palindrome.

Here’s the initial table (size 5x5 because "babad" has 5 characters):

```
dp = [
  [false, false, false, false, false],
  [false, false, false, false, false],
  [false, false, false, false, false],
  [false, false, false, false, false],
  [false, false, false, false, false]
]
```

#### **Step 2: Set all single characters as palindromes**

Single characters are always palindromes. So, set `dp[i][i] = true` for all `i`:

```
dp = [
  [true, false, false, false, false],
  [false, true, false, false, false],
  [false, false, true, false, false],
  [false, false, false, true, false],
  [false, false, false, false, true]
]
```

#### **Step 3: Check for two-character substrings**

Next, check if any 2-character substrings are palindromes (i.e., `s[i] == s[i+1]`):

* For `i = 0`, `s[0] == s[1]` ("b" == "a") → false
* For `i = 1`, `s[1] == s[2]` ("a" == "b") → false
* For `i = 2`, `s[2] == s[3]` ("b" == "a") → false
* For `i = 3`, `s[3] == s[4]` ("a" == "d") → false

After this, the table remains unchanged for two-character substrings:

```
dp = [
  [true, false, false, false, false],
  [false, true, false, false, false],
  [false, false, true, false, false],
  [false, false, false, true, false],
  [false, false, false, false, true]
]
```

#### **Step 4: Check for longer substrings (length 3 and more)**

Now, we check for substrings of length 3 and greater:

* For length 3 (`s[i...i+2]`), check if `s[i] == s[i+2]` and if the inner substring is also a palindrome.

  * **i = 0**: `s[0] == s[2]` ("b" == "b") → Check if `dp[1][1]` (i.e., `"a"`) is a palindrome → **true**
  * So, `dp[0][2] = true` (substring `"bab"` is a palindrome).

  Now, update the table:

```
dp = [
  [true, false, true, false, false],
  [false, true, false, false, false],
  [false, false, true, false, false],
  [false, false, false, true, false],
  [false, false, false, false, true]
]
```

* For `i = 1` (checking substring `"aba"`), we get `dp[1][3] = true`:

```
dp = [
  [true, false, true, false, false],
  [false, true, false, true, false],
  [false, false, true, false, false],
  [false, false, false, true, false],
  [false, false, false, false, true]
]
```

#### **Step 5: Track the longest palindrome**

As we continue checking substrings, we update `maxLength` and `startIdx` whenever we find a palindrome longer than the previous one.

For example:

* After finding `"bab"` (at `dp[0][2]`), we update `maxLength = 3` and `startIdx = 0`.
* Later, if we find `"aba"` (at `dp[1][3]`), it will also have length 3, but since `"bab"` was found earlier, no update to `maxLength` is needed.

#### **Step 6: Final Result**

The longest palindrome found in this case is `"bab"` or `"aba"`, and we can easily extract it using the `startIdx` and `maxLength` values.

---

### **Visual Recap of DP Table for "babad"**:

1. **Initial DP Table**:

   ```
   [true, false, false, false, false]
   [false, true, false, false, false]
   [false, false, true, false, false]
   [false, false, false, true, false]
   [false, false, false, false, true]
   ```

2. **After checking 2-character substrings** (no change):

   ```
   [true, false, false, false, false]
   [false, true, false, false, false]
   [false, false, true, false, false]
   [false, false, false, true, false]
   [false, false, false, false, true]
   ```

3. **After checking 3-character substrings** (`"bab"`, `"aba"` found):

   ```
   [true, false, true, false, false]
   [false, true, false, true, false]
   [false, false, true, false, false]
   [false, false, false, true, false]
   [false, false, false, false, true]
   ```

4. **Final DP Table (completed)** and the longest palindrome `"bab"` or `"aba"`.
*/


/*
Plan of action:
1. **Shuruat Karna (Initialization)**:
   Ek table (`dp[n][n]`) banayein jahan `dp[i][j]` `true` hoga agar substring `s[i...j]` 
   palindrome hai. Sabhi single character substrings ko `true` set karein, kyunki woh 
   palindrome hote hain.

2. **DP Table Banana**:
   Sabhi possible substrings (lambai 2 aur zyada) ko check karein. Har substring `s[i...j]` 
   ke liye, agar `s[i]` aur `s[j]` same hain, toh check karein ki substring `s[i+1...j-1]` 
   bhi palindrome hai. Agar haan, toh `dp[i][j] = true` set karein.

3. **Sabse Lamba Palindrome Track Karna**:
   Jab bhi palindrome milta hai, toh check karein ki kya woh ab tak ka sabse lamba 
   palindrome hai. Agar hai, toh `maxLength` aur `startIdx` ko update karein.

4. **Result Return Karna**:
   Jab table puri ho jaye, tab sabse lambi palindrome substring `startIdx` se start hoti hai aur uski lambai `maxLength` hoti hai. Us substring ko return karein.
*/