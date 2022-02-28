class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        if(n == 0)
            return list;
        int beg = nums[0], prev = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] == prev + 1)
                prev = nums[i];
            else{
                if(beg != prev)
                    list.add(beg + "->" + prev);
                else
                    list.add(beg + "");
                beg = prev = nums[i];
            }
        }
        if(beg != prev)
            list.add(beg + "->" + prev);
        else
            list.add(beg + "");
        return list;
    }
}
