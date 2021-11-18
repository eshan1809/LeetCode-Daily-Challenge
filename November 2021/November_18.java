class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            temp[nums[i] - 1] = 1;
        List<Integer> al = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++)
            if(temp[i] == 0)
                al.add(i + 1);
        return al;
    }
}
