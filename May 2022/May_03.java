class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int i = 0, j = nums.length - 1;
        while (i <= j && nums[i] == sorted[i])
            i++;
        while(j >= i && nums[j] == sorted[j])
            j--;
        return j - i + 1;
    }
}
