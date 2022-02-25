class Solution {
    public int lengthOfLongestSubstring(String s) {
        // corner case
        int n = s.length();
        if (n <= 1)
            return n;

        int ans = 0;

        // for C++ it is ASCII based (128 in size), for Java it is Unicode based, so it
        // has 256 unique characters
        // therefore, in java, the longest substring without repeating characters is 256
        // maximum
        // an array of 256 in size will accomodate it
        int[] idx = new int[256];

        // Using i to track the staring point of the substring
        // Using j to track the end point of the substring. Update the idx array in
        // everyloop

        for (int i = 0, j = 0; j < n; j++) {
            // The charAt() method returns the character at the specified index in a string.
            // it can also be the integer of the underlying unicode or ASCII code
            if (idx[s.charAt(j)] > 0) { // idx[s.charAt(j)] indicate the last position when the char s.charAt(j) appears
                                        // in the string
                i = Math.max(i, idx[s.charAt(j)]); // once a duplicate is found, move the starting point i to the index
                                                   // where the previous duplicate is found
            }
            idx[s.charAt(j)] = j + 1; // record the last index of the character j;

            // The sliding window length
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}