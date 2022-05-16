class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int len = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] rem = q.remove();
                if(vis[rem[0]][rem[1]])
                    continue;
                vis[rem[0]][rem[1]] = true;
                if(rem[0] == n - 1 && rem[1] == n - 1)
                    return len;
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){
                        if(i == 0 && j == 0)
                            continue;
                        int x = rem[0] + i, y = rem[1] + j;
                        if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0 && !vis[x][y])
                            q.add(new int[]{x, y});
                    }
                }
            }
            len++;
        }
        return -1;
    }
}
