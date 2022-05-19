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
    public List<String> binaryTreePaths(TreeNode root) {
        // base case
        if (root == null)
            return null;

        List<String> result = new ArrayList<>();
        dfs(result, new StringBuilder(), root);
        return result;
    }

    private void dfs(List<String> result, StringBuilder temp, TreeNode root) {
        // instead of having two if statements for the recursion later, do the judgement
        // here
        if (root == null) {
            return;
        }

        int len = temp.length();
        temp.append(root.val);

        if (root.left == null && root.right == null) {
            result.add(temp.toString());
        } else {
            temp.append("->");
            dfs(result, temp, root.left);
            dfs(result, temp, root.right);
        }
        // Key learning here: use the length of string to backtrack!
        temp.setLength(len);
    }
}