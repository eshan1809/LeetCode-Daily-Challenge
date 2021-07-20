class Solution {
    int[] original, arr;
    Random rand = new Random();
    
    public Solution(int[] nums) {
        original = nums.clone();
        arr = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        arr = original.clone();
        return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        for(int i : arr) list.add(i);
        for(int i = 0; i < arr.length; i++){
            int random = rand.nextInt(list.size());
            arr[i] = list.get(random);
            list.remove(random);
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
