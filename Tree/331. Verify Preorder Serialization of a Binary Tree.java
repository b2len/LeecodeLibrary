/**
 * INTUITION
 * all none null node provides 2 outdegree and 1 indegree, except root
 * all null node provides 0 outdegree and 1 indegree
 * recored the difference between out degree and in degree diff = outdegree -
 * indegree.
 * when the next node comes, we then degress diff by 1 as the node provides an
 * in degree
 * if the node is not null, increase diff by 2, as it provides two out degree
 * if a serialization is correct, diff should never be negative and diff will be
 * zero we finished
 * An alternative thinking is aout node and edges:
 * 1. For a full binary tree, # of node = # of edges + 1, thus if we manually
 * add an edge to the root, then the # of edges = the # of nodes;
 * 2. For a node, it consumes one edge and produces 2 new edges(if not null)
 */
class Solution {

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0)
                return false;
            if (!node.equals("#"))
                diff += 2;
        }
        return diff == 0;
    }
}

/**
 * Stack thinking solution
 * when you iterate through the preorder traversal string, for each char:
 * case 1: you see a number c, means you begin to expand a new tree rooted with
 * c, you push it to stack
 * case 2.1: you see a #, while top of stack is a number, you know this # is a
 * left null child, put it there as a mark for next coming node k to know it is
 * being the right child.
 * case 2.2: you see a #, while top of stack is #, you know you meet this # as
 * right null child, you now cancel the sub tree (rooted as t, for example) with
 * these two-# children. But wait, after the cancellation, you continue to check
 * top of stack is whether # or a number:
 * ---- if a number, say u, you know you just cancelled a node t which is left
 * child of u. You need to leave a # mark to the top of stack. So that the next
 * node know it is a right child.
 * ---- if a #, you know you just cancelled a tree whose root, t, is the right
 * child of u. So you continue to cancel sub tree of u, and the process goes on
 * and on.
 * Since we never care about what's in the stack, I simplify it to a integer.
 * 
 * public boolean isValidSerialization(String preorder) {
 * String[] strs = preorder.split(",");
 * int stack = 0, i = 0;
 * for (; i < strs.length; i++) {
 * if ("#".equals(strs[i])) {
 * if (stack == 0) {
 * break;
 * }
 * stack--;
 * } else {
 * stack++;
 * }
 * }
 * return stack == 0 && i == strs.length - 1 && "#".equals(strs[i]);
 * }
 * 
 */