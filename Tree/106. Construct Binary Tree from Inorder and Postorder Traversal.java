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
    int postorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;

        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(postorder, 0, postorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        if (left > right)
            return null;

        // select the postorder element as the root and increment it
        int rootvalue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootvalue);
        // build left and right subtree, right first as postorder is left - right - root

        root.right = arrayToTree(postorder, inorderIndexMap.get(rootvalue) + 1, right);
        root.left = arrayToTree(postorder, left, inorderIndexMap.get(rootvalue) - 1);
        return root;
    }
}