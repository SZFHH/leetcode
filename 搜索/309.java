class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0) return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0]; // 第i天之后持有股票时的最大收益(第i天买或者之前买)
        dp[0][1] = 0; // 第i天之后不持有股票并且处于冷冻期的最大收益(第i天卖，前一天必须持有股票)
        dp[0][2] = 0; // 第i天之后不持有股票且不处于冷冻期的最大收益(第i-1天或者之前卖，第i天不操作)
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }
}