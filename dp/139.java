class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i=1; i<=s.length(); i++) {
            for(String word: wordDict) {
                int len = word.length();
                if(i >= len) {
                    String t = s.substring(i-len, i);
                    dp[i] = dp[i] || (dp[i-len] && word.equals(t));
                }
            }
        }
        return dp[s.length()];
    }
}