class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        list = new ArrayList<>();
        helper(candidates, candidates.length - 1, target, new ArrayList<>());
        return list;
    }
    
    List<List<Integer>> list;
    
    private void helper(int[] candidates, int id, int target, List<Integer> al){
        if(target == 0){
            list.add(new ArrayList<>(al));
            return;
        }
        if(target < 0 || id == -1)
            return;
        
        helper(candidates, id - 1, target, al);
        
        if(candidates[id] <= target){
            al.add(candidates[id]);
            helper(candidates, id, target - candidates[id], al);
            al.remove(al.size() - 1);
        }
    }
}
