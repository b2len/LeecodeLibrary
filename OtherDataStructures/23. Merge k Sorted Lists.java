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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        // put the first node of every list into the heap
        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
        }

        // Use a dummy head to carry the result
        // Use a curr node to point to the current node and move to the next
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!queue.isEmpty()) {
            curr.next = queue.poll(); // Min heap always poll out the smallest item
            curr = curr.next; // move the curr pointer to the next item
            // if the specific linkedlist is not exhausted, move its next item to the heap
            if (curr.next != null)
                queue.add(curr.next);
        }

        return dummy.next;

    }
}
