class Solution {
    public int subarraySum(int[] nums, int k) {
        /**
         * Similar to Q325, the KEY to this question is the realization that
         * we need to record the number of prefixSums such that currentSum - k =
         * prefixSum
         * To do this, we Record the presum values as we go through the array
         * In the mean time, check the sum we have now minus k gives any match to all
         * previous prefixSum calculated
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        // put the presum before first element in. assume it is neutral value 0.
        map.put(0, 1);
        int preSum = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i]; // this should be the first step
            if (map.containsKey(preSum - k)) { // check if the value is in the hashmap
                ans += map.get(preSum - k);
            }

            // NOTE this line of cod can't put ahead of the above. Othewise you are double
            // counting. Try example k = 0
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            /**
             * if (!map.containsKey(preSum)) {
             * map.put(preSum, 1);
             * } else {
             * map.put(preSum, map.get(preSum) + 1);
             * }
             */

        }

        return ans;
    }
}
