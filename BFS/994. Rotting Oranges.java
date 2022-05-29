
class Solution {
    int[][] DIR = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[] { i, j });
                else if (grid[i][j] == 1)
                    freshCount++;
            }
        }
        if (freshCount == 0)
            return 0;
        int time = 0;
        while (!q.isEmpty() && freshCount != 0) {
            time++;
            int size = q.size();
            // need to implement a for loop inside of while loop as we need to count the
            // number of iterations
            // each iteration takes a minute. Without it, the time count will be different
            // (higher)
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                for (int dir[] : DIR) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 0 || grid[nr][nc] == 2)
                        continue;
                    grid[nr][nc] = 2;
                    q.offer(new int[] { nr, nc });
                    freshCount--;
                }
            }
        }
        return freshCount == 0 ? time : -1;
    }
}