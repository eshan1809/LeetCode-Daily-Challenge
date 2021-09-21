class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, currCount = 0;
        for(int i : nums){
            if(i == 0){
                maxCount = Math.max(maxCount, currCount);
                currCount = 0;
            } else
                currCount++;
        }
        return Math.max(maxCount, currCount);
    }
}
