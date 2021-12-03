class Solution {
    public int maxProduct(int[] arr) {
        if(arr.length == 0)
            return 0;
        int max = arr[0], min = arr[0], res = arr[0];
        for(int i = 1; i < arr.length; i++){  
            int temp = Math.max(arr[i] * max, Math.max(arr[i] * min, arr[i]));
            min = Math.min(arr[i] * max, Math.min(arr[i] * min, arr[i]));
            max = temp;
            res = Math.max(res, max);
        }
        return res;
    }
}
