class Solution {
    List<List<Integer>> rv = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int cur = 0;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        inner(candidates,0);
        return rv;    
    }

    public void inner(int[] candidates, int st){
        if(cur==target){
            rv.add(new ArrayList<>(temp));
            return;
        }

        if(cur>target) return;
        
        for(int i=st;i<candidates.length;++i){
            cur += candidates[i];
            temp.add(candidates[i]);
            inner(candidates, i+1);
            temp.remove(temp.size()-1);
            cur -= candidates[i];
            while(i+1<candidates.length && candidates[i+1]==candidates[i]) i++;
        }

    }
}