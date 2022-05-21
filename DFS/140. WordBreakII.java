/**
 * The basic backtracking idea is straightforward, find a possible break point
 * and then recursively call the suffix of the original string.
 * The trick is that we use a map to keep the previous result which will
 * terminate the recursion early to make sure we don't get TLE.
 */

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    public List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> memo) {
        // return the string find in previous recursion. This avoid going to Time
        // limited Exception
        if (memo.containsKey(s))
            return memo.get(s);

        List<String> res = new ArrayList<>();
        // special case
        if (s == null || s.length() == 0)
            return res;

        int n = s.length();

        for (String w : wordDict) {
            if (!s.startsWith(w))
                continue;

            int end = w.length();
            if (end == n) {
                res.add(w);
            } else {
                List<String> sublist = dfs(s.substring(end), wordDict, memo);
                for (String item : sublist) {
                    item = w + " " + item;
                    res.add(item);
                }
            }
        }

        memo.put(s, res);
        return res;
    }

}

/**
 * Memorization method
 * 
 * lets take an example. s="catsand" and wordDict = ["cat", "cats", "and",
 * "sand"].
 * 
 * The solution starts by taking the string S( "catsand") initially finding
 * whether whole string is present or not . IN this case it is not present in
 * the dict.
 * 
 * Now breaking the string and then finding
 * s.substr( i) gives the substring from ith index till the end. so string word
 * goes as
 * 
 * atsand // not present
 * tsand // not present
 * 
 * sand //present then the remainder is calculated which is cat in this case and
 * recursive function is called and same thing is done with cat which will
 * return cat and also store the result in the unordered map . Now comes the
 * combine part where both the string are combined and the pushed in the result
 * " cat sand".
 * 
 * and // then comes and which is present so now again wordbreak called on
 * remainder which is cats now and this will return cats. Now both strings are
 * combined and inserted into result . result = {. "cat sand", "cats and"}; Now
 * after the loop ending the result is returned and also stored in map.
 * 
 * public List<String> wordBreak(String s, List<String> wordDict) {
 * List<String> result = new ArrayList<String>();
 * // base cases
 * if (s == null || s.length() == 0) return result;
 * // whether the whole string s is contained in map
 * if (map.containsKey(s)) return map.get(s);
 * if (wordDict.contains(s)) result.add(s); // for beginning when map is null
 * // Now breaking the string and then finding s.substr( i) gives the substring
 * from ith index till the end.
 * for (int i = 1; i < s.length(); i++) {
 * String sub = s.substring(i);
 * if (wordDict.contains(sub)) {
 * List<String> temp = wordBreak(s.substring(0, i), wordDict);
 * if (temp.size() != 0) {
 * for (int j = 0; j < temp.size(); j++) {
 * result.add(temp.get(j) + " " + sub);
 * }
 * }
 * }
 * }
 * map.put(s, result);
 * return result;
 * }
 * 
 */