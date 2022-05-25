class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: put the given nodes into a ajacent list
        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] preq : prerequisites) {
            adj[preq[1]].add(preq[0]);
            indegree[preq[0]]++;
        }

        // Step 2: put the nodes with no incoming edge onto a queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        // Step 3: iterate through the q list and update its q with nodes that have no
        // indegree edges
        int i = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            int course = q.poll();
            order[i++] = course;
            for (int c : adj[course]) {
                if (--indegree[c] == 0)
                    q.offer(c);
            }
        }
        return (i == numCourses) ? order : new int[0];
    }
}