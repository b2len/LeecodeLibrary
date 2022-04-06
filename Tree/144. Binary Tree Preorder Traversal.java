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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return preorder(root, res);
    }

    public List<Integer> preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
        return res;
    }
}

/**
 * Iterative version:
 * List<Integer> res = new ArrayList<>();
 * Stack<TreeNode> stack = new Stack<>();
 * TreeNode curr = root;
 * while (curr !=null || !stack.isEmpty()) {
 * while (curr != null) {
 * res.add(curr.val);
 * stack.push(curr);
 * curr = curr.left;
 * }
 * curr = stack.pop();
 * curr = curr.right;
 * }
 * return result;
 */