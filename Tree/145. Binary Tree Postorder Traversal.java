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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return postorder(root, res);
    }

    public List<Integer> postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
        return res;
    }
}

/**
 * Recursive Solution
 * 
 * public List<Integer> postorderTraversal(TreeNode root) {
 * List<Integer> res = new ArrayList<>();
 * if(root == null) return res;
 * Stack<TreeNode> stack = new Stack<>();
 * stack.push(root);
 * while(!stack.empty()){
 * root = stack.pop();
 * res.add(0, root.val);
 * if(root.left != null) stack.push(root.left);
 * if(root.right != null) stack.push(root.right);
 * }
 * return res;
 * }
 * 
 */