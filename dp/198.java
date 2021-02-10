class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] rb = new int[n];
        int[] nrb = new int[n];
        if(n==0) return 0;
        rb[0] = nums[0];
        nrb[0] = 0;
        for(int i=1; i<n;++i){
            rb[i] = nrb[i-1] + nums[i];
            nrb[i] = Math.max(nrb[i-1], rb[i-1]);
        }
        return Math.max(nrb[n-1], rb[n-1]);
    }
}