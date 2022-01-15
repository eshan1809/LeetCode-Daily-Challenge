class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n < 3)
            return n - 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int rem = q.remove();
                if(rem == n - 1)
                    return ans;
                for(int i : map.get(arr[rem]))
                    if(!visited[i]){
                        visited[i] = true;
                        q.add(i);
                    }
                map.get(arr[rem]).clear();
                if(rem + 1 < n && !visited[rem + 1]){
                    visited[rem + 1] = true;
                    q.add(rem + 1);
                }
                if(rem - 1 > 0 && !visited[rem - 1]){
                    visited[rem - 1] = true;
                    q.add(rem - 1);
                }
            }
            ans++;
        }
        return -1;
    }
}
