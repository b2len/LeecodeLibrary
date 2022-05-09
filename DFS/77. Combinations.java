class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), 1, n, k);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> tempList, int start, int n, int k) {
        // if certain condition is met, add the result to collection
        if (k == 0) {
            list.add(new ArrayList<Integer>(tempList));
            return;
        }
        // else loop through the input until you got the answer
        // Note the loop ending condition 'n-k+1'
        // since we are looking for combination that is k length, so the last possible
        // combination will end at n - k + 1
        // beyond that, all combination will be shorter than k, therefore no need to
        // loop till last item (i.e. i <= n)
        for (int i = start; i <= n - k + 1; i++) {
            tempList.add(i);
            // go down a level using recursion
            dfs(list, tempList, i + 1, n, k - 1);
            // classic backtracking technique
            tempList.remove(tempList.size() - 1);
        }
    }
}