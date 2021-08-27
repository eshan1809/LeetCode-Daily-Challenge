class Solution {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        for(int i = 0; i < strs.length; i++){
            boolean flag = true;
            for(int j = 0; j < strs.length; j++){
                if(i == j)
                    continue;
                if(isSubsequence(strs[i], strs[j])){
                    flag = false;
                    break;
                }
            }
            if(flag)
                ans = Math.max(ans, strs[i].length());
        }
        return ans;
    }
    
    private boolean isSubsequence(String a, String b){
        int idx = 0;
        for(int i = 0; i < b.length() && idx < a.length(); i++)
            if(a.charAt(idx) == b.charAt(i))
                idx++;
        return idx == a.length();
    }
}
