class NumArray {
    int[] nums, prevSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        prevSum = new int[nums.length];
        prevSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            prevSum[i] = prevSum[i - 1] + nums[i];
    }
    
    public int sumRange(int left, int right) {
        if(left == 0)
            return prevSum[right];
        return
            prevSum[right] - prevSum[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
