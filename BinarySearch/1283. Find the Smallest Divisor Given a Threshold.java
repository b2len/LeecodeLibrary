class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 1;
        for (int num : nums) {
            r = Math.max(r, num);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            int total = 0;

            for (int num : nums) {
                total += Math.ceil((double) num / mid);
            }

            if (threshold < total) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}