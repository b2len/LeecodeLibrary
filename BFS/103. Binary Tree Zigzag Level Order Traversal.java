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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;

        while (!q.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = q.poll();
                if (order) {
                    level.add(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            res.add(level);
            order = !order;
        }
        return res;
    }
}