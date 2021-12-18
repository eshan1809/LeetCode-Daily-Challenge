class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String num = "" + n;
        int ans = 0, op = digits.length, len = num.length();
        int[] dp = new int[len + 1];
        dp[k] = 1;
        for(int i = len - 1; i >= 0; i--){
            for(int j = 0; j < op; j++){
                if(digits[j].charAt(0) < num.charAt(i))
                    dp[i] += Math.pow(op, len - i - 1);
                else if(digits[j].charAt(0) == num.charAt(i))
                    dp[i] += dp[i + 1];
            }
        }
        for(int i = 1; i < len; i++)
            dp[0] += Math.pow(op, i);
        return dp[0];
    }
}
