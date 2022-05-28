class Solution {
    int[] DIR = new int[] { 0, 1, 0, -1, 0 };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image; // same color -> no need to replace

        int m = image.length, n = image[0].length;
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sr, sc });

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            // check all four directions
            for (int i = 0; i < 4; i++) {
                int nr = r + DIR[i], nc = c + DIR[i + 1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || image[nr][nc] != oldColor)
                    continue;
                image[nr][nc] = newColor; // also mean we mark it visited
                q.offer(new int[] { nr, nc });
            }
        }
        return image;
    }
}

/**
 * DFS Method
 * 
 * int oldColor, m, n;
 * public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
 * m = image.length;
 * n = image[0].length;
 * oldColor = image[sr][sc];
 * if (oldColor != newColor)
 * DFS(image, sr, sc, newColor);
 * return image;
 * }
 * private void DFS(int[][] image, int r, int c, int newColor) {
 * // base case
 * if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != oldColor) return;
 * 
 * image[r][c] = newColor;
 * 
 * DFS(image, r + 1, c, newColor);
 * DFS(image, r - 1, c, newColor);
 * DFS(image, r, c + 1, newColor);
 * DFS(image, r, c - 1, newColor);
 * }
 * 
 * }
 */