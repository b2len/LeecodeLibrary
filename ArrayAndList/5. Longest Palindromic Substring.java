class Solution {
    public String longestPalindrome(String s) {
        int end = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            // when the length is odd number
            int len1 = getLen(s, i, i);
            // when the length is even number
            int len2 = getLen(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                // using (len-1)/2 and len/2 to take care of even number situation
                // example: 321aabbcc124, for aabbcc index for b is 5, len is 6, so start is 5 -
                // (6 - 1) / 2 = 5 - 2 = 3
                // end is 5 + 6 / 2 = 8
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        // remeber for string left is closed, right is open, therefore need to be end +
        // 1 to include the last element
        return s.substring(start, end + 1);
    }

    private int getLen(String s, int l, int r) {

        // if it is a palindrome in the middle, expand to the left and right to check if
        // its boundary are equal
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}