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
    Map<Integer, Integer> postorderIndexMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int length = preorder.length;
        for (int i = 0; i < postorder.length; i++) {
            postorderIndexMap.put(postorder[i], i);
        }
        return arrayToTree(0, length - 1, 0, length - 1, preorder, postorder);
    }

    private TreeNode arrayToTree(int preLeft, int preRight, int postLeft, int postRight, int[] preorder,
            int[] postorder) {
        if (preLeft > preRight || postLeft > postRight) {
            return null;
        }

        int rootvalue = preorder[preLeft];
        TreeNode root = new TreeNode(rootvalue);

        if (preLeft + 1 <= preRight) {
            // if root is preLeft, then the next element is its left branch in the preorder
            // array
            int index = postorderIndexMap.get(preorder[preLeft + 1]);
            // In the meantime, in the postorder array, from the left to the index
            // calculated above, is all the element of the left subtree
            int sum = index - postLeft;
            // now divide the subtree using their index carefully use recursion
            root.left = arrayToTree(preLeft + 1, preLeft + sum + 1, postLeft, postLeft + sum, preorder, postorder);
            root.right = arrayToTree(preLeft + sum + 2, preRight, postLeft + sum + 1, postRight, preorder, postorder);
        }
        return root;
    }
}