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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
        return -1;

    }
}

/**
 * public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
 * if (root == null) return arr;
 * inorder(root.left, arr);
 * arr.add(root.val);
 * inorder(root.rightm arr);
 * }
 * 
 * public int kthSmallest(TreeNode root, int k) {
 * ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
 * return nums.get(k - 1);
 * }
 */