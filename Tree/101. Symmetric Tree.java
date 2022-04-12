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
 * 
 * Recursive Solution
 * public boolean isSymmetric(TreeNode root) {
 * if (root == null) return true;
 * return isMirror(root.left, root.right);
 * }
 * private boolean isMirror(TreeNode subLeft, TreeNode subRight) {
 * if (subLeft == null && subRight == null) return true;
 * if (subLeft == null || subRight == null) return false;
 * return (subLeft.val == subRight.val) && isMirror(subLeft.left,
 * subRight.right) && isMirror(subLeft.right, subRight.left);
 * }
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        // base case
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // how to handle null value
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            // probably can do it using Stack as well
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}