class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] parent = new int[n], rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(List<Integer> pair : pairs)
            union(parent, rank, pair.get(0), pair.get(1));
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int lx = find(parent, i);
            if(!map.containsKey(lx))
                map.put(lx, new ArrayList<>());
            map.get(lx).add(i);
        }
        
        char[] arr = new char[n];
        for(int i : map.keySet()){
            List<Integer> list = map.get(i);
            int[] ch = new int[26];
            for(int c : list)
                ch[s.charAt(c) - 'a']++;
            int x = 0;
            for(int c : list){
                while(ch[x] == 0)
                    x++;
                arr[c] = (char)('a' + x);
                ch[x]--;
            }
        }
        
        return String.valueOf(arr);
    }
    
    private int find(int[] parent, int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent, parent[x]);
    }
    
    private boolean union(int[] parent, int[] rank, int x, int y){
        int lx = find(parent, x), ly = find(parent, y);
        if(lx == ly)
            return false;
        if(rank[lx] > rank[ly])
            parent[ly] = lx;
        else if(rank[lx] < rank[ly])
            parent[lx] = ly;
        else{
            parent[lx] = ly;
            rank[ly]++;
        }
        return true;
    }
}
