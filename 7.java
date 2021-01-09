class Solution {
    public int reverse(int x) {
        int rv = 0;
        while(x!=0){
            if(rv<Integer.MIN_VALUE/10) return 0;
            if(rv>Integer.MAX_VALUE/10) return 0;
            rv = rv*10 + x%10;
            x /= 10;
        }
        return rv;
    }
}