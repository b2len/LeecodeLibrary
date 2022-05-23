class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: convert adjacent nodes into a list
        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses]; // track check how many indegrees for each course
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] req : prerequisites) {
            adj[req[1]].add(req[0]); // loop through all prereq pairs and put them into sepearte adj lists
            indegree[req[0]]++; // track the number of indegrees for each course
        }

        // Step2: put the nodes that have no prerequisits onto the Queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        // Step 3： Use BFS to do topological sorting
        int count = 0;
        while (!q.isEmpty()) {
            for (int c : adj[q.poll()]) {
                if (--indegree[c] == 0)
                    q.offer(c);
            }
            count++;
        }
        return count == numCourses;
    }

}