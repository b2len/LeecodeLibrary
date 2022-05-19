/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */

public class Solution {
    /**
     * @param root:   the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     *          we will sort your return value in output
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, target, new ArrayList<Integer>(), paths, false);
        return paths;
    }

    public void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> paths, boolean rootflag) {
        // Base case
        if (root == null)
            return;
        // ************ Recursive case***********//
        // 1. Update current information
        current.add(root.val);
        // 2. Once find a valid path then add it to the result list
        if (root.val == sum) {
            paths.add(new ArrayList<>(current));
        }
        // 3. Checking left and right paths starting from root
        findPaths(root.left, sum - root.val, current, paths, true);
        findPaths(root.right, sum - root.val, current, paths, true);
        // 4. Checking paths starting from left or right nodes
        if (!rootflag) {
            findPaths(root.left, sum, new ArrayList<>(), paths, false);
            findPaths(root.right, sum, new ArrayList<>(), paths, false);
        }
        // 5. Remove the current node in the path tor backtrack
        current.remove(current.size() - 1);
    }
}