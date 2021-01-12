class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i=0;i<n;++i){
            if(group[i]==-1){
                group[i] = m;
                m++;
            }
        }
        List<Integer>[] groupAdj = new ArrayList[m];
        List<Integer>[] itemAdj = new ArrayList[n];
        int[] itemdgr = new int[n];
        int[] grpdgr = new int[m];
        for(int i=0;i<m;++i) groupAdj[i] = new ArrayList();
        for(int i=0;i<n;++i) itemAdj[i] = new ArrayList();
        for(int i=0;i<n;++i){
            int g = group[i];
            for(int j:beforeItems.get(i)){
                itemAdj[j].add(i);
                itemdgr[i]++;
                int fg = group[j];
                if(fg!=g){
                    groupAdj[fg].add(g);
                    grpdgr[g]++;
                }
            }
        }
        List<Integer> grpList = topo(grpdgr, groupAdj);
        List<Integer> itemList = topo(itemdgr, itemAdj);
        if(grpList==null || itemList==null){
            return new int[0];
        }
        Map<Integer, List<Integer>> groups2Items = new HashMap<>();
        for (Integer item : itemList) {
            groups2Items.computeIfAbsent(group[item], key -> new ArrayList<>()).add(item);
        }

        List<Integer> res = new ArrayList<>();
        for (Integer groupId : grpList) {
            List<Integer> items = groups2Items.getOrDefault(groupId, new ArrayList<>());
            res.addAll(items);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();

    
    }

    public List<Integer> topo(int[] cnt, List<Integer>[] adj){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> rv = new ArrayList<>();
        int n = cnt.length;
        for(int i=0;i<n;++i){
            if(cnt[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int t = q.poll();
            rv.add(t);
            for(Integer k:adj[t]){
                cnt[k]--;
                if(cnt[k]==0) q.offer(k);
            }
        }
        if(rv.size()!=n) return null;
        return rv;
    }
}