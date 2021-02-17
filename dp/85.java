class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[] h = new int[m], l = new int[m], r = new int[m];
        int rv = -1;
        Arrays.fill(r, m-1);
        for(int i=0; i<n; ++i){
            int ll = 0, rr = m - 1;
            for(int j=0;j<m;++j){
                if(matrix[i][j]=='0') h[j]=0;
                else h[j]++;
            }

            for(int j=0; j<m; j++){
                if(matrix[i][j]=='0'){
                    ll = j + 1;
                    l[j] = 0;
                } else {
                    l[j] = Math.max(l[j], ll);
                }
            }

            for(int j=m-1;j>=0;--j){
                if(matrix[i][j] == '0'){
                    rr = j-1;
                    r[j] = m-1;
                } else {
                    r[j] = Math.min(r[j], rr);
                }
            }

            for(int j=0;j<m;++j){
                rv = Math.max(rv, h[j]*(r[j]-l[j]+1));
            }
        }
        return rv;
    }
}