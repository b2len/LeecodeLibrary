class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // skip integer that is the same with previously used values
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                // set the current index as true, indicating it is now used
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                // Once reaching to this point, you have finished traverse the whole subbranch
                // time to backtrack to the previous level and reset the boolean condition
                // OR if there's still elements that have not visited, finish the loop till the
                // end
                // example, after 1, 1, 2, the thrid level visited all the element, now going
                // back to second level
                // second level have not visit 2, so after remove the current value 1, it will
                // go to the last element 2, it becomes 1, 2, ....
                // after second level complete the loop, it will go to the first level and so
                // forth
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}