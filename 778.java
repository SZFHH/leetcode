class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] v  = new boolean[n][n];
        int[][] dis = new int[n][n];
        for(int[] d:dis){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> dis[o[0]][o[1]]));
        dis[0][0] = grid[0][0];
        int[] cur;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        q.offer(new int[]{0, 0});
        while(!q.isEmpty()){
            cur = q.poll();
            int curi = cur[0], curj=cur[1];
            if(v[curi][curj]) {
                continue;
            }
            v[curi][curj] = true;
            for (int[] direction : directions) {
                int newi = curi + direction[0];
                int newj = curj + direction[1];
                if (inArea(newi, newj, n) && !v[newi][newj]
                        && dis[newi][newj] > Math.max(dis[curi][curj], grid[newi][newj])) {
                    dis[newi][newj] = Math.max(dis[curi][curj], grid[newi][newj]);
                    q.offer(new int[]{newi, newj});
                }
            }
        }
        return dis[n-1][n-1];
    }
    public boolean inArea(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

}