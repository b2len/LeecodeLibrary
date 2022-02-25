class Solution {
    public boolean validPalindrome(String s) {
        // corner cases
        if (s == null)
            throw new IllegalArgumentException();
        if (s.length() <= 2)
            return true;

        // convert string to char array
        char[] str = s.toCharArray();

        // Use a left and right pointer to compare the elements at each boundary
        int l = 0;
        int r = str.length - 1;
        while (l < r - 1) {
            // KEY: if there's a difference, when remove that element, the inner string must
            // be a palindrome
            if (str[l] != str[r]) {
                // check if the elements within i and j is Palindrom, the element removed could
                // be on either side
                return isPalindrome(str, l + 1, r) || isPalindrome(str, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(char[] str, int l, int r) {
        while (l < r) {
            if (str[l] != str[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
}