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

/**
 * If we define a 1 as a node, two nodes are connected if they are adjacent,
 * adjacent 1s surrounded by 0s will be regarded as a connected component.
 * 
 * The problem becomes to find all connected components, which can we solved by
 * Union Find.
 * 
 * The initial number of connected component should equal to the number of 1s.
 * Then for each 1, we union it around. Each time we hit a union succesfully,
 * the number of connected component will decrease by 1.
 * 
 * private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
 * private UF uf;
 * private int rows, cols, countIslands;
 * 
 * public int numIslands(char[][] grid) {
 * if (grid.length == 0) return 0;
 * 
 * rows = grid.length;
 * cols = grid[0].length;
 * uf = new UF(rows * cols);
 * 
 * countIslands = 0;
 * 
 * for (int x = 0; x < rows; x++) {
 * for (int y = 0; y < cols; y++) {
 * // If value 1, union with adjacent
 * if (grid[x][y] == '1') {
 * countIslands++;
 * unionAround(x, y, grid);
 * }
 * }
 * }
 * 
 * return countIslands;
 * }
 * 
 * private void unionAround(int x, int y, char[][] grid) {
 * int mark = x * cols + y;
 * for (int[] dir : directions) {
 * int nx = x + dir[0];
 * int ny = y + dir[1];
 * if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == '1') {
 * if (uf.union(nx * cols + ny, mark)) {
 * countIslands--;
 * }
 * }
 * }
 * }
 * 
 * class UF {
 * int[] parent;
 * 
 * public UF(int n) {
 * parent = new int[n];
 * for (int i = 0; i < n; i++) {
 * parent[i] = i;
 * }
 * }
 * 
 * private int find(int x) {
 * if (parent[x] == x) {
 * return x;
 * }
 * return parent[x] = find(parent[x]); // Path compression
 * }
 * 
 * // Return false if x and y are in the same disjoint set already
 * public boolean union(int x, int y) {
 * int rootX = find(x);
 * int rootY = find(y);
 * if (rootX == rootY) {
 * return false;
 * }
 * parent[rootX] = rootY;
 * return true;
 * }
 * }
 */