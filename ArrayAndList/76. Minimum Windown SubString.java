class Solution {
    public String minWindow(String s, String t) {
        // Corner case
        if (s == null || t == null)
            throw new IllegalArgumentException();

        if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        // put all chars in String t to a string array
        // record their frequency via loop through all elements
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        // initiate a few variable to be used in the loop
        int start = 0;
        int len = Integer.MAX_VALUE;
        int count = t.length();

        for (int left = 0, right = 0; right < s.length(); right++) {
            // use j to scan through the list
            char c = s.charAt(right);
            // minus the char by one as right scan through
            freq[c]--;
            // move to right until all chars in string t has been scanned
            if (freq[c] >= 0)
                count--;
            // now the right side satisfies the condition, we need to check the left side
            while (count == 0) {
                char lc = s.charAt(left);
                freq[lc]++;
                // this condition check if the current char is in the t string or not
                // if yes, then we need to stop here and count/update the length
                if (freq[lc] > 0) {
                    if (right - left + 1 < len) { // find an substring that has shorter length
                        start = left; // use a variable to record the start position of the current shortest substring
                        len = right - left + 1; // update the length of the substring
                    }
                    count++; // now since we find a substring that fit the condition, add the count by one as
                             // we will move out and check the next one
                }
                left++; // move the left pointer to the right until counter is no longer zero
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}