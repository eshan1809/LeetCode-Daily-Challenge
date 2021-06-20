class Solution {
    public class Pair implements Comparable<Pair>{
        int x, y, val;
        Pair(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    public int swimInWater(int[][] grid) {
        int max = grid[0][0], n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        visited[0][0] = true;
        while(pq.size() > 0){
            Pair p = pq.remove();
            max = Math.max(max, p.val);
            if(p.x == n - 1 && p.y == m - 1) return max;
            if(p.x - 1 >= 0 && !visited[p.x - 1][p.y]){
                pq.add(new Pair(p.x - 1, p.y, grid[p.x - 1][p.y]));
                visited[p.x - 1][p.y] = true;
            }
            if(p.y - 1 >= 0 && !visited[p.x][p.y - 1]){
                pq.add(new Pair(p.x, p.y - 1, grid[p.x][p.y - 1]));
                visited[p.x][p.y - 1] = true;
            }
            if(p.x + 1 < n && !visited[p.x + 1][p.y]){
                pq.add(new Pair(p.x + 1, p.y, grid[p.x + 1][p.y]));
                visited[p.x + 1][p.y] = true;
            }
            if(p.y + 1 < m && !visited[p.x][p.y + 1]){
                pq.add(new Pair(p.x, p.y + 1, grid[p.x][p.y + 1]));
                visited[p.x][p.y + 1] = true;
            }
        }
        return max;
    }
}
