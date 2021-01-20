class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1,j=i;
        while(i-1>=0 && nums[i-1]>=nums[i]) --i;
        if(i>0){
            while(nums[j]<=nums[i-1]) --j;
            int temp = nums[i-1];
            nums[i-1] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, i, nums.length-1);

    }

    public void reverse(int[] a, int l, int r){
        int m = (l+r)/2;
        for(int i=l;i<=m;++i){
            int temp = a[i];
            a[i] = a[l+r-i];
            a[l+r-i] = temp;
        }
    }
}