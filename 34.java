class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length,mid;
        int[] rv = new int[]{-1,-1};
        while(l<r){
            mid = l + (r-l)/2;
            if(target<=nums[mid]) r = mid;
            else l = mid+1;
        }
        if(l<nums.length && nums[l]==target) rv[0] = l;

        l=0;r=nums.length;
        while(l<r){
            mid = l + (r-l)/2;
            if(target<nums[mid]) r = mid;
            else l = mid+1;
        }
        if(l>0 && nums[l-1]==target) rv[1] = l-1;
        return rv;

    }
}