class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0)
            return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1')
                    DFSMarking(grid, i, j);
                ++count;
            }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        // base case - Check for invalid indices and for sites that are't land
        // if all surrounding by water or connected land (see code below), then return
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
            return;

        // mark the site as visited, it is like assume it's now like water
        grid[i][j] = '0';

        // check all adjuacent sites
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i + 1, j + 1);
        DFSMarking(grid, i + 1, j - 1);
    }
}