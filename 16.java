class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=Integer.MAX_VALUE;
        int len = nums.length;
        int tt=0;
        Arrays.sort(nums);
        for(int i=0;i<len;++i){
            int k = len-1;
            for(int j=i+1;j<k;){
                int c = nums[i]+nums[j]+nums[k]-target;
                if(c>=0){
                    if(ans>c){
                        ans = c;
                        tt = nums[i]+nums[j]+nums[k];
                    }
                    --k;
                }else if(c<0){
                    if(ans>-c){
                        ans = -c;
                        tt = nums[i]+nums[j]+nums[k];
                    }
                    ++j;
                }
            }
        }
        return tt;
    }
}