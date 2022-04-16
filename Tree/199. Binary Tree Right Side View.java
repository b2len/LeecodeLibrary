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
    public List<Integer> rightSideView(TreeNode root) {
        // reverse level traversal
        List<Integer> res = new ArrayList();
        Queue<TreeNode> q = new LinkedList();

        if (root == null)
            return res;
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                // use queue, the first one is the right node
                if (i == 0)
                    res.add(cur.val);
                // put the right node to be the first one in queue
                if (cur.right != null)
                    q.offer(cur.right);
                if (cur.left != null)
                    q.offer(cur.left);
            }
        }
        return res;
    }
}

/**
 * RECURSIVE SOLUTION
 * public class Solution {
 * public List<Integer> rightSideView(TreeNode root) {
 * List<Integer> result = new ArrayList<Integer>();
 * rightView(root, result, 0);
 * return result;
 * }
 * 
 * public void rightView(TreeNode curr, List<Integer> result, int currDepth){
 * if(curr == null){
 * return;
 * }
 * if(currDepth == result.size()){
 * result.add(curr.val);
 * }
 * 
 * rightView(curr.right, result, currDepth + 1);
 * rightView(curr.left, result, currDepth + 1);
 * 
 * }
 * }
 */