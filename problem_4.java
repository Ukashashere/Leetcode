class problem_4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) { /*double store more digits after the decimal point */
    final int n1 = nums1.length;     /*final keyword means the variable cannot be reassigned after it's initialized */
    final int n2 = nums2.length;
    if (n1 > n2)
      return findMedianSortedArrays(nums2, nums1);

    int l = 0;   /*I just want to solve it by anither approach, I didn't understand it very well */
    int r = n1;

    while (l <= r) {
      final int partition1 = (l + r) / 2;         /*half */
      final int partition2 = (n1 + n2 + 1) / 2 - partition1;  /*half ka half */
      final int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];  /*If else statement shortened form, if partition1 == 0 is true then Integer.MIN_VALUE is true value, if false then nums1[partition1 - 1] is value */
      final int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];  /*partition 2 ka left */
      final int minRight1 = partition1 == n1 ? Integer.MAX_VALUE : nums1[partition1];    /*partition 1 ka right */
      final int minRight2 = partition2 == n2 ? Integer.MAX_VALUE : nums2[partition2];  /*partition 2 ka right */
      if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1)
        return (n1 + n2) % 2 == 0  /*if it is even */
            ? (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) * 0.5
            : Math.max(maxLeft1, maxLeft2);
      else if (maxLeft1 > minRight2)
        r = partition1 - 1;
      else
        l = partition1 + 1;
    }

    throw new IllegalArgumentException();
  }
  public static void main(String[] args) {
    // Example usage
    problem_4 solution = new problem_4();
    int[] nums1 = {1, 3};
    int[] nums2 = {2};
    
    double result = solution.findMedianSortedArrays(nums1, nums2);
    
    // Print the result
    System.out.println(result); // Output: 2.0
  }                  /*here even 2.0 is accepted even with gibe requirement as 2.00000 */
}


/*
🧠 Detailed Explanation
java
Copy
Edit
final int n1 = nums1.length;
final int n2 = nums2.length;
if (n1 > n2)
  return findMedianSortedArrays(nums2, nums1);
Ensure binary search is done on the smaller array for efficiency.

If nums1 is larger, switch the arrays.

Binary Search Setup
java
Copy
Edit
int l = 0;
int r = n1;
We’ll binary search on nums1 between index 0 and n1.

🔄 While Loop - Binary Search
java
Copy
Edit
while (l <= r) {
  final int partition1 = (l + r) / 2;
  final int partition2 = (n1 + n2 + 1) / 2 - partition1;
We're trying to find a partition in both arrays so that:

The left part contains half of the total elements.

The +1 ensures correctness when the total number of elements is odd.

🧱 Boundary Handling
java
Copy
Edit
final int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
final int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
final int minRight1 = partition1 == n1 ? Integer.MAX_VALUE : nums1[partition1];
final int minRight2 = partition2 == n2 ? Integer.MAX_VALUE : nums2[partition2];
These variables capture the extreme values around the partition.

Use Integer.MIN_VALUE and Integer.MAX_VALUE to avoid index out-of-bounds and simplify comparison at array edges.

✅ Check for Correct Partition
java
Copy
Edit
if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1)
If true, you've found the correct partition.

Now calculate the median:

If total length is even: average of max of left and min of right

If odd: max of left (because left part has one extra)

java
Copy
Edit
return (n1 + n2) % 2 == 0
    ? (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) * 0.5
    : Math.max(maxLeft1, maxLeft2);
🔁 Adjust Search Range
If the partition is not correct:

java
Copy
Edit
else if (maxLeft1 > minRight2)
  r = partition1 - 1;
else
  l = partition1 + 1;
If maxLeft1 > minRight2, move left (reduce partition1)

Else, move right

❌ Edge Case
java
Copy
Edit
throw new IllegalArgumentException();
This should never be hit if input arrays are valid and sorted.

✅ Time and Space Complexity
Time: O(log(min(n1, n2)))

Space: O(1)

🔚 Conclusion
This is an efficient and elegant solution using binary search to solve a problem that would take O(n) if done with merging. This method is from a classic LeetCode Hard problem: Median of Two Sorted Arrays.

Let me know if you want a step-by-step trace with an example!

*/