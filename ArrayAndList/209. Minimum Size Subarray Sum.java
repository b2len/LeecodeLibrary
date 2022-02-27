class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // corner cases
        if (target <= 0 || nums == null)
            throw new IllegalArgumentException();

        int len = Integer.MAX_VALUE;
        int sum = 0;

        for (int left = 0, right = 0; right < nums.length; right++) {
            // what happens when moving the right pointer
            sum = sum + nums[right];
            // what happens the condition is fullfilled and need to move the left pointer
            while (sum >= target) {
                len = Math.min(len, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        return len = len == Integer.MAX_VALUE ? 0 : len;
    }
}