class Solution {
    public int[] countBits(int num) {
        int[] rv = new int[num+1];
        int cnt = 1;
        int cur = 1;
        while(cnt<=num) {
            for(int i=0; cnt<=num && i<cur; i++,cnt++){
                rv[cnt] = rv[i]+1;
            }
            cur *= 2;
        }
        return rv;
        
    }
}