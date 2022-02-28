class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int prod = 1;
        for (int l = 0, r = 0; r < nums.length; r++) {
            // multiply elements by move the right pointer to the right until it exceeds k
            prod = prod * nums[r];
            while (l <= r && prod >= k) {
                prod = prod / nums[l];
                l++;
            }
            // everytime add another element, there will be r - l + 1 new combination with
            // the element at r, including r itself
            count += r - l + 1;
        }

        return count;
    }
}