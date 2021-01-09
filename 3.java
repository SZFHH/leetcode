class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a[] = new int[130];
        for(int i=0;i<130;++i)
            a[i] = -1;
        int l=0,r=0,ans=-1;
        for(r=0;r<s.length();++r){
            char c = s.charAt(r);
            if(a[c]>=l){
                ans = Math.max(ans, r-l);
                l = a[c]+1;
            }
            a[c] = r;
        }
        ans = Math.max(ans, r-l);
        return ans;
    }
}