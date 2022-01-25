class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n < 3)
            return false;
        int i = 0;
        while(i + 1 < n){
            if(arr[i + 1] == arr[i])
                return false;
            if(arr[i + 1] > arr[i])
                i++;
            else
                break;
        }
        if(i == 0 || i + 1 == n)
            return false;
        while(i + 1 < n){
            if(arr[i + 1] >= arr[i])
                return false;
            i++;
        }
        return true;
    }
}
