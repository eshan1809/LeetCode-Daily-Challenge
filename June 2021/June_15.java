class Solution {
    public boolean helper(int[] matchsticks, long a, long b, long c, long d, int i, long max){
        if(i == matchsticks.length) return a == b && a == c && a == d;
        if(a > max || b > max || c > max || d > max) return false;
        
        if(helper(matchsticks, a + matchsticks[i], b, c, d, i + 1, max)) return true;
        if(helper(matchsticks, a, b + matchsticks[i], c, d, i + 1, max)) return true;
        if(helper(matchsticks, a, b, c + matchsticks[i], d, i + 1, max)) return true;
        if(helper(matchsticks, a, b, c, d + matchsticks[i], i + 1, max)) return true;
        
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        
        long sum = 0;
        for(int i : matchsticks) sum += i;
        if(sum % 4 != 0) return false;
        
        return helper(matchsticks, 0, 0, 0, 0, 0, sum / 4);
    }
}
