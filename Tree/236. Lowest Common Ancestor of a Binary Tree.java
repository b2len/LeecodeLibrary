/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        // base case: if p(or q) is equal to the current search node, return the node(because it is the lowest node)
        // also, if we reach the bottom of the tree and didn't find a matching value, then node == null, and return the result null;
        // you can sepearate the null case as if (node == null) return null;
        if (node == null || node == p || node == q) return node;
        
        // try to find the node that equal to either p or q in the deeper part of tree via recursion
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        
        // If left subtree contains one of descendant (p or q) and right subtree contains the remaining descendant (q or p) then the root is their LCA.
        if (left != null && right != null) return node;
        // If left subtree contains both p and q then return left as their LCA.
        // If right subtree contains both p and q then return right as their LCA.
        return left != null ? left : right;
    }
}

/** ITERATIVE SOLUTION

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }

}
*/
