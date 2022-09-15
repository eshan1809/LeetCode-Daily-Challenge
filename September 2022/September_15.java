class Solution {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : changed)
            map.put(i, map.getOrDefault(i, 0) + 1);
        int n = changed.length;
        if((n & 1) == 1)
            return new int[0];
        int[] ans = new int[n / 2];
        int j = 0;
        Arrays.sort(changed);
        for(int i = 0; i < n; i++){
            if(map.containsKey(changed[i]) && map.containsKey(2 * changed[i])){
                if(changed[i] == 0){
                    if(map.get(0) > 2){
                        map.put(0, map.get(0) - 2);
                        ans[j++] = 0;
                    } else if(map.get(0) == 2){
                        map.remove(0);
                        ans[j++] = 0;
                    }
                } else{
                    if(map.get(changed[i]) == 1)
                        map.remove(changed[i]);
                    else
                        map.put(changed[i], map.get(changed[i]) - 1);
                    if(map.get(2 * changed[i]) == 1)
                        map.remove(2 * changed[i]);
                    else
                        map.put(2 * changed[i], map.get(2 * changed[i]) - 1);
                    ans[j++] = changed[i];
                }
            }
        }
        if(j == n / 2)
            return ans;
        return new int[0];
    }
}
