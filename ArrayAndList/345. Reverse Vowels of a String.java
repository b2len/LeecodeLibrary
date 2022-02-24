class Solution {
    public String reverseVowels(String s) {
        // Corner cases
        if (s == null)
            throw new IllegalArgumentException();
        if (s.length() <= 1)
            return s;

        // convert str is a series of characters that can be used in loops
        char[] str = s.toCharArray();

        // have two pointers one pointing to the start, one pointing to the end
        // Classic two pointer approach
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            while (!isVowel(str[i]) && i < j)
                i++;
            while (!isVowel(str[j]) && i < j)
                j--;
            if (i <= j)
                swap(str, i, j);
        }

        return new String(str);
    }

    private boolean isVowel(char ch) {
        // Don't forget to change to lower cases
        char c = Character.toLowerCase(ch);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}