class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length, max = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            int x = 0;
            for(int j = 0; j < i; j++){
                if(valid(words[i], words[j]))
                    x = Math.max(x, dp[j]);
            }
            max = Math.max(max, dp[i] = x + 1);
        }
        return max;
    }
    
    private boolean valid(String s, String t){
        if(s.length() != t.length() + 1)
            return false;
        int diff = 0;
        for(int i = 0; i < t.length(); i++){
            while(s.charAt(i + diff) != t.charAt(i)){
                diff++;
                if(diff > 1)
                    return false;
            }
        }
        return true;
    }
}
