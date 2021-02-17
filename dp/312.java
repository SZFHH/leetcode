class Solution {
    int[][] dp;
    int[] nums;
    public int maxCoins(int[] nums) {
        dp = new int[nums.length+2][nums.length+2];
        this.nums = new int[nums.length+2];
        this.nums[0] = 1;
        this.nums[nums.length+1] = 1;
        for(int i=1; i<=nums.length; i++){
            this.nums[i] = nums[i-1];
        }       
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, nums.length+1);
    }

    public int dfs(int st, int ed){
        if(st+1>=ed) return 0;
        if(dp[st][ed]!=-1) return dp[st][ed];
        int res = -1;
        for(int i = st+1; i<ed; i++) {
            res = Math.max(res, dfs(st, i) + dfs(i, ed) + nums[st]*nums[ed]*nums[i]);
        }
        dp[st][ed] = res;
        return res;
    }
}