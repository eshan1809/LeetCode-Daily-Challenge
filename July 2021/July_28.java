class Solution {
    public int[] beautifulArray(int n){
        Map<Integer, int[]> map = new HashMap();
        return helper(n, map);
    }

    public int[] helper(int n, Map<Integer, int[]> map){
        if (map.containsKey(n))
            return map.get(n);
        int[] ans = new int[n];
        if(n == 1){
            ans[0] = 1;
        } else{
            int i = 0;
            for(int x: helper((n + 1) / 2, map))
                ans[i++] = 2 * x - 1;
            for(int x: helper(n / 2, map))
                ans[i++] = 2 * x;
        }
        map.put(n, ans);
        return ans;
    }
}
