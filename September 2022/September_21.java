class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int sum = 0;
        for(int j = 0; j < nums.length; j++){
            if((nums[j] & 1) == 0){
                sum += nums[j];
            }
        }
        for(int i = 0; i < queries.length; i++){
            if((nums[queries[i][1]] & 1) == 0)
                sum -= nums[queries[i][1]];
            nums[queries[i][1]] += queries[i][0];
            if((nums[queries[i][1]] & 1) == 0)
                sum += nums[queries[i][1]];
            ans[i] = sum;
        }
        return ans;
    }
}
