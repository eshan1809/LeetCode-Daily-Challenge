class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>();
        helper(1, k, n, new ArrayList<>());
        return list;
    }
    
    List<List<Integer>> list;
    
    private void helper(int num, int k, int sum, List<Integer> al){
        if(num == 10){
            if(sum == 0 && k == 0)
                list.add(new ArrayList<>(al));
            return;
        }
        
        if(num <= sum && k > 0){
            al.add(num);
            helper(num + 1, k - 1, sum - num, al);
            al.remove(al.size() - 1);
        }
        
        helper(num + 1, k, sum, al);
    }
}
