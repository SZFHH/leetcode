class Solution {
    int[] f;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        f = new int[n];
        for(int i=0;i<n;++i) f[i] = i;
        for(List<Integer> p: pairs) u(p.get(0), p.get(1));
        List<Character>[] arr = new List[n];
        int r;
        for(int i=0;i<n;++i){
            r = find(i);
            if(arr[r]==null){
                arr[r] = new ArrayList<>();
            }
            arr[r].add(s.charAt(i));
        }
        for(List<Character> list: arr){
            if(list!=null)
                list.sort(new Comparator<Character>(){
                    public int compare(Character o1, Character o2){
                        return o2-o1;
                    }
                });
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;++i){
            r = find(i);
            List<Character> list = arr[r];
            sb.append(list.remove(list.size()-1));
        }
        return sb.toString();
    }

    public int find(int x){
        if(f[x]!=x) f[x] = find(f[x]);
        return f[x];
    }

    public void u(int x, int y){
        int rx = find(x), ry = find(y);
        if(rx!=ry) f[rx]=ry;
    }
}