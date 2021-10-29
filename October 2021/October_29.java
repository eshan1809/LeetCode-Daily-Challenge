class Solution {

    public class Pair{

        int x, y;

        Pair(int x, int y){

            this.x = x;

            this.y = y;

        }

    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length, m = grid[0].length, time = -1;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Pair> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++)

            for(int j = 0; j < m; j++)

                if(grid[i][j] == 2)

                    q.add(new Pair(i, j));

        while(!q.isEmpty()){

            int size = q.size();

            while(size-- > 0){

                Pair rem = q.remove();

                for(int i = 0; i < 4; i++){

                    int x = rem.x + dirs[i][0], y = rem.y + dirs[i][1];

                    if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1){

                        grid[x][y] = 2;

                        q.add(new Pair(x, y));

                    }

                }

            }

            time++;

        }

        for(int i = 0; i < n; i++)

            for(int j = 0; j < m; j++)

                if(grid[i][j] == 1)

                    return -1;

        return Math.max(time, 0);

    }

}
