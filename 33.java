class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length,mid;
        while(l<r){
            mid = l + (r-l)/2;
            int m = nums[mid];
            if(m==target) return mid;
            
            if(m>nums[l]){
                if(target<m && target>=nums[l]) r = mid;
                else l = mid+1;
            }else{
                if(target>nums[r-1] || target<m) r = mid;
                else l=mid+1;
            }
        }
        return -1;
    }
}