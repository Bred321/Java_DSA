package Practices.Stacks;
import java.util.Stack;



public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
    Stack<Integer> stack = new Stack<Integer>();
    ListNode slow = head;
    ListNode fast = head;

    // Push first half of values onto stack
    while(fast != null && fast.next != null){
        stack.push(slow.val);
        slow = slow.next;
        fast = fast.next.next;
    }

    // Skip the middle element for odd-length lists
    if(fast != null){
        slow = slow.next;
    }

    // Compare second half with values from stack
    while(slow != null){
        if (stack.isEmpty() | slow.val != stack.pop()) {
            return false;
        }
        slow = slow.next;
    }

    return stack.isEmpty();
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }