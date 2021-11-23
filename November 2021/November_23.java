class Solution {
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        parent = new int[n];
        rank = new int[n];
        power = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
            power[i] = 1;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int d = 2, x = nums[i];
            while(d * d <= x){
                if(x % d == 0){
                    while(x % d == 0)
                        x /= d;
                    map.putIfAbsent(d, new HashSet<>());
                    map.get(d).add(i);
                }
                d++;
            }
            if(x > 1){
                map.putIfAbsent(x, new HashSet<>());
                map.get(x).add(i);
            }
        }
        
        int max = 1;
        for(int k : map.keySet()){
            Set<Integer> set = map.get(k);
            int x = set.iterator().next();
            for(int i : set){
                union(i, x);
                max = Math.max(max, power[find(i)]);
            }
        }
        return max;
    }
    
    int[] parent, rank, power;
    
    private int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    
    private void union(int a, int b){
        int la = find(a), lb = find(b);
        if(la != lb){
            if(rank[la] > rank[lb]){
                parent[lb] = la;
                power[la] += power[lb];
            } else if(rank[la] < rank[lb]){
                parent[la] = lb;
                power[lb] += power[la];
            } else{
                parent[la] = lb;
                rank[lb]++;
                power[lb] += power[la];
            }
        }
    }
}
