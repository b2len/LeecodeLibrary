class Solution {
    // put the map outside to give access to the private function
    Map<Character, Integer> map = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        // edge cases
        if (words == null || words.length == 0)
            return false;

        // map the alien dictionary to the HashTable
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        // build a compare subroutine to check two nearby words
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1]))
                return false;
        }
        return true;
    }

    private boolean compare(String s1, String s2) {
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
            // handle cases if there's a difference char found
            if (s1.charAt(i) != s2.charAt(j)) {
                if (map.get(s1.charAt(i)) > map.get(s2.charAt(j)))
                    return false;
                else {
                    return true;
                }
            }
        }
        // if the for loop did not find any different char, then we need to compare the
        // length of the two words
        // if the s1 is longer, it should be put after s2, then the sequence is not
        // correct, therefore return false
        if (s1.length() > s2.length())
            return false;
        // otherwise return true.
        return true;
    }
}