class Solution {
    private class Pair{
        int val, idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length, max = 0, count = 1;
        Pair[][] pairs = new Pair[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int noo = bfs(grid, i, j, n);
                    bfs2(grid, i, j, n, pairs, count, noo);
                    count++;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(pairs[i][j] == null)
                    pairs[i][j] = new Pair(0, 0);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(pairs[i][j].val == 0){
                    Set<Integer> set = new HashSet<>();
                    int ans = 0;
                    if(i > 0){
                        ans += pairs[i - 1][j].val;
                        set.add(pairs[i - 1][j].idx);
                    }
                    if(j > 0 && !set.contains(pairs[i][j - 1].idx)){
                        ans += pairs[i][j - 1].val;
                        set.add(pairs[i][j - 1].idx);
                    }
                    if(i < n - 1 && !set.contains(pairs[i + 1][j].idx)){
                        ans += pairs[i + 1][j].val;
                        set.add(pairs[i + 1][j].idx);
                    }
                    if(j < n - 1 && !set.contains(pairs[i][j + 1].idx)){
                        ans += pairs[i][j + 1].val;
                        set.add(pairs[i][j + 1].idx);
                    }
                    max = Math.max(max, ans + 1);
                }
            }
        }
        return max == 0 ? n * n : max;
    }
    
    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    private int bfs(int[][] grid, int i, int j, int n){
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        int ans = 0;
        while(!q.isEmpty()){
            int[] arr = q.remove();
            if(visited[arr[0]][arr[1]]) continue;
            visited[arr[0]][arr[1]] = true;
            ans++;
            for(int x = 0; x < 4; x++){
                int I = arr[0] + dirs[x][0], J = arr[1] + dirs[x][1];
                if(I >= 0 && I < n && J >= 0 && J < n && grid[I][J] == 1 && !visited[I][J])
                    q.add(new int[]{I, J});
            }
        }
        return ans;
    }
    
    private void bfs2(int[][] grid, int i, int j, int n, Pair[][] pairs, int count, int noo){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        while(!q.isEmpty()){
            int[] arr = q.remove();
            if(grid[arr[0]][arr[1]] == 0) continue;
            grid[arr[0]][arr[1]] = 0;
            pairs[arr[0]][arr[1]] = new Pair(noo, count);
            for(int x = 0; x < 4; x++){
                int I = arr[0] + dirs[x][0], J = arr[1] + dirs[x][1];
                if(I >= 0 && I < n && J >= 0 && J < n && grid[I][J] == 1)
                    q.add(new int[]{I, J});
            }
        }
    }
}
