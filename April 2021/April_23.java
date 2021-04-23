class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0, coz = 0, coo = 0, sum = 0;
        for(int i = 0; i < s.length(); i++){
            int x = s.charAt(i) - '0';
            if(prev == x){
                if(x == 0) coz++;
                else coo++;
            } else{
                sum += Math.min(coz, coo);
                prev = x;
                if(x == 0) coz = 1;
                else coo = 1;
            }
        }
        return sum + Math.min(coz, coo);
    }
}
