class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0)
            return n * m;
        int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
        for(int i = 0; i < ops.length; i++){
            minx = Math.min(minx, ops[i][0]);
            miny = Math.min(miny, ops[i][1]);
        }
        return minx * miny;
    }
}
