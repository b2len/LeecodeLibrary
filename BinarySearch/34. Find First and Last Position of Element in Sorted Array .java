class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);

        return result;
    }

    public int binarySearch(int[] nums, int target, boolean leftBias) {
        int left = 0, right = nums.length - 1;
        int i = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else {
                i = mid;
                if (leftBias)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return i;
    }
}