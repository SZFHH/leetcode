class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rv = new int[n];
        int pre = 1;
        rv[n-1] = 1;
        for(int i = n-2; i>=0; i--) {
            rv[i] = nums[i+1] * rv[i+1];
        }
        for(int i=0; i<n; i++) {
            rv[i] = rv[i] * pre;
            pre *= nums[i];
        }
        return rv;
    }
}