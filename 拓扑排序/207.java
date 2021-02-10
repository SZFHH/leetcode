class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int d[] = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }

        for(int[] c: prerequisites){
            d[c[0]]++;
            edges.get(c[1]).add(c[0]);
        }
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(d[i]==0) {
                q.offer(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            int a = q.poll();
            cnt++;
            for(int i: edges.get(a)) {
                d[i]--;
                if(d[i]==0) {
                    q.offer(i);
                }
            }
        }
        return cnt==numCourses;
    }
}