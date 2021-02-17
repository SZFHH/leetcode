class Solution {
    public boolean isMatch(String s, String p) {
        return inner(s,p,0,0);
    }
    public boolean inner(String s, String p, int st1, int st2){
        int sn = s.length();
        int pn = p.length();
        if(st1==sn && st2==pn) return true;
        isf(t2==pn && st1<sn) return false;
        if(st2<pn && st1==sn){
            return st2+1<pn && p.charAt(st2+1)=='*' && inner(s,p,st1,st2+2);
        }else{
            if(st2+1<pn && p.charAt(st2+1)=='*'){
                if(s.charAt(st1)==p.charAt(st2) || p.charAt(st2)=='.'){
                    return inner(s,p,st1,st2+2) || inner(s,p,st1+1,st2);
                }else{
                    return inner(s,p,st1,st2+2);
                }
            }else{
                if(s.charAt(st1)==p.charAt(st2) || p.charAt(st2)=='.'){
                    return inner(s,p,st1+1,st2+1);
                }else{
                    return false;
                }
            }
        }
    }
}