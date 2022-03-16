class Solution {
    public int longestConsecutive(int[] nums) {
        // Create a Set data structure to keep all unique elements
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            // if the num does not have a element before it, that means it is a start of a
            // string
            if (!numSet.contains(num - 1)) {
                // let's counting from it and see how many consecutive elements is after it,
                // including itself
                int length = 0;
                while (numSet.contains(num + length)) {
                    length++;
                }
                // upddate the longest record
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}