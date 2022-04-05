class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int[] left = new int[n], right = new int[n];
        
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int idx = find(list, height[i]);
            if(idx == list.size())
                list.add(new int[]{height[i], i});
            left[i] = list.get(idx)[1];
        }
        
        list.clear();
        for(int i = n - 1; i >= 0; i--){
            int idx = find(list, height[i]);
            if(idx == list.size())
                list.add(new int[]{height[i], i});
            right[i] = list.get(idx)[1];
        }
        
        int area = 0;
        for(int i = 0; i < n; i++)
            area = Math.max(area, height[i] * (right[i] - left[i]));
        
        return area;
    }
    
    private int find(List<int[]> list, int val){
        int ans = list.size(), lo = 0, hi = ans - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(list.get(mid)[0] < val)
                lo = mid + 1;
            else{
                ans = mid;
                hi = mid - 1;
            }
        }
        return ans;
    }
}
