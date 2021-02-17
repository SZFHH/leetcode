class Solution {
    public int longestValidParentheses(String s) {
        int rv = 0, l = 0, r = 0;
        int cur = 0;
        for(;r<s.length();++r){
            char c = s.charAt(r);
            if(c=='(') cur++;
            else cur--;
            if(cur==0) rv = Math.max(rv, r-l+1);
            if(cur<0){ cur = 0; l = r+1;
            }
        }
        cur = 0;l=s.length()-1;r=s.length()-1;
        for(;l>=0;--l){
            char c = s.charAt(l);
            if(c==')') cur++;
            else cur--;
            if(cur==0) rv = Math.max(rv, r-l+1);
            if(cur<0){
                cur = 0;
                r = l-1;
            }
        }
        return rv;
    }
}