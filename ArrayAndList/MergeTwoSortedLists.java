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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Define a new Node
        ListNode head = new ListNode();
        ListNode temp = head;

        // If any of the list has no element then return the other list, since both of
        // them are sorted
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        // Use Merge sort logic to merge nodes value
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // If any node left in list1
        if (list1 != null) {
            temp.next = list1;
        }
        // If any node left in list2
        if (list2 != null) {
            temp.next = list2;
        }
        return head.next;
    }

}