class Solution {
    public int myAtoi(String s) {
        int sign = 1, i = 0, n = s.length();
        long ans = 0L;
        while(i < n && s.charAt(i) == ' ')
            i++;
        if(i < n && s.charAt(i) == '+')
            i++;
        else if(i < n && s.charAt(i) == '-'){
            i++;
            sign = -1;
        }
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            ans = 10 * ans + (s.charAt(i) - '0');
            if(ans > 1L + Integer.MAX_VALUE)
                ans = 1L + Integer.MAX_VALUE;
            i++;
        }
        if(ans == 1L + Integer.MAX_VALUE && sign == 1)
            ans = Integer.MAX_VALUE;
        return (int)(ans * sign);
    }
}
