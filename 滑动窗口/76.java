class Solution {
    public String minWindow(String s, String t) {
        int[] a = new int[130],b = new int[130];
        int cnt=0;
        for(int i=0;i<t.length();++i){
            a[t.charAt(i)]++;
        }
        for(int i=0;i<130;++i) if(a[i]>0) ++cnt;
        int l=0,r=0,curcnt=0;
        int c;
        int cntres=1000000;
        String res = "";
        while(r<s.length()){
            c = s.charAt(r);
            b[c]++;
            if(a[c]==b[c]) curcnt++;
            while(curcnt==cnt) {
                if(r-l+1 < cntres) {
                    cntres = r-l+1;
                    res = s.substring(l, r+1);
                }
                c = s.charAt(l);
                b[c]--;
                if(b[c]==a[c]-1) {
                    curcnt--;
                }
                l++;
            }
            r++;
        }
        return res;
    }
}