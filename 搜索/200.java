class Solution {
    boolean[][] v;
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, 1, 0, -1};
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int n = grid.length, m = grid[0].length;
        v = new boolean[n][m];
        for(int i=0;i<n;++i){
            Arrays.fill(v[i], false);
        }
        int res = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]=='1' && !v[i][j]){
                    res++;
                    dfs(i, j, n, m);
                }
            }
        }
        return res;
    }

    public void dfs(int r, int c, int n, int m) {
        v[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = dr[i]+r;
            int nc = dc[i]+c;
            if(isok(nr, nc, n, m) && grid[nr][nc]=='1' && !v[nr][nc]) {
                dfs(nr, nc, n, m);
            }
        }
    }

    public boolean isok(int r, int c, int n, int m) {
        return r>=0 && r<n && c>=0 && c<m;
    }
}