class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty())
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int num = 0;
        int sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int) (c - '0');
            }
            if (!Character.isDigit(c) && ' ' != c || i == s.length() - 1) {
                if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '+') {
                    stack.push(num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = s.charAt(i);
            }
        }
        for (int i : stack) {
            result += i;
        }
        return result;
    }
}