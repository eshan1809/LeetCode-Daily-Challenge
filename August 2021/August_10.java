class Solution {
    public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] zeros = new int[n], ones = new int[n];
        for(int i = 1; i < n; i++) {
            ones[i] = ones[i - 1];
            if(s.charAt(i - 1) == '1')
                ones[i]++;
        }
        for(int i = n - 2; i >= 0; i--) {
            zeros[i] = zeros[i + 1];
            if(s.charAt(i + 1) == '0')
                zeros[i]++;
        }
        int min = n;
        for(int i = 0; i < ones.length; i++)
            min = Math.min(ones[i] + zeros[i], min);
        return min;
    }
}
