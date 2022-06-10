class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, i = 0, j = 0, n = s.length();
        int[] freq = new int[256];
        while(j < n){
            char ch = s.charAt(j);
            while(freq[ch] > 0)
                freq[s.charAt(i++)]--;
            freq[ch]++;
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}
