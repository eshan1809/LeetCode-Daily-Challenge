class Solution {
    public String originalDigits(String s) {
        int[] freq = new int[10];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'z') freq[0]++;
            else if(ch == 'o') freq[1]++;
            else if(ch == 'w') freq[2]++;
            else if(ch == 'r') freq[3]++;
            else if(ch == 'u') freq[4]++;
            else if(ch == 'f') freq[5]++;
            else if(ch == 'x') freq[6]++;
            else if(ch == 's') freq[7]++;
            else if(ch == 'g') freq[8]++;
            else if(ch == 'i') freq[9]++;
        }
        freq[1] = freq[1] - freq[0] - freq[2] - freq[4];
        freq[3] = freq[3] - freq[0] - freq[4];
        freq[5] -= freq[4];
        freq[7] -= freq[6];
        freq[9] = freq[9] - freq[8] - freq[6] - freq[5];
        String str = "";
        for(int i=0; i < freq.length; i++){
            while(freq[i] > 0){
                str += i;
                freq[i]--;
            }
        }
        return str;
    }
}
