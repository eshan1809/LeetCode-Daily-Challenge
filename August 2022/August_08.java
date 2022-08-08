class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int val : nums){
            int idx = upper_bound(list, val);
            if(idx == list.size())
                list.add(val);
            else
                list.set(idx, val);
        }
        return list.size();
    }
    
    private int upper_bound(List<Integer> list, int val){
        int ans = list.size(), lo = 0, hi = ans - 1;
        while(lo <= hi){
            int mid = (lo + hi) >> 1;
            if(list.get(mid) >= val){
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }
}
