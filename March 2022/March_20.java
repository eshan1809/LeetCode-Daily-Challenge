class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int a = tops[0], b = bottoms[0], n = tops.length;
        for(int i = 1; i < n; i++){
            if(tops[i] != a && bottoms[i] != a)
                a = -1;
            if(tops[i] != b && bottoms[i] != b)
                b = -1;
            if(a == -1 && b == -1)
                return -1;
        }
        int ans = n;
        if(a != -1){
            int c1 = 0, c2 = 0;
            for(int i = 0; i < n; i++){
                if(tops[i] != a)
                    c1++;
                if(bottoms[i] != a)
                    c2++;
            }
            ans = Math.min(c1, c2);
        }
        if(b != -1){
            int c1 = 0, c2= 0;
            for(int i = 0; i < n; i++){
                if(tops[i] != b)
                    c1++;
                if(bottoms[i] != b)
                    c2++;
            }
            ans = Math.min(ans, Math.min(c1, c2));
        }
        return ans;
    }
}
