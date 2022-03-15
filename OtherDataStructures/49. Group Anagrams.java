class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // edge case
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();      
        for (String s : strs) {
            char[] count = new char[26];
            // Use string function toCharArray to convert it to a char array
            for (char c : s.toCharArray()) {
            // The greate thing about putting into this letter array is that it is sorted!!!
                count[c - 'a'] += 1;    // no need to worry about same letter combo but different sequence!
            }
            // The java.lang.String.valueOf(char[] data, int offset, int count) method returns 
            // the string representation of a specific subarray of the char array argument.
            String keyStr = String.valueOf(count);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        // returns a Collection view of the values in the HashMap
        return new ArrayList<>(map.values());
    }
}