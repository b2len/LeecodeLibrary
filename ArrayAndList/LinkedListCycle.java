/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next == null) { // if there's a null, it means reach the end of the list, therefore no cycle
                return false;
            }
            fast = fast.next.next; // fast pointer move two steps a time
            slow = slow.next; // slow pointer move one step a time
            if (fast == slow) { // If these tow pointer meet, then there's a cycle
                return true;
            }
        }

        return false;
    }

}

/**
 * fast and slow pointer solution
 * https://zxi.mytechroad.com/blog/?s=Linked+List+Cycle
 * 
 * // Author: Huahua
 * // Running time: 8 ms
 * class Solution {
 * public:
 * bool hasCycle(ListNode *head) {
 * auto slow = head;
 * auto fast = head;
 * while (fast) {
 * if (!fast->next) return false;
 * fast = fast->next->next;
 * slow = slow->next;
 * if (fast == slow) return true;
 * }
 * return false;
 * }
 * };
 * 
 * 
 * Brute force
 * if (head == null || head.next == null || pos < 0) {
 * return false;
 * }
 * 
 * int pos = 1;
 * ListNode curr = head;
 * ListNode posNode = head;
 * while (posNode.next != null) {
 * for (int i = pos; i >=0; i--){
 * if (head.next.next == curr) {
 * return true;
 * }
 * curr = curr.next;
 * }
 * curr = head;
 * pos += 1;
 * posNode = posNode.next;
 * }
 * return false;
 * }
 * 
 */