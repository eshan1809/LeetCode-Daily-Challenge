class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] all = new int[nums.length], ans = new int[2];
        for(int i: nums) all[i-1]++;
        for(int i=0; i<all.length; i++){
            if(all[i] == 0) ans[1] = i+1;
            else if(all[i] == 2) ans[0] = i+1;
        }
        return ans;
    }
}
