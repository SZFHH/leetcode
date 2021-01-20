class Solution {
    List<List<Integer>> rv = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int cur=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        inner(candidates, target, 0);
        return rv;
    }

    public void inner(int[] candidates, int target, int c){
        if(cur==target){
            rv.add(new ArrayList<>(temp));
            return;
        }
        if(cur>target) return;
        for(int i = c;i<candidates.length;++i){
            cur += candidates[i];
            temp.add(candidates[i]);
            inner(candidates, target, i);
            cur -= candidates[i];
            temp.remove(temp.size()-1);
        }
        
    }
}