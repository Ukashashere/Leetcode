class problem_3 {
  public int lengthOfLongestSubstring(String s) {
    int ans = 0;
    int[] count = new int[128];
/*count ek array of integers hai jiske andar hum s String ke alphabets bhar rhe hain */ /*maine apni desi knowledge se kiya hai,yaha bass sliding winfow use ho raha hai, kuch difficult nahi hai, zyada aage ka padhne ki zarurat nhi hai */
    for (int l = 0, r = 0; r < s.length(); ++r) {
      ++count[s.charAt(r)];    /*We increment the count for the character at index r */
      /*We use a while loop to ensure that the substring from l to r contains all unique characters */
      while (count[s.charAt(r)] > 1)   /*If the character at r has already appeared (i.e. count > 1), it's a duplicate */
        --count[s.charAt(l++)];   /*We increment l to shrink the window from the left until the character at r is unique again */ /*l doesn't necessarily change in every iteration — it only changes when a duplicate character is found in the current window. */
      /*We increment count for the character at r, and if it becomes greater than 1, we enter the while loop to adjust l */
      ans = Math.max(ans, r - l + 1);
    }

    return ans;
  }
  public static void main(String[] args) {
    // Example usage
    problem_3 solution = new problem_3();
    String input = "abcabcbb";
    int result = solution.lengthOfLongestSubstring(input);
    
    // Print the result
    System.out.println(result);
  }
}