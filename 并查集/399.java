class Solution {
    int[] f;
    double[] w;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> mp = new HashMap<>();
        int cnt = 0;
        for(List<String> pair: equations) {
            if(!mp.containsKey(pair.get(0))) {
                mp.put(pair.get(0), cnt++);
            }
            if(!mp.containsKey(pair.get(1))) {
                mp.put(pair.get(1), cnt++);
            }
        }
        f = new int[cnt];
        w = new double[cnt];
        Arrays.fill(w, 1.0);
        for(int i=0; i<cnt; i++) {
            f[i] = i;
        }
        for(int i=0; i<values.length; i++) {
            List<String> pair = equations.get(i);
            int idx1 = mp.get(pair.get(0));
            int idx2 = mp.get(pair.get(1));
            union(idx1, idx2, values[i]);
        }
        double[] rv = new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            List<String> query = queries.get(i);
            Integer idx1 = mp.get(query.get(0));
            Integer idx2 = mp.get(query.get(1));
            double result = -1.0;
            if(idx1!=null && idx2!=null) {
                int f1 = find(idx1);
                int f2 = find(idx2);
                if(f1==f2) {
                    result = w[idx1] / w[idx2];
                }
            }
            rv[i] = result;
        }
        return rv;


    }

    public int find(int x) {
        if(f[x] != x) {
            int fa = find(f[x]);
            w[x] *= w[f[x]];
            f[x] = fa;
        }
        return f[x];
    }

    public void union(int x, int y, double val) {
        int fx = find(x);
        int fy = find(y);
        if(fx!=fy) {
            f[fx] = fy;
            w[fx] = w[y] * val / w[x];
        }
    }
}