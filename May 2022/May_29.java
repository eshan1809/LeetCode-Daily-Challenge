class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            int x = 0;
            for(int j = 0; j < words[i].length(); j++)
                x |= (1 << (words[i].charAt(j) - 'a'));
            arr[i] = x;
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++)
            for(int j = i + 1; j < n; j++)
                if((arr[i] & arr[j]) == 0)
                    ans = Math.max(ans, words[i].length() * words[j].length());
        return ans;
    }
}
