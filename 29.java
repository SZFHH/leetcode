class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        boolean f = (dividend<0 && divisor>0) || (dividend>0 && divisor<0);
        if(dividend>0) dividend=-dividend;
        if(divisor>0) divisor=-divisor;
        int ans = 0,cur = divisor,k = -1;
        while(dividend<=divisor){
            if(dividend<=cur){
                dividend -= cur;
                ans += k;
                k += k;
                cur += cur;  
            }else{
                cur = cur>>1;
                k = k>>1;
            }
        }
        if(!f) ans *= -1;
        return ans; 
    }
}