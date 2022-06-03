/**
    * tails is an awway storing the smallest tail of all increasing subsequences with length i + 1 in tails[i]
    * it is possible to do a binary search in tails array to find the one needs update
    * each time we only do one of the two:
        1) if x is larger than all tails, append it, increase the size by 1
        2) if tails[i - 1] < x <= tails[i], update tails[i]
    * Doing so will maintian the tails invariant. 
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}