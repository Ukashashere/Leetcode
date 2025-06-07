class problem_2_ {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode curr = head;   /*Har ListNode jo ek object waali cheez hai wo ek node hai*/
    int carry = 0;          /*ListNode matlab linked list nhi*/

    while (l1 != null || l2 != null || carry > 0) {
      if (l1 != null) {
        carry += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        carry += l2.val;
        l2 = l2.next;
      }
      curr.next = new ListNode(carry % 10);
      carry /= 10;
      curr = curr.next;
    }

    return head.next;
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
    
        problem_2_ solution = new problem_2_();
        ListNode result = solution.addTwoNumbers(l1, l2);
    
        // Print the result
        while (result != null) {
        System.out.print(result.val + " ");
        result = result.next;
        }
    }
}