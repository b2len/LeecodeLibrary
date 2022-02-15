/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * Best solution
 * Use a very clever trick that if the two lists have an intersection, they will
 * have the save nodes from that point
 * As least, the last node will be the same. Therefore, you can "chop off" or
 * ignore the extra nodes in the longer list
 * By switch the head once the list reach the end of its node, you got the short
 * one switch to the long one,
 * and the long one switch to the shrot one. Then the two pointers are in the
 * same distance to the intersection node
 * move the pointer now forward will ganrantee that the two pointer reach the
 * intersection at the same time
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        // Note even the two lists have no intersection, they will point to the end of
        // the list (null value) at the same time
        // Thus satisfy the condition that nodeA == nodeB.
        while (nodeA != nodeB) {
            nodeA = (nodeA != null) ? nodeA.next : headB;
            nodeB = (nodeB != null) ? nodeB.next : headA;
        }

        return nodeA;

    }

}

/**
 * Very lengthy solution:
 * 1. Run through each linkedlist to get the lengths and the tails
 * 2. Compare the tail, if they are different, return immediately
 * 3. Set two pointerss to the start of each linkedlist
 * 4. On the longer linkedlist, advance its pointer by the difference in lengths
 * 5. Now, traverse on each linked list until the pointers are the same
 */
