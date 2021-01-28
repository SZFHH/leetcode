class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] a = new int[105];
        for(int i=0;i<dominoes.length;++i){
            if(dominoes[i][0]>dominoes[i][1]){
                a[dominoes[i][0]*10 + dominoes[i][1]]++;
            } else {
                a[dominoes[i][1]*10 + dominoes[i][0]]++;
            }
        }
        int ans = 0;
        for(int i=0;i<105;++i){
            ans += a[i]*(a[i]-1)/2;
        }
        return ans;
    }
}
