class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid])
                return mid;

            // check if we are in the left portion of the sorted array
            if (nums[l] <= nums[mid]) {
                // if target is beyond the mid value or target is even smaller than the smallest
                // in the part of sorted array
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else
                    r = mid - 1;
            }

            // Situation we are in the right portion of the sorted array
            if (nums[r] >= nums[mid]) {
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else
                    l = mid + 1;
            }
        }
        return -1;
    }
}