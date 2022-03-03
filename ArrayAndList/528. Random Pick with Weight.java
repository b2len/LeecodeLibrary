class Solution {
    int[] wSum;
    Random random = new Random();

    // create a array with rolling sum
    public Solution(int[] w) {
        wSum = w;
        for (int i = 1; i < wSum.length; i++) {
            wSum[i] += wSum[i - 1];
        }

    }

    // use binary search to find the random number's location
    public int pickIndex() {
        int len = wSum.length;
        int idx = random.nextInt(wSum[len - 1]) + 1;
        int left = 0, right = len - 1;

        // search position
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (wSum[mid] == idx)
                return mid;
            else if (wSum[mid] < idx)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */