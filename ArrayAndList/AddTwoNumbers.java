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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(); // initialize a new Node to be the dummy head of the returning list
        ListNode curr = dummyHead; // Created a curr runner to run through the element in the loop
        int sum = 0; // a sum variable to keep track of the math
        while (l1 != null || l2 != null || sum > 0) { // pay attention to the third condition, it takes care of the
                                                      // special case of the two lists running out but need to carry one
                                                      // to another digit
            int l1Val = (l1 == null ? 0 : l1.val); // Assign the value 0 if running out of digit
            int l2Val = (l2 == null ? 0 : l2.val);
            sum += l1Val + l2Val; // PAY ATTENTION, don't forget to add the carry
            curr.next = new ListNode(sum % 10); // the remaining of sum is the value of the next Node
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next; // move to next only if there's more item, otherwise stay put
            if (l2 != null)
                l2 = l2.next; //
            sum /= 10; // sum must be either 0 or 1
                       // because the largest possible sum of two digits (including the carry) is 9 + 1
                       // + 1 = 19

        }
        return dummyHead.next;
    }
}