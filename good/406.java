class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2)->{
            if(o1[0]!=o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });
        int n = people.length, m = people[0].length;
        int[][] rv = new int[n][];
        for(int[] p: people) {
            int pos = findkth(rv, p[1]);
            rv[pos] = p;
        }
        return rv;
    }

    public int findkth(int[][] rv, int k) {
        int cnt = -1;
        for(int i=0; i<rv.length; i++) {
            if(rv[i]==null) cnt++;
            if(cnt == k) return i;
        }
        return -1;
    }
}