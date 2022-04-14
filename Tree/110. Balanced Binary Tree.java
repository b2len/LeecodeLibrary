/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;     
    }
    // Since the height of a tree is always greater than or equal to 0
    // Use -1 as flag to indicate if the subtree is not balanced
    // Use DFS (postorder) to scan the tree to avoid checking the height multiple times
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        // left, right subtree is unbalanced or cur tree is unbalanced
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        
        return Math.max(left, right) + 1;
    }
}