class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums)
            xor ^= num;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            int x = xor ^ num;
            if(set.contains(x))
                set.remove(x);
            else
                set.add(x);
        }
        int[] arr = new int[set.size()];
        int i = 0;
        for(int num : set)
            arr[i++] = num;
        return arr;
    }
}
