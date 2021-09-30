class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k == 1)
            return true;
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % k != 0)
            return false;
        int[] spaces = new int[k];
        Arrays.sort(nums);
        return helper(0, nums, 0, k, spaces, sum / k);
    }
    
    public boolean helper(int s, int[] nums, int e, int k, int[] spaces, int ssum){
        if(s == nums.length)
            return true;
        
        for(int i = 0; i < e; i++)
            if(spaces[i] + nums[s] <= ssum){
                spaces[i] += nums[s];
                if(helper(s + 1, nums, e, k, spaces, ssum)) 
                    return true;
                spaces[i] -= nums[s];
            }
            
        if(e < k && nums[s] <= ssum){
            spaces[e] += nums[s];
            if(helper(s + 1, nums, e + 1, k, spaces, ssum))
                return true;
            spaces[e] -= nums[s];
        }
        
        return false;
    }
}
