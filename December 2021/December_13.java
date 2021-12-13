class Solution {
    public int maxPower(String s) {
        char prev = s.charAt(0);
        int count = 1, ans = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == prev)
                count++;
            else{
                prev = s.charAt(i);
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
