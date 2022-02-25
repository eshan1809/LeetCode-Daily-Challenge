class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("[.]"), v2 = version2.split("[.]");
        int i = 0, n = v1.length, j = 0, m = v2.length;
        while(i < n || j < m){
            int r1 = 0, r2 = 0;
            if(i < n)
                r1 = Integer.parseInt(v1[i++]);
            if(j < m)
                r2 = Integer.parseInt(v2[j++]);
            if(r1 < r2)
                return -1;
            if(r2 < r1)
                return 1;
        }
        return 0;
    }
}
