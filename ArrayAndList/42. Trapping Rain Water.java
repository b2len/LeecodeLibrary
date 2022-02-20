class Solution {
    public int trap(int[] height) {
        // two pointers solution.
        // corner case
        int n = height.length;
        if (height == null || n <= 2)
            return 0;

        // Initiate the two pointers at each end
        int left = 1;
        int right = n - 2;

        // record the highest boundary on each side
        int maxleft = height[0];
        int maxright = height[n - 1];
        int rainwater = 0;

        // loop till the two pointers meet
        // Note the boundary condition is "<=" not "<", as the left and right start from
        // 1 and n-2 respectively
        // "<" will miss the possible water trapped in the last element that before the
        // two pointer meet

        while (left <= right) {
            if (maxleft <= maxright) {
                if (maxleft < height[left]) {
                    maxleft = height[left];
                    left++;
                } else {
                    rainwater = rainwater + maxleft - height[left];
                    left++;
                }
            } else {
                if (maxright < height[right]) {
                    maxright = height[right];
                    right--;
                } else {
                    rainwater = rainwater + maxright - height[right];
                    right--;
                }
            }

        }
        return rainwater;
    }
}

/**
 * Initial thinking
 * 
 * // on each level, find a left boundary, if there's space after it, continue
 * counting the space
 * // if encouters level or high, move it to that position and repeat
 * 
 * int n = height.length;
 * int level = 1;
 * int top = highest(height);
 * int totalRain = 0;
 * 
 * // loop through each level
 * while (level <= top){
 * int levelRain = 0;
 * 
 * // loop through the level (i.e. array), if there's a boundary, check if
 * there's a right boundary to make a container
 * for (int i = 0; i <= n - 1; i++) {
 * // find one boundary
 * if (height[i] >= level) {
 * // use a second pointer to check the right boundary
 * int j = i + 1;
 * while (j <= n-1){
 * if (height[j] < level) j++;
 * else return j;
 * }
 * int rain = (j == n -1) ? 0 : j - i - 1;
 * levelRain = levelRain + rain;
 * }
 * }
 * totalRain = totalRain + levelRain;
 * level++;
 * }
 * return totalRain;
 * }
 * 
 * public int highest(int[] height) {
 * int max = 0;
 * int i = 0;
 * while (i <= height.length -1) {
 * max = Math.max(max, height[i]);
 * i++;
 * }
 * return max;
 * }
 * 
 */