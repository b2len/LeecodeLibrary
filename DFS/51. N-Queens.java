class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<String>(), 0, new boolean[n], new boolean[2 * n], new boolean[2 * n], n);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> board, int row, boolean[] cols, boolean[] d1, boolean[] d2,
            int n) {
        if (row == n)
            result.add(new ArrayList<String>(board));

        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (!cols[col] && !d1[id1] && !d2[id2]) {
                char[] r = new char[n];
                Arrays.fill(r, '.');
                r[col] = 'Q';
                board.add(new String(r));
                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                dfs(result, board, row + 1, cols, d1, d2, n);

                // back tracking
                board.remove(board.size() - 1);
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }
}

/**
 * Classic solution using HashSet, slower than boolean flag
 * 
 * public class Solution {
 * private Set<Integer> col = new HashSet<Integer>();
 * private Set<Integer> diag1 = new HashSet<Integer>();
 * private Set<Integer> diag2 = new HashSet<Integer>();
 * 
 * public List<List<String>> solveNQueens(int n) {
 * List<List<String>> res = new ArrayList<List<String>>();
 * dfs(res,new ArrayList<String>(), 0, n);
 * return res;
 * }
 * private void dfs(List<List<String>> res, List<String> list, int row, int n){
 * if (row == n){
 * res.add(new ArrayList<String>(list));
 * return;
 * }
 * for (int i = 0; i < n; i++){
 * if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i))
 * continue;
 * 
 * char[] charArray = new char[n];
 * Arrays.fill(charArray, '.');
 * charArray[i] = 'Q';
 * String rowString = new String(charArray);
 * 
 * list.add(rowString);
 * col.add(i);
 * diag1.add(row + i);
 * diag2.add(row - i);
 * 
 * dfs(res, list, row + 1, n);
 * 
 * list.remove(list.size() - 1);
 * col.remove(i);
 * diag1.remove(row + i);
 * diag2.remove(row - i);
 * }
 * }
 * }
 * 
 */