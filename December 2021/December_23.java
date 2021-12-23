class Solution {
    int[] ans;
    int idx;
    Set<Integer> hs;
    
    public boolean helper(int[][] prerequisites, Map<Integer, Set<Integer>> map, int i, Set<Integer> set){
        if(set.contains(i)){
            ans = new int[0];
            return false;
        }
        set.add(i);
        if(map.containsKey(i)){
            for(int x : map.get(i))
                if(!helper(prerequisites, map, prerequisites[x][1], set)){
                    ans = new int[0];
                    return false;
                }
            map.remove(i);
        }
        set.remove(i);
        if(!hs.contains(i)){
            ans[idx++] = i;
            hs.add(i);
        }
        return true;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        ans = new int[numCourses];
        hs = new HashSet<>();
        idx = 0;
        for(int i = 0; i < prerequisites.length; i++){
            if(map.containsKey(prerequisites[i][0]))
                map.get(prerequisites[i][0]).add(i);
            else{
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(prerequisites[i][0], set);
            }
        }
        for(int i = 0; i < numCourses; i++)
            if(map.containsKey(i))
                if(!helper(prerequisites, map, i, new HashSet<>()))
                    return ans;
        for(int i = 0; i < numCourses; i++){
            if(hs.contains(i))
                hs.remove(i);
            else
                hs.add(i);
        }
        for(int i : hs)
            ans[idx++] = i;
        return ans;
    }
}
