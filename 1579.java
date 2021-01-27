class Solution {
    int[] f;
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        f = new int[n+1];
        for(int i=0;i<=n;++i) f[i] = i;
        List<Integer> c = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int i = 0; i < edges.length; ++i){
            if(edges[i][0] == 1) {
                a.add(i);
            } else if (edges[i][0] == 2) {
                b.add(i);
            } else {
                c.add(i);
            }
        }
        int cnt = 0;
        for(Integer i: c){
            int u = edges[i][1];
            int v = edges[i][2];
            int ru = find(u), rv = find(v);
            if(ru!=rv){
                f[ru] = rv;
                cnt++;
            }
        }
        if(cnt == n-1) {
            return edges.length - cnt;
        }
        int[] old = Arrays.copyOf(f, f.length);
        int curcnt = cnt;
        for(Integer i: a){
            int u = edges[i][1];
            int v = edges[i][2];
            int ru = find(u), rv = find(v);
            if(ru!=rv){
                f[ru] = rv;
                cnt++;
            }
        }
        if(cnt!=n-1) {
            return -1;
        }
        f = Arrays.copyOf(old,old.length);
        for(Integer i: b){
            int u = edges[i][1];
            int v = edges[i][2];
            int ru = find(u), rv = find(v);
            if(ru!=rv){
                f[ru] = rv;
                cnt++;
                curcnt++;
            }
        }
        if(curcnt!=n-1){
            return -1;
        }
        return edges.length - cnt;

    }
    public int find(int x){
        if(f[x] != x) f[x] = find(f[x]);
        return f[x];
    }
}