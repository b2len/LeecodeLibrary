class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start) {
        // base case
        if (remain < 0)
            return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < candidates.length; i++) {
                // Skip the occurances all repetitive numbers in-between,
                // Note we will pick the number at the current curr position into the
                // combination, regardless the other conditions.
                // This is important, since the iteration should allow us to select multiple
                // instances of a unique number into the combination.
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;
                tempList.add(candidates[i]);
                dfs(list, tempList, candidates, remain - candidates[i], i + 1); // no duplicates so i + 1, move the
                                                                                // cursor to next item
                // when the tempList backtrack to here, remove the last item and go on to the
                // next option
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}