/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

        // create fast and slow pointer to move in different pace down the list, the
        // goal is to find the middle point
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // if the number of nodes are even number, then move the slow one more time
        if (fast != null)
            slow = slow.next;

        // reverse the slow Linked list
        slow = reverseList(slow);

        // Compare the slow (second half) to the head (first half)
        while (slow != null) {
            if (slow.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }

        return true;

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // made mistake initially to create the node using constructor ListNode(); this
                              // might create default value instead of null
        ListNode next = null;

        while (head != null) {
            next = head.next; // the next Node move to head's next Node
            head.next = prev; // the link to head's next Node now point to prev, link is now broken between
                              // the head and head's next node
            prev = head; // move the prev node to head node, now prev got head's value, and it's link is
                         // with head's next node
            head = next; // move head variable to point to the next node
        }

        return prev; // head and next are now pointing to null

    }
}