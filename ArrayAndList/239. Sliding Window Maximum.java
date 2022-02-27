class Solution {

    /**
     * We scan the array from 0 to n-1, keep "promising" elements in the deque. The
     * algorithm is amortized O(n) as each element is put and polled once.
     * At each i, we keep "promising" elements, which are potentially max number in
     * window [i-(k-1),i] or any subsequent window. This means
     * If an element in the deque and it is out of i-(k-1), we discard them. We just
     * need to poll from the head, as we are using a deque and elements are ordered
     * as the sequence in the array
     * Now only those elements within [i-(k-1),i] are in the deque. We then discard
     * elements smaller than a[i] from the tail. This is because if a[x] <a[i] and
     * x<i, then a[x] has no chance to be the * "max" in [i-(k-1),i], or any other
     * subsequent window: a[i] would always be a better candidate.
     * As a result elements in the deque are ordered in both sequence in array and
     * their value. At each step the head of the deque is the max element in
     * [i-(k-1),i]
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];
        Deque<Integer> d = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // discard values lower than current
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.removeLast();
            }

            // discard right-most index of previous window
            if (!d.isEmpty() && d.peekFirst() == i - k) {
                d.pop();
            }

            // add current index. offer method is used to add an element at the tail of the
            // queue.
            // This method is preferable to add() method since this method does not
            // throws an exception when the capacity of the container is full since it
            // returns false
            d.offer(i);

            // skip over the first window
            if (i < k - 1) {
                continue;
            }

            // head of d contains the max value over the window
            result[i - k + 1] = nums[d.peekFirst()];
        }

        return result;

    }
}

/**
 * two pointer solution, havent' figure out why it does not pass
 * // corner case
 * if (nums == null || k <= 0 || nums.length < k)
 * throw new IllegalArgumentException();
 * 
 * int max = Integer.MIN_VALUE;
 * int[] window = new int[nums.length - k + 1];
 * int m = 0;
 * 
 * //move the right pointer to scan through the array
 * for (int l = 0, r = 0; r < nums.length; r++) {
 * // situation at the beginning when the slide window is still less than k
 * if (r - l + 1 < k) {
 * max = Math.max(max, nums[r]);
 * }
 * 
 * // if the window is larger than k, then move left forward to the next new
 * window
 * else if (r - l + 1 > k) {
 * // situation where the original left value is the largest value
 * if (nums[l] == max) {
 * for (int i = l + 1; i < k + l; i++) {
 * max = Math.max (nums[i], nums[i + 1]); // find the second largest element in
 * the window
 * }
 * l++;
 * }
 * l++;
 * }
 * 
 * // if the window is the k size, record the max value to the new array
 * if (r - l + 1 == k) {
 * max = Math.max(max, nums[r]);
 * window[m] = max;
 * m++;
 * }
 * 
 * }
 * return window;
 * }
 * 
 */