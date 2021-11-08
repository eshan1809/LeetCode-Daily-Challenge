class Solution {
    public int numTrees(int n) {
        int[] arr = new int[n + 1];
        arr[1] = arr[0] = 1;
        for(int i = 2; i <= n; i++){
            int start = 0, end = i - 1, val = 0;
            while(start < end)
                val += 2 * arr[start++] * arr[end--];
            if(start == end)
                val += arr[start] * arr[start];
            arr[i] = val;
        }
        return arr[n];
    }
}
