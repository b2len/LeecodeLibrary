class NumArray {
    int[] preSum;

    public NumArray(int[] nums) {
        preSum = nums; // pass by pointer, modifying the original array??
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] += preSum[i - 1]; // store the rolling sum value to preSum
        }

    }

    public int sumRange(int left, int right) {
        if (left == 0)
            return preSum[right]; // if start from beginning, it's just the sum at index right
        return preSum[right] - preSum[left - 1]; // otherwise we can calculate the range
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */