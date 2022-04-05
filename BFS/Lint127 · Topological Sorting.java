/**
 * 按照标准的BFS模版写的，把三个步骤分成了三个函数：

    Calulate in degree
    (0 in degree) node to in queue
    Uses BFS to abtain the results
    需要构建的辅助数据结构：
    //哈希用来储存每个节点的入度
    private HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
    //Queue用来储存0入度节点
    private Queue queue = new LinkedList();
    //result用来返回最终结果
    private ArrayList result = new ArrayList();
 * 
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    private HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
    private Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
    private ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        getInDegree(graph);
        putIntoQueue(graph);
        searchAndPush(queue);
        return result;
    }
    
    private void getInDegree(ArrayList<DirectedGraphNode> graph) {
        // Calculate in-degree of every node and put it in a hashmap.
        for (DirectedGraphNode vertex : graph) {
            for (DirectedGraphNode neighbor : vertex.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
    }
    
    private void putIntoQueue(ArrayList<DirectedGraphNode> graph) {
        // Find out nodes that has 0 in-degree
        for (DirectedGraphNode vertex : graph) {
            if (map.containsKey(vertex)) continue;
            queue.offer(vertex);
            result.add(vertex);
        }
    }
    
    private void searchAndPush(Queue<DirectedGraphNode> q) {
        // search for nodes with 0 in-degree and keep push into the Queue
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i != size; ++i) {
                DirectedGraphNode vertex = queue.poll();
                for (DirectedGraphNode neighbor : vertex.neighbors) {
                    map.put(neighbor, map.get(neighbor) - 1);
                    if (map.get(neighbor) == 0) {
                        queue.offer(neighbor);
                        result.add(neighbor);
                    }
                }
            }
        }
    }
}