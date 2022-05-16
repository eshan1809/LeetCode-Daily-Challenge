class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, len = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] rem = q.remove();
                if(rem[0] == n - 1 && rem[1] == n - 1)
                    return len;
                if(grid[rem[0]][rem[1]] == 1)
                    continue;
                grid[rem[0]][rem[1]] = 1;
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){
                        if(i == 0 && j == 0)
                            continue;
                        int x = rem[0] + i, y = rem[1] + j;
                        if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0)
                            q.add(new int[]{x, y});
                    }
                }
            }
            len++;
        }
        return -1;
    }
}
