class Solution {
    public int[] constructArray(int n, int k) {
        int arr[] = new int[n];
        int idx = 0;
        for(int i = 1; i < n-k; i++) arr[idx++] = i;
        for(int i = 0; i <= k; i++){
            if(i % 2 == 0) arr[idx++] = (n - k + i/2);
            else arr[idx++] = (n - i/2);
        }
        return arr;
    }
}
