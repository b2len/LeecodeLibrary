// Same idea with Topological sorting, process zero cell first
// then use queue structure to keep the order of processing cells, so that cells with smaller distace will be processed first
// Then expand the unprocessed neighbors of the current processing cell and push into the queue

class Solution {
    int[] DIR = new int[] { 0, 1, 0, -1, 0 };

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0)
                    q.offer(new int[] { r, c });
                else
                    mat[r][c] = -1; // Marked as not processed yet
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nr = r + DIR[i], nc = c + DIR[i + 1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1)
                    continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.offer(new int[] { nr, nc }); // put processed node onto queue
            }
        }
        return mat;
    }
}