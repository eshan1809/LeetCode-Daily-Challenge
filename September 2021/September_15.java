class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length, max = 1;
        int[] inc = new int[n], dec = new int[n];
        inc[0] = dec[0] = 1;
        for(int i = 1; i < n; i++){
            if(arr[i] > arr[i - 1]){
                inc[i] = dec[i - 1] + 1;
                dec[i] = 1;
                max = Math.max(max, inc[i]);
            } else if(arr[i] < arr[i - 1]){
                dec[i] = inc[i - 1] + 1;
                inc[i] = 1;
                max = Math.max(max, dec[i]);
            } else
                inc[i] = dec[i] = 1;
        }
        return max;
    }
}
