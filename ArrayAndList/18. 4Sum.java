class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res
        if (start == nums.length) {
            return res;
        }
        // There are k remaining values to add to the sum. The average of these values
        // is at least target / k.
        int average_value = target / k;

        // We cannot obtain a sum of target if the smallest value in nums is greater
        // than target / k or
        // if the largest value in nums is smaller than target / k.
        if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }
        // once the array reduced to 2sum, use the subrountine to get the value
        if (k == 2)
            return twoSum(nums, target, start);

        // If k > 2, need to do a recursive call
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) { // skip value that are the same, avoding same result
                // Recursively call kSum with start = i + 1, k = k - 1, and target - nums[i].
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    // Include the current value nums[i] into subset
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    // Add subset to the result re
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int l = start, r = nums.length - 1; // Note the start point of left is changing at start move to the right
        while (l < r) {
            int currSum = nums[l] + nums[r];
            if (currSum < target)
                l++;
            else if (currSum > target)
                r--;
            else {
                res.add(Arrays.asList(nums[l], nums[r]));
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1])
                    l++;
                while (l < r && nums[r] == nums[r + 1])
                    r--;
            }
        }
        return res;
    }
}