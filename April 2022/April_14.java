class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int rb = 0, cb = 0, re = n - 1, ce = n - 1, p = 1;
        
        while(true){
            
            for(int i = cb; i <= ce; i++)
                mat[rb][i] = p++;
            
            rb++;
            if(rb > re)
                break;
            
            for(int i = rb; i <= re; i++)
                mat[i][ce] = p++;
            
            ce--;
            if(cb > ce)
                break;
            
            for(int i = ce; i >= cb; i--)
                mat[re][i] = p++;
            
            re--;
            if(rb > re)
                break;
            
            for(int i = re; i >= rb; i--)
                mat[i][cb] = p++;
            
            cb++;
            if(cb > ce)
                break;
            
        }
        
        return mat;
    }
}
