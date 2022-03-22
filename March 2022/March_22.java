class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        for(int i = n - 1; i >= 0; i--){
            int cur = Math.min(k - i, 26);
            k -= cur;
            arr[i] = (char)('a' + cur - 1);
        }
        return String.valueOf(arr);
    }
}
