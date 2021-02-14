class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        if(S>sum) return 0;
        if((sum+S)%2==1) return 0;
        int target = (sum+S)/2;
        target = Math.min(target, sum-target);
        int[][] dp = new int[nums.length+1][target+1];
        dp[0][0] = 1;
        for(int i=1; i<=nums.length; i++) {
            for(int j=0; j<=target; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i-1]) {
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}