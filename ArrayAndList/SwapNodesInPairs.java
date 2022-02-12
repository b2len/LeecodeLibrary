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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { // take care of the edge case of zero or one item
            return head;
        }

        ListNode dummy = new ListNode(0); // create a dummy head for the new list
        dummy.next = head; // link it to the first item of given list
        head = dummy;

        while (head.next != null && head.next.next != null) {
            ListNode firstNode = head.next; // the first Node is after the dummy Node
            ListNode secondNode = head.next.next;
            firstNode.next = secondNode.next; // Link the original first node with the original thrid node
            secondNode.next = firstNode; // The original second node now point to the original first node
            head.next = secondNode; // pointing the head or current node to the original second node
            head = firstNode; // now move the head or current node to the new first node location

        }

        return dummy.next;
    }
}