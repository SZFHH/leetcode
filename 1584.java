class Solution {
    int[] f = new int[1005];
    public int minCostConnectPoints(int[][] points) {
        for(int i=0;i<1005;++i) f[i] = i;
        Edge[] es = new Edge[1000000];
        int cnt=0;
        for(int i=0;i<points.length;++i){
            for(int j=i+1;j<points.length;++j){
                es[cnt++] = new Edge(i,j,points);
            }
        }
        Arrays.sort(es, 0, cnt);
        int ans = 0;
        int k = 0;
        for(int i=0;i<cnt;++i){
            int i1 = es[i].i1;
            int i2 = es[i].i2;
            int i1r = find(i1);
            int i2r = find(i2);
            if(i1r!=i2r){
                f[i1r] = i2r;
                ans += es[i].e;
                ++k;
                if(k==points.length-1) break;
            }
        }
        return ans;

    }
    public int find(int x){
        if(f[x]!=x) f[x] = find(f[x]);
        return f[x];
    }
}

class Edge implements Comparable<Edge>{
    public int i1,i2,e;
    public int compareTo(Edge edge){
        return e-edge.e;
    }
    public Edge(int i1, int i2, int[][] points){
        this.i1 = i1;
        this.i2 = i2;
        e = Math.abs(points[i1][0]-points[i2][0]) + Math.abs(points[i1][1]-points[i2][1]);
    }
}
