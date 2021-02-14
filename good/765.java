class Solution {
    List<List<Integer>> edges;
    boolean[] v;
    public int minSwapsCouples(int[] row) {
        edges = new ArrayList<>();
        int n = row.length;
        v = new boolean[n/2];
        for(int i=0; i<n/2; i++) {
            edges.add(new ArrayList<>());
        }
        for(int i=0; i<n; i+=2) {
            edges.get(row[i]/2).add(row[i+1]/2);
            edges.get(row[i+1]/2).add(row[i]/2);
        }
        int res = 0;
        for(int i=0; i<n/2; i++){
            if(!v[i]) {
                res += dfs(i)-1;
            }
        }
        return res;
    }
    public int dfs(int u) {
        v[u] = true;
        int rv = 1;
        for(Integer vv: edges.get(u)) {
            if(!v[vv]) {
                rv += dfs(vv);
            }
        }
        return rv;
    }
}