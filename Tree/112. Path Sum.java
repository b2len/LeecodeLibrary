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

// The basic idea is to subtract the value of current node from sum until it
// reaches a leaf node and the subtraction equals 0,
// then we know that we got a hit. Otherwise the subtraction at the end could
// not be 0.

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

/**
 * ITERATIVE SOLUTION
 * if (root == null) return false;
 * Stack<TreeNode> nodeStack = new Stack<>();
 * Stack<Integer> sumStack = new Stack<>();
 * nodeStack.push(root);
 * sumStack.push(targetSum);
 * 
 * while (!nodeStack.isEmpty()) {
 * TreeNode cur = nodeStack.pop();
 * int rem = sumStack.pop();
 * if (cur.val == rem && cur.left == null && cur.right == null) return true;
 * if (cur.left !=null) {
 * nodeStack.push(cur.left);
 * sumStack.push(rem - cur.val);
 * }
 * if (cur.right != null) {
 * nodeStack.push(cur.right);
 * sumStack.push(rem - cur.val);
 * }
 * }
 * return false;
 * 
 */