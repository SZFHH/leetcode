class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int n: nums) {
            set.add(n);
        }
        int res = 0;
        for(int n: nums) {
            if(!set.contains(n-1)) {
                int cur = n;
                int len = 1;
                while(set.contains(cur+1)) {
                    cur++;
                    len++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}