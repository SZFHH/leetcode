class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> rv = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        inner(n,n,rv,sb);
        return rv;
    }

    public void inner(int left, int right, List<String> s, StringBuilder sb){
        if(left==0 && right==0){
            s.add(sb.toString());
            return;
        }
        if(right<left) return;
if(right>0){
            sb.append(')');
            inner(left,right-1,s,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(left>0){
            sb.append('(');
            inner(left-1, right, s, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        
    }
}