class Solution {
    public void getSubsets(int[] nums, Set<List<Integer>> set, List<Integer> list, int idx){
        if(idx == nums.length){
            set.add(new ArrayList<Integer>(list));
            return;
        }
        getSubsets(nums, set, list, idx + 1);
        list.add(nums[idx]);
        getSubsets(nums, set, list, idx + 1);
        list.remove(list.size() - 1);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        getSubsets(nums, set, new ArrayList<Integer>(), 0);
        return new ArrayList<>(set);
    }
}
