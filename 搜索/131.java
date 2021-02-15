class Solution {
    List<List<String>> rv = new ArrayList<>();
    List<String> tmpss = new ArrayList<>();
    String s;
    boolean[][] isok;
    public List<List<String>> partition(String s) {
        this.s = s;
        isok = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            for(int len=0; i-len>=0&&i+len<s.length();len++) {
                if(s.charAt(i-len)==s.charAt(i+len)) {
                    isok[i-len][i+len] = true;
                } else{
                    break;
                }
            }
        }
        for(int i=0; i<s.length(); i++){
            for(int len=0; i-len>=0&&i+len+1<s.length();len++) {
                if(s.charAt(i-len)==s.charAt(1+i+len)) {
                    isok[i-len][1+i+len] = true;
                } else{
                    break;
                }
            }
        }
        
        dfs(0);
        return rv;
    }

    public void dfs(int st) {
        if(st==s.length()) {
            rv.add(new ArrayList<String>(tmpss));
            return;
        }
        
        for(int i=st; i<s.length(); i++) {
            if(!isok[st][i]) continue;
            tmpss.add(s.substring(st, i+1));
            dfs(i+1);
            tmpss.remove(tmpss.size()-1);
        }
    }
}