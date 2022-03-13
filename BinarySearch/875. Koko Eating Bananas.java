class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            int hrs = 0;

            for (int pile : piles) {
                hrs += Math.ceil((double) pile / mid);
            }
            // check if middle is a workable speadd, and cut the search space by half
            if (hrs <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}