class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return maxk(A, K) - maxk(A, K-1);
    }

    public int maxk(int[] a, int k) {
        int n = a.length;
        int le = 0, r = 0;
        int res = 0, cnt = 0;
        int[] freq = new int[n+1];
        while(r < n) {
            freq[a[r]]++;
            if(freq[a[r]] == 1) {
                cnt ++;
            }
            r++;
            while(cnt > k) {
                freq[a[le]]--;
                if(freq[a[le]] == 0) {
                    cnt--;
                }
                le++;
            }
            res += r-le;
        }
        return res;
    }
}