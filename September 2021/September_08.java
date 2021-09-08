class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length, shift = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--){
            shift = (shift + shifts[i]) % 26;
            int val = ((s.charAt(i) - 'a') + shift) % 26;
            sb.append((char)('a' + val));
        }
        return sb.reverse().toString();
    }
}
