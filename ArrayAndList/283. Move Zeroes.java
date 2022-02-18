class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1)
            return;
        int i = 0;
        int j = 0;
        int n = nums.length - 1;
        while (j <= n) {
            if (nums[j] == 0) {
                j++;
            } else {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }

    }
}