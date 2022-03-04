class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
                // ans[0] = i;
                // ans[1] = map.get(target - nums[i]);
                // return ans;
            } else
                map.put(nums[i], i);
        }
        return null;
    }
}