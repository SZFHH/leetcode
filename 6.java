class Solution {
   public String convert(String s, int numRows) {
       if(numRows==1) return s;
        StringBuilder ss[] = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            ss[i] = new StringBuilder();
        }
        int k = 0, add = 1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            ss[k].append(c);
            k += add;
            if (k == numRows - 1 || k == 0) add = -add;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder sbb : ss) {
            
            sb.append(sbb);
            
        }
        return sb.toString();
    }
}