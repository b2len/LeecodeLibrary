class StockSpanner {

    /*
     * Have a stack of pair of (current price, maximum number of consecutive days)
     * Since we don't have access to the indices>
     */

    Stack<int[]> s;

    public StockSpanner() {
        s = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        // If the current price is greater than stack peek
        while (!s.isEmpty() && price >= s.peek()[0]) {
            span += s.peek()[1];
            s.pop();
        }
        // otherwise put the pair into the stack
        s.push(new int[] { price, span });
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */