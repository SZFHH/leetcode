class Solution {
    public int characterReplacement(String s, int k) {
        int[] a = new int[26];
        int st=0,ed=0;
        int maxcnt = -1;
        for(;ed<s.length();++ed) {
            a[s.charAt(ed)-'A']++;
            maxcnt = Math.max(maxcnt,  a[s.charAt(ed)-'A']);
            if(ed-st+1-maxcnt > k) {
                a[s.charAt(st)-'A']--;
                ++st;
            }
        }
        return ed - st;
    }
}