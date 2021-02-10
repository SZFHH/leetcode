class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=0;i<k-1;++i){
            insert(q, i, nums, k);
        }
        int l=0, r=k-1;
        int[] res = new int[nums.length-k+1];
        while(r<nums.length) {
            insert(q, r, nums, k);
            res[l] = nums[q.peekFirst()];
            r++;
            l++;
        }
        return res;
    }

    public void insert(LinkedList<Integer> q, int idx, int[] nums, int k){
        int st = idx-k+1;
        if(!q.isEmpty() && q.peekFirst()<st) {
            q.pollFirst();
        }
        while(!q.isEmpty() && nums[q.peekLast()]<=nums[idx]) {
            q.pollLast();
        }
        q.offerLast(idx);
    }
}