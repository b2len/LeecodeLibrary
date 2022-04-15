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
 */
class Solution {
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPath(root);
        return maxValue;
    }

    private int maxPath(TreeNode node) {
        if (node == null)
            return 0;
        // look at the left side of the subtree and compare it's sum with 0.
        // if it is negative, it's impossible to have the maximum value from that route,
        // return 0 instead
        int left = Math.max(0, maxPath(node.left));
        int right = Math.max(0, maxPath(node.right));
        // the largest possible value using node as the start point would be left +
        // right + node.val;
        // it need to compare with the current maxValue
        maxValue = Math.max(maxValue, left + right + node.val);
        // for recursive call, the return value is the node value plus whichever have
        // higher sum (either left side or right side)
        return Math.max(left, right) + node.val;
    }
}

/**
 * Approach WITHOUT global variable
 * 
 * public class Solution {
 * public int maxPathSum(TreeNode root) {
 * int[] max = new int[1]; // use an one element array to record the value
 * max[0] = Integer.MIN_VALUE;
 * maxPathSum(max, root);
 * return max[0];
 * }
 * private int maxPathSum(int[] max, TreeNode root){
 * if(root == null)
 * return 0;
 * int leftMax = Math.max(0, maxPathSum(max, root.left));
 * int rightMax = Math.max(0, maxPathSum(max, root.right));
 * max[0] = Math.max(max[0], root.val+leftMax+rightMax);
 * return root.val+Math.max(leftMax,rightMax);
 * }
 */
