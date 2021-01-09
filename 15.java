class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rv = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len;++i){
            int k = len-1;
            for(int j=i+1;j<k;){
               int c = nums[i]+nums[j]+nums[k];
               if(c<0){
                   ++j;
               }else if(c>0){
                   --k;
               }else{
                   rv.add(Arrays.asList(nums[i], nums[j], nums[k]));
                   while(j+1<len && nums[j+1]==nums[j]) ++j;
                   ++j;--k;
               }
            }
            while(i+1<len && nums[i+1]==nums[i]) ++i;
        }
        return rv;

    }
}