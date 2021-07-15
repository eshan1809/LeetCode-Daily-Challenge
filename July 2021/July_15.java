class Solution {
    public boolean isValid(int a, int b, int c){
        if(a == 0 || b == 0 || c == 0) return false;
        return a + b > c;
    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, count = 0;
        for(int i = 0; i < n - 2; i++)
            for(int j = i + 1; j < n - 1; j++){
                int k = n - 1;
                while(!isValid(nums[i], nums[j], nums[k]) && k > j) k--;
                count += k - j;
            }
                
        return count;
    }
}
