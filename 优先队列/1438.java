class Solution {
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> maxq = new LinkedList<>();
        LinkedList<Integer> minq = new LinkedList<>();
        int l=0, r=0, res=0;
        while(r<nums.length) {
            while(!maxq.isEmpty() && nums[maxq.peekLast()]<nums[r]) {
                maxq.pollLast();
            }
            maxq.offerLast(r);
            while(!minq.isEmpty() && nums[minq.peekLast()] > nums[r]) {
                minq.pollLast();
            }
            minq.offerLast(r);
            while(!minq.isEmpty() && !maxq.isEmpty() 
                    && nums[maxq.peekFirst()]-nums[minq.peekFirst()]>limit) {
                if(minq.peekFirst()==l) {
                    minq.pollFirst();
                }
                if(maxq.peekFirst()==l) {
                    maxq.pollFirst();
                }
                l++;
            }
            r++;
            res = Math.max(res, r-l);
        }
        return res;
    }
}