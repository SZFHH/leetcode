class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        k = n - k;
        int l = 0, r = k;
        int res = 0, cur = 0;
        for(int i = 0; i < r; i++) {
            cur += cardPoints[i];
        }
        res = cur;
        while(r < n) {
            cur += cardPoints[r];
            cur -= cardPoints[l];
            ++r;
            ++l;
            res = Math.min(res, cur);
        }
        return Arrays.stream(cardPoints).sum() - res;
    }
}