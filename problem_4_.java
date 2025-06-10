class problem_4_ {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int first = 0, second = 0;
        int[] merge = new int[len1 + len2];
        int count = 0;
        while(first < len1 || second < len2){   /*or condition 1 needs to be true */
            if(first < len1 && second < len2)
                merge[count++] = nums1[first] <= nums2[second] ? nums1[first++]: nums2[second++];
            else if(first < len1)
                merge[count++] = nums1[first++];
            else
                merge[count++] = nums2[second++];
        }
        return (len1 + len2) % 2 != 0 ?        /*merge = [1, 3, 8, 9, 15] .If the total length is odd, say 5, the middle element is merge[5 / 2], which is merge[2] = 8. The median is simply 8.0. If the total length is even, say 6, the middle elements are merge[6 / 2] = merge[3] and merge[6 / 2 - 1] = merge[2], i.e., 9 and 8. The average is (9 + 8) / 2 = 8.5.  */
            (double)merge[(len1 + len2) / 2] :
        ((double)merge[(len1 + len2) / 2] + (double)merge[(len1 + len2) / 2 - 1]) / 2;
    }
    public static void main(String[] args) {
        // Example usage
        problem_4_ solution = new problem_4_();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        
        double result = solution.findMedianSortedArrays(nums1, nums2);
        
        // Print the result
        System.out.println(result); // Output: 2.0
    }
}