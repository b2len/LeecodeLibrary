class Solution {
    public int removeDuplicates(int[] nums) {
        // Corner case
        if (nums.length <= 1)
            return nums.length;

        int i = 0;
        // Loop through the array, when there's duplicate skip
        // When there's unique item, add it
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        // include the zero position to get the total items
        return i + 1;
    }
}