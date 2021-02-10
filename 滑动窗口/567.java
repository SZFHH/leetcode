class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freqexp = new int[130]; int cntexp = 0;
        int[] freq = new int[130]; int cnt=0;
        int l = 0, r = 0;
        int n = s2.length();
        for(int i=0 ;i<s1.length(); i++) {
            freqexp[s1.charAt(i)]++;
        }
        for(int i=0;i<130;++i) {
            if(freqexp[i] > 0) cntexp++;
        }
        while(r < n) {
            char c = s2.charAt(r);
            freq[c]++;
            if(freq[c] == freqexp[c]) {
                cnt++;
            }
            while(freq[c] > freqexp[c]) {
                char cl = s2.charAt(l);
                l++;
                freq[cl]--;
                if(freq[cl] == freqexp[cl]-1) {
                    cnt--;
                }
            }
            r++;
            if(cnt == cntexp) return true;
        }
        return false;
    }
}