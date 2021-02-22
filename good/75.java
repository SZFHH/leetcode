class Solution {
    public void sortColors(int[] nums) {
        int l=0,r=nums.length-1,cur=0;
        while(cur<=r){
            if(nums[cur]==0) swap(nums, cur++, l++);
            else if(nums[cur]==2) swap(nums, cur, r--);
            else cur++;
        }
    }

    public void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}