class problem_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            // Get the values of the current nodes
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate the sum and carry
            int totalSum = val1 + val2 + carry;
            carry = totalSum / 10;
            int currentDigit = totalSum % 10;

            // Create a new node with the current digit
            current.next = new ListNode(currentDigit);
            current = current.next;

            // Move to the next nodes in the input lists if available
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummyHead.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }   
    public static void main(String[] args) {
        // Example usage
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        
        problem_2 solution = new problem_2();
        ListNode result = solution.addTwoNumbers(l1, l2);
        
        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}