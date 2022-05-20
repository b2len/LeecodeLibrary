/**
 * Definition of ParentTreeNode:
 * class ParentTreeNode {
 * public int val;
 * public ParentTreeNode parent, left, right;
 * }
 */

public class Solution {
    /**
     * @param root:   the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     *          we will sort your return value in output
     */
    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        if (root == null) {
            return results;
        }
        traverse(root, target);
        return results;
    }

    // treated the Tree as a Graph and traverse all nodes
    public void traverse(ParentTreeNode root, int target) {
        if (root == null)
            return;
        List<ParentTreeNode> path = new LinkedList<>();
        // dfs on current nodes
        dfs(root, path, target, 0);
        // do the same for left and right
        traverse(root.left, target);
        traverse(root.right, target);
    }

    private void dfs(ParentTreeNode root, List<ParentTreeNode> path, int target, int curr) {
        // Base case
        if (root == null)
            return;
        // Update value
        curr += root.val;
        path.add(root);
        // sum check
        if (curr == target) {
            // results.add(new ArrayList(path));
            List<Integer> copy = new ArrayList<>();
            for (ParentTreeNode node : path) {
                copy.add(node.val);
            }
            results.add(copy);
        }
        // need to make sure we don't go into loops...
        // not memory-efficient, but does the job.
        Set<ParentTreeNode> visited = new HashSet<>(path);
        if (!visited.contains(root.left)) {
            dfs(root.left, path, target, curr);
        }
        if (!visited.contains(root.right)) {
            dfs(root.right, path, target, curr);
        }
        if (!visited.contains(root.parent)) {
            dfs(root.parent, path, target, curr);
        }
        curr -= root.val;
        path.remove(path.size() - 1);
    }
}