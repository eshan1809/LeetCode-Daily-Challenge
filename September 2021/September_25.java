class Solution {
    class Pair implements Comparable<Pair>{
        int r, c, mov, rem;
        Pair(int r, int c, int mov, int rem){
            this.r = r;
            this.c = c;
            this.mov = mov;
            this.rem = rem;
        }
        
        public int compareTo(Pair o){
            if(this.mov == o.mov)
                return this.rem - o.rem;
            return this.mov - o.mov;
        }
    }
    
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++)
            Arrays.fill(visited[i], k + 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0, 0));
        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            if(visited[pair.r][pair.c] <= pair.rem)
                continue;
            visited[pair.r][pair.c] = pair.rem;
            if(pair.r == n - 1 && pair.c == m - 1)
                return pair.mov;
            for(int d = 0; d < 4; d++){
                int i = pair.r + dirs[d][0], j = pair.c + dirs[d][1];
                if(i >= 0 && i < n && j >= 0 && j < m && visited[i][j] > pair.rem + grid[i][j] && pair.rem + grid[i][j] <= k)
                    pq.add(new Pair(i, j, pair.mov + 1, pair.rem + grid[i][j]));
            }
        }
        return -1;
    }
}
