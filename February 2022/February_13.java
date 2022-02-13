class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, nums.length, new ArrayList<>(), list);
        return list;
    }
    
    private void helper(int[] nums, int idx, int n, List<Integer> al, List<List<Integer>> list){
        if(idx == n){
            list.add(new ArrayList<>(al));
            return;
        }
        helper(nums, idx + 1, n, al, list);
        al.add(nums[idx]);
        helper(nums, idx + 1, n, al, list);
        al.remove(al.size() - 1);
    }
}
