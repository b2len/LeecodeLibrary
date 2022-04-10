/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * 
 * if (p == null && q == null) return true;
 * if (p == null || q == null) return false;
 * if (p.val == q.val)
 * return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
 * return false;
 */

// the Iterative approach can be reduced to one stack or queue
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);
        while (!stackP.isEmpty() || !stackQ.isEmpty()) {
            p = stackP.pop();
            q = stackQ.pop();
            if (p == null && q == null)
                continue;
            else if (p == null || q == null || p.val != q.val)
                return false;

            stackP.push(p.left);
            stackQ.push(q.left);
            stackP.push(p.right);
            stackQ.push(q.right);
        }
        return true;
    }
}
/**

    */