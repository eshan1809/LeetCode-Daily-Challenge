class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n];
        for(int i = 0; i < trust.length; i++){
            arr[trust[i][1] - 1]++;
            arr[trust[i][0] - 1] = Integer.MIN_VALUE;
        }
        for(int i = 0; i < n; i++)
            if(arr[i] == n - 1)
                return i + 1;
        return -1;
    }
}
