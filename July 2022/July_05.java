class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums)
            set.add(i);
        int ans = 0;
        for(int i : nums){
            if(!set.contains(i - 1)){
                int curr = 0, j = i;
                while(set.contains(j)){
                    j++;
                    curr++;
                }
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
}
