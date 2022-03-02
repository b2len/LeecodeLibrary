public class Solution {
    /**
     * @param nums: an array
     * @param k:    a target value
     * @return: the maximum length of a subarray that sums to k
     */
    public int maxSubArrayLen(int[] nums, int k) {
        // calculate the presum and then compare with the previous values
        // thinking to chop off some prefix sum so that the result = k
        // if our current sum is cursum, then we want a prefixSum = curSum - k
        int n = nums.length;
        int res = 0;
        int preSum = 0;
        // use a hash table to record the preSum result at i position
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // presum of the first element is at -1 position
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) { // check if there is a prefix sum that is equal to sum - k exist in the
                                               // Hashtable or not
                res = Math.max(res, i - map.get(preSum - k)); // calculate the length, record the largest
            }
            if (!map.containsKey(preSum)) { // if no such sum exist in the hashtable, put it and its index in.
                map.put(preSum, i);
            }

        }
        return res;
    }
}