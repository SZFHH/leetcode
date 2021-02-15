class Solution {
    public int countSubstrings(String s) {
        int res=0;
        for(int i=0; i<s.length();i++){
            for(int len=0; i+len<s.length() && i-len>=0; len++) {
                if(s.charAt(i+len)==s.charAt(i-len)) {
                    res++;
                } else {
                    break;
                }
            }
        }
        for(int i=0; i<s.length();i++){
            for(int len=0; i+len+1<s.length() && i-len>=0; len++) {
                if(s.charAt(i+len+1)==s.charAt(i-len)) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}