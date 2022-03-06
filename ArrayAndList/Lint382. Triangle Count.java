public class Solution {

    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // Sort the array first
        Arrays.sort(S);
        int ans = 0;
        for (int i = S.length - 1; i >= 2; i--) {
            if (S[i] <= 0) {
                // break;
            }
            int l = 0, r = i - 1;
            while (S[l] > 0 && l < r) {
                if (S[i] < S[l] + S[r]) {
                    ans += r - l;
                    r--;
                    // System.out.print(ans);

                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
