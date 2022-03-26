class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] ans = new int[k][];

        // put the data into a heap, keep the index and use the distance as comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> distance(points[b]) - distance(points[a]));
        // Use the max heap, pop out the largest item when it exceed k elements
        for (int i = 0; i < n; i++) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // put the data from heap to an array
        for (int i = 0; i < k; i++) {
            ans[i] = points[pq.poll()];
        }
        return ans;
    }

    private int distance(int[] point) {
        return (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}