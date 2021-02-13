class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int c = 0, r = m-1;
        while(c<n && r>=0) {
            if(matrix[c][r]==target) {
                return true;
            } else if(matrix[c][r] > target) {
                r--;
            } else{
                c++;
            }
        }
        return false;
    }
}