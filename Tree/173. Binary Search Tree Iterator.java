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
 * for Binary Search Tree, once you get to a TreeNode, in order to get the
 * smallest, you need to go all the way down its left branch. So our first step
 * is to point to pointer to the left most TreeNode.
 * The problem is how to do back trace. Since the TreeNode doesn't have father
 * pointer, we cannot get a TreeNode's father node in O(1) without store it
 * beforehand.
 * Back to the first step, when we are traversal to the left most TreeNode, we
 * store each TreeNode we met ( They are all father nodes for back trace).
 * After returning the smallest TreeNode, I need to point the pointer to the
 * next smallest TreeNode. When the current TreeNode has a right branch (It
 * cannot have left
 * branch, remember we traversal to the left most).
 * We need to jump to its right child first and then traversal to its right
 * child's left most TreeNode.
 * When the current TreeNode doesn't have a right branch, it means there cannot
 * be a node with value smaller than itself father node, point the pointer at
 * its father node.
 */
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        fillStack(root);
    }

    public int next() {
        TreeNode curr = stack.pop();
        fillStack(curr.right);
        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void fillStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */