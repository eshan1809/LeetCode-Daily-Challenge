class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[n], minRight = new int[n];
        maxLeft[0] = nums[0];
        for(int i = 1; i < n; i++)
            maxLeft[i] = Math.max(nums[i], maxLeft[i - 1]);
        minRight[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--)
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        for(int i = 1; i < n; i++)
            if(maxLeft[i - 1] <= minRight[i])
                return i;
        return n;
    }
}
