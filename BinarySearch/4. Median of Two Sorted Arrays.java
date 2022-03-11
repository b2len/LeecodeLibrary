class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Invalid input corner cases
        if (nums1 == null || nums2 == null) return 0.0;
        if (nums1.length == 0 && nums2.length == 0) return 0.0;
        
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;            // position of Median of the left half of the combined array, this is the last element of the left half
        int r = (m + n + 2) / 2;            // position of Median of the right half of the combined array, this is the first element of the right half
        
        // If the combined array is odd, the two functions below will return the same value
        // If the combined arrahy is even, the two function will return the left number and right number that make up the median
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }
    
    public double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // This function find the kth element in a combined array nums1 + nums2 (without actully combining the two)
        
        // if nums1 is exhasted, return the kth element in nums2
        if (start1 > nums1.length - 1) return nums2[start2 + k - 1];
        
        // if nums1 is exhasted, return the kth element in nums2
        if (start2 > nums2.length - 1) return nums1[start1 + k - 1];
        
        // If k == 1, return the first number
        // Since nums1 and nums2 is sorted, the smaller one among the start point of nums1 and nums2 is the first one
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < nums1.length) mid1 = nums1[start1 + k / 2 - 1];
        if (start2 + k / 2 - 1 < nums2.length) mid2 = nums2[start2 + k / 2 - 1];
        
        // Throw away half of the array from nums1 or nums2, and cut k n half
        if (mid1 < mid2) {
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2); // throw away nums1.left, remaining is nums1.right + nums2
        } else {
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2); // throw away nums2.left, remaining is nums1 + nums2.right
        }
    }
}