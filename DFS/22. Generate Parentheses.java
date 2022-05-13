class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

/**
 * 
 * public List<String> generateParenthesis(int n) {
 * List<String> list = new ArrayList<String>();
 * backtrack(list, "", 0, 0, n);
 * return list;
 * }
 * 
 * private void backtrack(List<String> list, String str, int open, int close,
 * int max) {
 * if (str.length() == max * 2) {
 * list.add(str);
 * return;
 * }
 * 
 * if (open < max) {
 * backtrack(list, str + "(", open + 1, close, max);
 * }
 * // draw out each recursive call structure and steps will help you understand
 * the algorithm
 * if (close < open) {
 * backtrack(list, str + ")", open, close + 1, max);
 * }
 * }
 * }
 * 
 */
