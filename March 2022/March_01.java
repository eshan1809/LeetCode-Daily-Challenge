class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int x = i;
            while(x > 0){
                x -= (x & -x);
                arr[i]++;
            }
        }
        return arr;
    }
}
