class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = multipliers.length;
        int m = nums.length;
        int[][] dp= new int[n+1][n+1];
        int res = Integer.MIN_VALUE;
        for(int i=0; i<=n; i++){
            for(int j=0;j<=n; j++){
                if(i+j>n) break;
                if(i-1>=0 && j-1>=0) dp[i][j] = Math.max(dp[i-1][j] + multipliers[i+j-1]*nums[i-1], dp[i][j-1] + multipliers[i+j-1]*nums[m-j]);
                else if(i-1>=0) dp[i][j] = dp[i-1][j] + multipliers[i+j-1]*nums[i-1];
                else if(j-1>=0)  dp[i][j] = dp[i][j-1] + multipliers[i+j-1]*nums[m-j];
                if(i+j==n){
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}