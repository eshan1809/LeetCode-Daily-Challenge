class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0, idx = 0;
        long val = 1l;
        while(val <= n){
            if(idx < nums.length && nums[idx] <= val)
                val += nums[idx++];
            else{
                count++;
                val *= 2;
            }
        }
        return count;
    }
}
