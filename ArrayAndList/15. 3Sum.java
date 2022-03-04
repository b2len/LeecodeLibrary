class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // corner cases
        // if (nums == null || nums.length < 3) return null;

        List<List<Integer>> ans = new ArrayList<>();
        // Sort the array first
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // skip value that are the same, avoding same result
                continue;
            }

            // Using two pointer method to get the desired sum
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                // move left or right pointer depending if it is higher or lower than the targer
                if (threeSum > 0)
                    r -= 1;
                else if (threeSum < 0)
                    l += 1;
                // if a match if found, append it to the list
                else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r])); // learn the asList method
                    l++;
                    r--;
                    // move to the one after if the next one is the same as before -- avoiding
                    // duplicate results
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                }

            }
        }
        return ans;
    }
}