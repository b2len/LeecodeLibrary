class Solution {
    public int findKthLargest(int[] nums, int k) {

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    // Quick Select: put nums that are <= pivot to the left
    // put nums that are > pivot to the right
    public int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, pivot++, j);
            }
        }

        swap(nums, pivot, high);

        // count the numbs that > pivot from high
        int count = high - pivot + 1;
        // pivot is the one
        if (count == k)
            return nums[pivot];
        // pivot is too small, so it must be on the right
        if (count > k)
            return quickSelect(nums, pivot + 1, high, k);
        // pivot is too big, so it must be on the left
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

/**
 * Brute force
 * 
 * int n = k;
 * int i = 0;
 * 
 * while (n > 0) {
 * sort(nums, i);
 * i++;
 * n--;
 * }
 * return nums[k-1];
 * }
 * 
 * public void sort(int[] nums, int i) {
 * int n = nums.length -1;
 * if (i == n ) return;
 * int j = i + 1;
 * while (j <= n) {
 * if (nums[i] < nums[j]) {
 * int temp = nums[i];
 * nums[i] = nums[j];
 * nums[j] = temp;
 * }
 * j++;
 * }
 * 
 * 
 */