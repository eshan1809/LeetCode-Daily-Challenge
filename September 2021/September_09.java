class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] mat = new int[n][n];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < mines.length; i++)
            set.add(mines[i][0] * n + mines[i][1]);
        int dist = 0, ans = 0;
        for(int i = 0; i < n; i++){
            dist = 0;
            for(int j = 0; j < n; j++){
                if(set.contains(i * n + j))
                    dist = 0;
                else
                    dist++;
                mat[i][j] = dist;
            }
            dist = 0;
            for(int j = n - 1; j >= 0; j--){
                if(set.contains(i * n + j))
                    dist = 0;
                else
                    dist++;
                mat[i][j] = Math.min(dist, mat[i][j]);
            }
        }
        for(int j = 0; j < n; j++){
            dist = 0;
            for(int i = 0; i < n; i++){
                if(set.contains(i * n + j))
                    dist = 0;
                else
                    dist++;
                mat[i][j] = Math.min(dist, mat[i][j]);
            }
            dist = 0;
            for(int i = n - 1; i >= 0; i--){
                if(set.contains(i * n + j))
                    dist = 0;
                else
                    dist++;
                mat[i][j] = Math.min(dist, mat[i][j]);
                ans = Math.max(ans, mat[i][j]);
            }
        }
        return ans;
    }
}
