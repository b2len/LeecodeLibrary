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
 * Recursive Approach
 * public boolean isValidBST(TreeNode root) {
 * return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
 * }
 * 
 * public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
 * if (root == null) return true;
 * if (root.val >= maxVal || root.val <= minVal) return false;
 * return isValidBST(root.left, mainVal, root.val) && isValidBST(root.right,
 * root.val, maxVal);
 * }
 * 
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}