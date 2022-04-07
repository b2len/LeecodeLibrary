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
 * 
 * 
 * INTUITION
 * Preorder traversal follows Root -> Left -> Right, therefore, given the
 * preorder array preorder, we have easy access to the root which is
 * preorder[0].
 * Inorder traversal follows Left -> Root -> Right, therefore if we know the
 * position of Root, we can recursively split the entire array into two
 * subtrees.
 */

class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // recursion base case, if there are no elements to construct the tree
        if (left > right)
            return null;

        // select the preorder_index element as the root and increment it
        int rootvalue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootvalue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootvalue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootvalue) + 1, right);
        return root;
    }
}