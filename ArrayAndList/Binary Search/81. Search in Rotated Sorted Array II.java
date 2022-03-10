class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2; 
            if (target == nums[mid]) return true;
            // approach if its left is identified as a sorted array
            if (nums[l] < nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                } 
            }
            // if the element are equal to the mid, move the pointer inward
            else if (nums[l] == nums[mid]) l = l + 1;
            else if (nums[r] == nums[mid]) r = r - 1;
            // approach if its right is identified as a sorted array
            else {
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}