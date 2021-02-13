class Solution {
    public int idx = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String t = null;
        while(idx<s.length() && s.charAt(idx)!=']') {
            int num = 0;
            if(Character.isDigit(s.charAt(idx))) {
                num = getnum(s);
                t = inner(s);
            } else {
                num=1;
                t = gets(s);
            }
            for(int i=0;i<num;i++) {
                sb.append(t);
            }
        }
        return sb.toString();
    }
    public String inner(String s) {
        idx++;
        String rv = decodeString(s);
        idx++;
        return rv;
    }
    public int getnum(String s) {
        int num=0;
        while(Character.isDigit(s.charAt(idx))) {
            num = num*10 + s.charAt(idx)-'0';
            idx++;
        }
        return num;
    }
    public String gets(String s){
        StringBuilder isb = new StringBuilder();
        while(idx<s.length() && Character.isLetter(s.charAt(idx))) {
            isb.append(s.charAt(idx));
            idx++;
        }
        return isb.toString();
    }
}