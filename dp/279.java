class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 10005);
        dp[0] = 0;
        int[] sqr = new int[101];
        for(int i=1;i<=100;i++) sqr[i] = i*i;
        for(int i=1; i<n+1; i++) {
            for(int j=1;j<=100;j++) {
                if(sqr[j] > i) break;
                dp[i] = Math.min(dp[i], dp[i-sqr[j]]+1);
            }
        }
        return dp[n];
    }
}