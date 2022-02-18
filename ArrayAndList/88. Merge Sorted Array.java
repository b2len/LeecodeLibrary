class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // compare from the tail, whichever is larger, put it in the very end
        int tail1 = m - 1, tail2 = n - 1, total = m + n - 1;

        while (tail1 >= 0 && tail2 >= 0) {
            if (nums1[tail1] > nums2[tail2]) {
                nums1[total] = nums1[tail1];
                tail1--;
            } else {
                nums1[total] = nums2[tail2];
                tail2--;
            }
            total--;
        }

        // if after nums1 running out, there's remaining elements in nums2
        while (tail2 >= 0) {
            nums1[total] = nums2[tail2];
            total--;
            tail2--;
        }

    }
}

/**
 * public void merge(int[] nums1, int m, int[] nums2, int n) {
 * int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
 * while (tail1 >= 0 && tail2 >= 0) {
 * nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
 * nums1[tail1--] : nums2[tail2--];
 * }
 * 
 * while (tail2 >= 0) { //only need to combine with remaining nums2
 * nums1[finished--] = nums2[tail2--];
 * }
 * }
 */