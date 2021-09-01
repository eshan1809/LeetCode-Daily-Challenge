class Solution {
    public int arrayNestingHelper(int[] nums, boolean[] b, int count, int start){
        b[start] = true;
        start = nums[start];
        return b[start] ? count : arrayNestingHelper(nums, b, count+1, start);
    }
    
    public int arrayNesting(int[] nums) {
        if(nums.length == 1)
            return 1;
        boolean[] b = new boolean[nums.length];
        int max = 1;
        for(int i = 0; i < nums.length; i++)
            if(!b[i])
                max = Math.max(max, arrayNestingHelper(nums, b, 1, i));
        return max;
    }
}
