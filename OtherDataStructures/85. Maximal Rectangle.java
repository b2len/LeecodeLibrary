/**
 * 
 * We can apply the maximum in histogram in each row of the 2D matrix. What we
 * need is to maintain an int array for each row, which represent for the height
 * of the histogram.
 * 
 * Please refer to https://leetcode.com/problems/largest-rectangle-in-histogram/
 * first.
 * 
 * Suppose there is a 2D matrix like
 * 
 * 1 1 0 1 0 1
 * 
 * 0 1 0 0 1 1
 * 
 * 1 1 1 1 0 1
 * 
 * 1 1 1 1 0 1
 * 
 * First initiate the height array as 1 1 0 1 0 1, which is just a copy of the
 * first row. Then we can easily calculate the max area is 2.
 * 
 * Then update the array. We scan the second row, when the matrix[1][i] is 0,
 * set the height[i] to 0; else height[i] += 1, which means the height has
 * increased by 1. So the height array again becomes 0 2 0 0 1 2. The max area
 * now is also 2.
 * 
 * Apply the same method until we scan the whole matrix. the last height arrays
 * is 2 4 2 2 0 4, so the max area has been found as 2 * 4 = 8.
 * 
 * Then reason we scan the whole matrix is that the maximum value may appear in
 * any row of the height.
 * 
 */

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int ans = 0, m = matrix.length, n = matrix[0].length;
        int[] height = new int[n]; // height
        // iterate through the matrix to get the height array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                    continue;
                }
                height[j]++;

                for (int cur = j - 1, pre = height[j]; cur >= 0; cur--) {
                    if (height[cur] == 0)
                        break;
                    pre = Math.min(pre, height[cur]); // ie the shortest bar dictate the height of the rectangle
                    ans = Math.max(ans, (j - cur + 1) * pre);
                }

                ans = Math.max(ans, height[j]);
            }
        }
        return ans;
    }
}