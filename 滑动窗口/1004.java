class Solution {
    public int longestOnes(int[] A, int K) {
        int l=0, r = 0, res=0, cnt=0;
        while(r<A.length) {
            if(A[r]==0) cnt++;
            while(cnt>K) {
                if(A[l]==0) cnt--;
                l++;
            }
            r++;
            res = Math.max(res, r-l);
        }
        return res;
    }
}