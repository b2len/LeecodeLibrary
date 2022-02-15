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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // Create two heads and two pointer to track the head position and be the
        // runners to go through the LinkedList
        ListNode dummyS = new ListNode(x);
        ListNode dummyL = new ListNode(x);
        ListNode small = dummyS;
        ListNode large = dummyL;

        while (head != null) {
            if (x <= head.val) {
                large.next = head;
                large = large.next;
            } else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }

        // WATCH: Last node of "after" list would also be ending node of the reformed
        // list. It should point to null. Otherwise it will have a CYCLE!
        large.next = null;
        // WATCH: the second node of dummyL is the atucal first node of the given list
        small.next = dummyL.next;

        return dummyS.next;

    }

}