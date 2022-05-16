class Solution {
    // fast solution using loop to avoid duplicate answer
    public List<String> removeInvalidParentheses(String s) {
        int count = 0, openN = 0, closeN = 0;

        // calculate the total numbers of opening and closing parentheses
        // that need to be removed in the final solution
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0)
                    closeN++;
                else
                    count--;
            }
        }
        openN = count;
        count = 0;

        // when the given string is already valid
        if (openN == 0 && closeN == 0)
            return Arrays.asList(s);

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(s.toCharArray(), 0, count, openN, closeN, result, sb);

        return result;
    }

    private void dfs(char[] s, int p, int count, int openN, int closeN, List<String> result, StringBuilder sb) {
        if (count < 0)
            return; // the parenthesis is invalid

        if (p == s.length) {
            if (openN == 0 && closeN == 0) { // the minimum number of invalid parenthese have been removed
                result.add(sb.toString());
            }
            return;
        }

        // when the char is a letter
        if (s[p] != '(' && s[p] != ')') {
            sb.append(s[p]);
            dfs(s, p + 1, count, openN, closeN, result, sb);
            sb.deleteCharAt(sb.length() - 1);
            // when the char is a left bracket
        } else if (s[p] == '(') {
            int i = 1;
            // use while loop to avoid duplicate result in DFS, instead of using HashSet
            while (p + i < s.length && s[p + i] == '(')
                i++; // skip all ( that are adjacent to each other
            sb.append(s, p, i);
            dfs(s, p + i, count + i, openN, closeN, result, sb);
            sb.delete(sb.length() - i, sb.length());

            if (openN > 0) {
                // remove the current opening parenthesis
                dfs(s, p + 1, count, openN - 1, closeN, result, sb);
            }
            // when the char is a right braket
        } else {
            int i = 1;
            // use while loop to avoid duplicate result in DFS, instead of using HashSet
            while (p + i < s.length && s[p + i] == ')')
                i++; // skip all ( that are adjacent to each other
            sb.append(s, p, i);
            dfs(s, p + i, count - i, openN, closeN, result, sb);
            sb.delete(sb.length() - i, sb.length());

            if (closeN > 0) {
                // remove the current closing parenthesis
                dfs(s, p + 1, count, openN, closeN - 1, result, sb);
            }
        }
    }
}

/**
 * // An alternative solution using a matrix
 * class Solution { // 10 ms, faster than 76.12%
 * public List<String> removeInvalidParentheses(String s) {
 * int n = s.length();
 * HashSet<String> validParentheses = dfs(s, 0, 0, new HashSet[n + 1][n + 1]);
 * int maxLen = 0; // Remove the minimum number of invalid parentheses -> ans is
 * list of elements with maximum length
 * for (String str : validParentheses) maxLen = Math.max(maxLen, str.length());
 * 
 * List<String> ans = new ArrayList<>();
 * for (String str : validParentheses)
 * if (str.length() == maxLen)
 * ans.add(str);
 * return ans;
 * }
 * 
 * HashSet<String> dfs(String s, int i, int nOpen, HashSet<String>[][] memo) {
 * HashSet<String> ans = new HashSet<>();
 * if (nOpen < 0) return ans; // invalid parentheses
 * if (memo[i][nOpen] != null) return memo[i][nOpen];
 * if (i == s.length()) {
 * if (nOpen == 0) ans.add(""); // valid parentheses
 * } else {
 * char c = s.charAt(i);
 * if (c == '(' || c == ')') {
 * ans.addAll(dfs(s, i + 1, nOpen, memo)); // Case 1: Skip s[i]: '(' or ')'
 * }
 * int newOpen = nOpen;
 * if (c == '(') newOpen++;
 * else if (c == ')') newOpen--;
 * for (String suffix : dfs(s, i + 1, newOpen, memo)) // Case 2: Include s[i]:
 * '(' or ')' or letter
 * ans.add(c + suffix);
 * }
 * return memo[i][nOpen] = ans;
 * }
 * }
 * 
 */

/**
 * HashSet solution from Leecode
 * class Solution {
 * 
 * private Set<String> validExpressions = new HashSet<String>();
 * 
 * private void recurse(
 * String s,
 * int index,
 * int leftCount,
 * int rightCount,
 * int leftRem,
 * int rightRem,
 * StringBuilder expression) {
 * 
 * // If we reached the end of the string, just check if the resulting
 * expression is
 * // valid or not and also if we have removed the total number of left and
 * right
 * // parentheses that we should have removed.
 * if (index == s.length()) {
 * if (leftRem == 0 && rightRem == 0) {
 * this.validExpressions.add(expression.toString());
 * }
 * 
 * } else {
 * char character = s.charAt(index);
 * int length = expression.length();
 * 
 * // The discard case. Note that here we have our pruning condition.
 * // We don't recurse if the remaining count for that parenthesis is == 0.
 * if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0))
 * {
 * this.recurse(
 * s,
 * index + 1,
 * leftCount,
 * rightCount,
 * leftRem - (character == '(' ? 1 : 0),
 * rightRem - (character == ')' ? 1 : 0),
 * expression);
 * }
 * 
 * expression.append(character);
 * 
 * // Simply recurse one step further if the current character is not a
 * parenthesis.
 * if (character != '(' && character != ')') {
 * 
 * this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem,
 * expression);
 * 
 * } else if (character == '(') {
 * 
 * // Consider an opening bracket.
 * this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem,
 * expression);
 * 
 * } else if (rightCount < leftCount) {
 * 
 * // Consider a closing bracket.
 * this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem,
 * expression);
 * }
 * 
 * // Delete for backtracking.
 * expression.deleteCharAt(length);
 * }
 * }
 * 
 * public List<String> removeInvalidParentheses(String s) {
 * 
 * int left = 0, right = 0;
 * 
 * // First, we find out the number of misplaced left and right parentheses.
 * for (int i = 0; i < s.length(); i++) {
 * 
 * // Simply record the left one.
 * if (s.charAt(i) == '(') {
 * left++;
 * } else if (s.charAt(i) == ')') {
 * // If we don't have a matching left, then this is a misplaced right, record
 * it.
 * right = left == 0 ? right + 1 : right;
 * 
 * // Decrement count of left parentheses because we have found a right
 * // which CAN be a matching one for a left.
 * left = left > 0 ? left - 1 : left;
 * }
 * }
 * 
 * this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
 * return new ArrayList<String>(this.validExpressions);
 * }
 * }
 */