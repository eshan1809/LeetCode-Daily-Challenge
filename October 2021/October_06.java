class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int pos = Math.abs(nums[i]) - 1;
            if(nums[pos] > 0)
                nums[pos] = -nums[pos];
            else
                list.add(pos + 1);
        }
        return list;
    }
}
