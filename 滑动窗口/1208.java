class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0, r = 0;
        int res = 0, curCost = 0;
        int n = s.length();
        while(r < n) {
            curCost += Math.abs(s.charAt(r) - t.charAt(r));
            r++;
            while(curCost > maxCost) {
                curCost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            res = Math.max(r-l, res);
        }
        return res;
    }
}