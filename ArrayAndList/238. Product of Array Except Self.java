class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // set the prefix as a neutron value for the first element. Since there's
        // nothering to its left
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = prefix; // Sett a neutron value for prefix avoid dealing with the additional complexity
                             // of include or exclude the first element
            prefix *= nums[i]; // prefix variable is the rolling product sum of elements before elements i + 1,
                               // this is for the next round
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) { // loop backward
            ans[i] *= suffix; // similar to the previous loop, the key is to imagine there's an element
                              // outside the last element so this loop would work for all case!
            suffix *= nums[i];
        }

        return ans;
    }
}