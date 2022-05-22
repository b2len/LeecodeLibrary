/**
 * We can observe that a lot of redundant function calls were made with the same
 * value of i as the current index and the same value of sum as the current sum,
 * since the same values could be obtained through multiple paths in the
 * recursion tree.
 * In order to remove this redundancy, we make use of memoization as well to
 * store the results which have been calculated earlier.
 */

class Solution {
    Map<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int sum, int index, int target) {
        // base case when it reaches the end of the array and check if the sum equals
        // target
        if (index == nums.length && sum == target) {
            return 1; // we find a valid answer, return 1 to accrue the result -- we need to find the
                      // total number of ways
        }
        if (index == nums.length && sum != target) {
            return 0; // reach the end of the array but did not find a valid answer, return 0
        }

        // memorization using map
        // use immutability of String for unique key in map
        String key = sum + "," + index;
        // if we have calculated that combo already, get the value directly and move to
        // the second dfs
        if (map.containsKey(key))
            return map.get(key);

        int count = 0;
        // traverse through the positive and negative cases
        count += dfs(nums, sum - nums[index], index + 1, target);
        count += dfs(nums, sum + nums[index], index + 1, target);

        // add to map for future use
        map.put(key, count);
        return count;
    }
}
