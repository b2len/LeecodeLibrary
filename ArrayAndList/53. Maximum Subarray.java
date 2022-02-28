class Solution {

    /**
     * Prefix sums
     * keep a current sum of the array.
     * If the current sum is negative, there's no point keep it, reset it to zero
     * and start the new array fresh
     * You can think of lump all the previous elements into one elment, and that
     * element is negative
     */

    public int maxSubArray(int[] nums) {
        int min = 0;
        int curSum = 0;
        int max = nums[0];
        for (int num : nums) {
            if (curSum < 0)
                curSum = 0;
            curSum += num;
            max = Math.max(max, curSum);
        }
        return max;
    }
}