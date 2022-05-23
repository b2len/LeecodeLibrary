/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 * int label;
 * List<DirectedGraphNode> neighbors;
 * DirectedGraphNode(int x) {
 * label = x;
 * neighbors = new ArrayList<DirectedGraphNode>();
 * }
 * }
 */

public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // Step 1: put each node's number of directed neighbors into a Map
        HashMap<DirectedGraphNode, Integer> nodeInfo = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode g : graph) {
            for (DirectedGraphNode ng : g.neighbors) {
                if (nodeInfo.getOrDefault(ng, 0) == 0)
                    nodeInfo.put(ng, 0);
                nodeInfo.compute(ng, (key, value) -> value + 1);
            }
        }
        // Step 2: put the nodes that have no incoming neighbors onto the Queue
        Queue<DirectedGraphNode> zeroQueue = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode g : graph) {
            if (nodeInfo.getOrDefault(g, 0) == 0) {
                zeroQueue.offer(g);
            }
        }
        // Step 3: Use BFS to do topological sorting
        ArrayList<DirectedGraphNode> r = new ArrayList<DirectedGraphNode>();
        while (!zeroQueue.isEmpty()) {
            DirectedGraphNode tg = zeroQueue.poll();
            r.add(tg);
            // once add one node that have zero incoming node to the answer, reduce all its
            // neighbors; edge by one
            for (DirectedGraphNode g : tg.neighbors) {
                nodeInfo.compute(g, (key, value) -> value - 1);
                if (nodeInfo.get(g) == 0)
                    zeroQueue.offer(g);
            }
        }
        return r;
    }
}