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
 * DFS from the root down to it's descendants:
 * We need to keep current path (which stores elements in the path) so far.
 * We need to keep the remain targetSum so far (after minus value of elements in
 * the path).
 * If we already reach into leaf node
 * Check if targetSum == 0 then we found a valid path from root to leaf node
 * which sum equal to targetSum, so add current path to the answer.
 * Else dfs on left node and on the right node.
 * 
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<Integer>(), paths);

        return paths;
    }

    public void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> paths) {
        if (root == null)
            return;

        current.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            // keep the same list and backtrack when a solution is not correct instead of
            // creating a new list at every iteration.
            paths.add(new ArrayList<>(current)); // make a copy of the list called 'current', and add it to the List
                                                 // called paths
            // paths.add(current);
            // return;
        }
        findPaths(root.left, sum - root.val, current, paths);
        findPaths(root.right, sum - root.val, current, paths);
        current.remove(current.size() - 1); // if we hit null recurse back up through stack and remove elements in
                                            // current list

        // findPaths(root.left, sum - root.val, new ArrayList<Integer>(current), paths);
        // findPaths(root.right, sum - root.val, new ArrayList<Integer>(current),
        // paths);
    }
}