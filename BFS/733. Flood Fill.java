class Solution {
    int target, m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        target = image[sr][sc];
        if (target != newColor)
            BFS(image, sr, sc, newColor);
        return image;
    }

    private void BFS(int[][] image, int r, int c, int newColor) {
        // base case
        if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != target)
            return;

        image[r][c] = newColor;

        BFS(image, r + 1, c, newColor);
        BFS(image, r - 1, c, newColor);
        BFS(image, r, c + 1, newColor);
        BFS(image, r, c - 1, newColor);
    }
}