class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int pre = 0;
        mp.put(0, 1);
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            pre += nums[i];
            Integer c = mp.get(pre-k);
            if(c!=null) res+=c;
            mp.put(pre, mp.getOrDefault(pre, 0)+1);
        }
        return res;
    }
}