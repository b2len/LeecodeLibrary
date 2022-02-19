class Solution {
    public int longestMountain(int[] arr) {
        // corner case
        if (arr.length < 3)
            return 0;

        int max = 0;

        // Pay attention to the boundary condition, "< length - 1" as you only need to
        // exam till the second last element!
        for (int i = 1; i < arr.length - 1; i++) {

            // the smallest mountain is 3
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                while (left > 0 && arr[left - 1] < arr[left])
                    left--;
                // again, boundary condition
                while (right < arr.length - 1 && arr[right] > arr[right + 1])
                    right++;

                // use the space between right and left to calculate the number of elements
                max = Math.max(max, right - left + 1);
            }

        }
        return max;
    }
}