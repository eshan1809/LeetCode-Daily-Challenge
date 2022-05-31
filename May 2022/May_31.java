class Solution {
    public boolean hasAllCodes(String s, int k) {
        int sz = 1 << k, idx = 0, mask = sz - 1;
        boolean[] has = new boolean[sz];
        for(int i = 0; i < s.length(); i++){
            idx <<= 1;
            idx &= mask;
            idx += s.charAt(i) - '0';
            if(i >= k - 1 && !has[idx]){
                has[idx] = true;
                if(--sz == 0)
                    return true;
            }
        }
        return false;
    }
}
