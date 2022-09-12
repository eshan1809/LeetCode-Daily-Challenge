class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        sort(tokens.begin(), tokens.end());
        int n = tokens.size(), i = 0, j = n - 1, score = 0;
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
};
