class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        Set<String> have = new HashSet<String>();

        for (int i = k; i <= s.length(); i++) {
            String a = s.substring(i - k, i);
            if (!have.contains(a)) {
                have.add(a);
                need--;
                if (need == 0) return true;
            }
        }
        return false;
    }
}
