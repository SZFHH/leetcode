class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int l=0, r=0;
        int[] freq = new int[130];
        int cnt = 0;
        for(int i=0;i<p.length(); i++){
            freq[p.charAt(i)]++;
        }
        
        for(int i='a'; i<='z'; i++) {
            if(freq[i]>0) cnt++;
        }
        int len = p.length();
        int[] curfreq = new int[130];
        int curcnt = 0;
        for(; r<s.length() && r<len; r++){
            char c = s.charAt(r);
            curfreq[c]++;
            if(curfreq[c]==freq[c]) {
                curcnt++;
            } 
            if(freq[c]!=0 && curfreq[c]==freq[c]+1) {
                curcnt--;
            }
        }
        List<Integer> rv = new ArrayList<>();
        if(curcnt==cnt) rv.add(0);
        while(r<s.length()){
            char c = s.charAt(r);
            curfreq[c]++;
            if(curfreq[c] == freq[c]) {
                curcnt++;
            }
            if(freq[c]!=0 && curfreq[c] == freq[c]+1) {
                curcnt--;
            }
            c = s.charAt(l);
            curfreq[c]--;
            if(curfreq[c] == freq[c]-1) {
                curcnt--;
            }
            if(freq[c]!=0 && curfreq[c]==freq[c]) {
                curcnt++;
            }
            l++;
            r++;
            if(cnt==curcnt) {
                rv.add(l);
            }
        }
        return rv;
    }
}