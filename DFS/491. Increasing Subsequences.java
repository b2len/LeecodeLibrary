class Solution {
    Set<List<Integer>> result;

    public List<List<Integer>> findSubsequences(int[] nums) {
        // base case
        if (nums.length <= 1 || nums == null)
            return new ArrayList<>();
        result = new HashSet<>();
        dfs(new ArrayList<>(), 0, nums);
        return new ArrayList(result);
    }

    private void dfs(List<Integer> tempList, int start, int[] nums) {
        if (tempList.size() > 1)
            result.add(new ArrayList(tempList));
        for (int i = start; i < nums.length; i++) {
            if (tempList.size() == 0 || tempList.get(tempList.size() - 1) <= nums[i]) {
                tempList.add(nums[i]);
                dfs(tempList, i + 1, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

/**
 * Using local variable runs slower
 * 
 * public List<List<Integer>> findSubsequences(int[] nums) {
 * // base case
 * if (nums.length <= 1 || nums == null) return new ArrayList<>();
 * Set<List<Integer>> result = new HashSet<>();
 * dfs (result, new ArrayList<>(), 0, nums);
 * return new ArrayList(result);
 * }
 * 
 * private void dfs(Set<List<Integer>> result, List<Integer> tempList, int
 * start, int[] nums) {
 * if (tempList.size() > 1) result.add(new ArrayList(tempList));
 * for (int i = start; i < nums.length; i++) {
 * if (tempList.size() == 0 || tempList.get(tempList.size() - 1) <= nums[i]){
 * tempList.add(nums[i]);
 * dfs(result, tempList, i + 1, nums);
 * tempList.remove(tempList.size() - 1);
 * }
 * }
 * }
 * 
 */