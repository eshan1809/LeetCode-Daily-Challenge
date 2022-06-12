class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, max = 0, j = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            while(set.contains(nums[i])){
                sum -= nums[j];
                set.remove(nums[j++]);
            }
            sum += nums[i];
            set.add(nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
