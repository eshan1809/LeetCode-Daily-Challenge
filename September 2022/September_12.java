class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length, i = 0, j = n - 1, score = 0;
        while(i <= j){
            while(i <= j && power >= tokens[i]){
                power -= tokens[i++];
                score++;
            }
            if(i < j && score > 0){
                power += tokens[j--];
                score--;
            } else
                break;
        }
        return score;
    }
}
