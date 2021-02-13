class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        LinkedList<String> q = new LinkedList<>();
        q.offer(s);
        List<String> rv = new ArrayList<>();
        int len = s.length() + 1;
        while(!q.isEmpty()) {
            String cur = q.poll();
            if(cur.length()+len<s.length()) break;
            if(isok(cur)) {
                len = s.length() - cur.length();
                rv.add(cur);
            }
            for(int i=0; i<cur.length(); i++) {
                if(s.charAt(i)!='(' && s.charAt(i)!=')') continue;
                String news = cur.substring(0, i) + cur.substring(i+1);
                if(set.contains(news)) continue;
                set.add(news);
                q.offer(news);
            }
        }
        return rv;
    }

    public boolean isok(String s) {
        int l = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                l++;
            } else if(s.charAt(i)==')') {
                if(l==0) return false;
                else l--;
            }
        }
        return l==0;
    }
}