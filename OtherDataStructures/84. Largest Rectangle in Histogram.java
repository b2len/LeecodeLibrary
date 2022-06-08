class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                // if the next bar is shorter than the previous bar on the stack, pop the one
                // the stack
                int tp = s.pop();
                // The key to understand this problem is figure out the length of the bar
                // after poping the first element, the next element on the stack is the first
                // index left of tp with height smaller than tp's height.
                // Why? because if it was geater than tp's height it should have been popped out
                // now we know i is the first element to the right of tp that is higher then the
                // length is their difference minus one
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}