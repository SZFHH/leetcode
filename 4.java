class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1,i2;
        int len = nums1.length + nums2.length;
        if(len%2==0){
            i1 = len/2;
            i2 = i1-1;
        }
        else{
            i1 = i2 = len/2;
        }
        double a = findKth(nums1, nums2, 0, 0, i1+1);
        double b = findKth(nums1, nums2, 0, 0, i2+1);
        return (a+b)/2;
    }

    public double findKth(int[] nums1, int[] nums2, int st1, int st2, int k) {
        if (st1 == nums1.length) return nums2[st2 + k - 1];
        if (st2 == nums2.length) return nums1[st1 + k - 1];
        if (k == 1) return Math.min(nums1[st1], nums2[st2]);
        int n1, n2;
        if (st1 + k / 2 - 1 >= nums1.length) n1 = Integer.MAX_VALUE;
        else n1 = nums1[st1 + k / 2 - 1];
        if (st2 + k / 2 - 1 >= nums2.length) n2 = Integer.MAX_VALUE;
        else n2 = nums2[st2 + k / 2 - 1];
        if (n1 < n2) return findKth(nums1, nums2, st1 + k / 2, st2, k - k / 2);
        else return findKth(nums1, nums2, st1, st2 + k / 2, k - k / 2);
    }
}