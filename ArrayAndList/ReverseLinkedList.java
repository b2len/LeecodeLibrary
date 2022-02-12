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
class Solution { // In addtion to solve iteratively, there's also a soluton to do it recursively
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            head.next = secondNode.next;
            secondNode.next = dummy.next;
            dummy.next = secondNode;

        }

        return dummy.next;

    }
}

/**
 * 
 * // Author: Huahua
 * // Running time: 0 ms
 * class Solution {
 * public ListNode reverseList(ListNode head) {
 * ListNode prev = null;
 * ListNode curr = head;
 * ListNode next;
 * while (curr != null) {
 * next = curr.next;
 * curr.next = prev;
 * prev = curr;
 * curr = next;
 * }
 * return prev;
 * }
 * }
 */