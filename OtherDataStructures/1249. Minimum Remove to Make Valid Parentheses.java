class Solution {
    /**
     * Use stack to remove mismatching parenthesis, two scenarios:
     * 1. there're more closing parenthesis than previous opening ones, e.g. ()))))
     * 2. there're more opening parenthesis than closed ones afterwards, e.g. ()(((
     * Use a HashSet to track the position of the excessive parenthesis and exclude
     * them from result
     */
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i); // push its index not the bracket
            } else if (c == ')') {
                // meet closing braket but no matching open bracket
                if (stack.isEmpty())
                    set.add(i);
                else
                    stack.pop();
            }
        }
        set.addAll(stack); // add the positions of all remaining open bracket

        // loop through the string to get the result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}