class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        boolean last = false;
        int l = 0, r = 1, res = 1;
        while(r < n) {
            if(arr[r] == arr[r-1]) {
                l = r;
                r++;
                continue;
            }
            if(r > l+1 && arr[r-1] < arr[r] == last) {
                l = r-1;
            }
            last = arr[r-1] < arr[r];
            r++;
            res = Math.max(r - l, res);
        }
        return res;
    }
    
}