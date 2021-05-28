class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] prefSum = new int[n];
        prefSum[0] = nums[0];
        for(int i = 1; i < n; i++) prefSum[i] = prefSum[i - 1] + nums[i];
        HashMap<Integer, Integer> map = new HashMap<>();
        int front = -1, back = 0, ans = 0;
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i]) && map.get(nums[i]) > front){
                ans = front == -1 ? prefSum[back] : Math.max(ans, prefSum[back] - prefSum[front]);
                front = map.get(nums[i]);
            }
            map.put(nums[i], i);
            back = i;
        }
        ans = front == -1 ? prefSum[back] : Math.max(ans, prefSum[back] - prefSum[front]);
        return ans;
    }
}
