class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        for(char ch : s.toCharArray())
            arr[ch - 'a']++;
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 25; i > 0; i--)
            if(arr[i - 1] >= arr[i] && arr[i - 1] != 0){
                if(arr[i] == 0){
                    ans += arr[i - 1];
                    arr[i - 1] = 0;
                } else{
                    ans += arr[i - 1] - arr[i] + 1;
                    arr[i - 1] = arr[i] - 1;
                }
            }
        return ans;
    }
}
