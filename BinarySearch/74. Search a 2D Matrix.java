class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int l = 0, r = row * col - 1;        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midRow = mid / col, midCol = mid % col;
            if (target == matrix[midRow][midCol]) return true;
            if (target > matrix[midRow][midCol]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }            
        }
        return false;        
    }
}