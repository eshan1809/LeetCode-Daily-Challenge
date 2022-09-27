class Solution {
public:
    string pushDominoes(string dominoes) {
        int n = dominoes.length();
        queue<pair<char, int> > q;
        for(int i = 0; i < n; i++){
            if(dominoes[i] == 'L' && i > 0 && dominoes[i - 1] == '.')
                q.push(make_pair('L', i - 1));
            else if(dominoes[i] == 'R' && i + 1 < n && dominoes[i + 1] == '.')
                q.push(make_pair('R', i + 1));
        }
        while(!q.empty()){
            int size = q.size();
            set<int> done;
            while(size-- > 0){
                pair<char, int> rem = q.front();
                q.pop();
                if(dominoes[rem.second] == '.'){
                    dominoes[rem.second] = rem.first;
                    done.insert(rem.second);
                    if(rem.first == 'L' && rem.second > 0)
                        q.push(make_pair('L', rem.second - 1));
                    else if(rem.first == 'R' && rem.second + 1 < n)
                        q.push(make_pair('R', rem.second + 1));
                } else if(dominoes[rem.second] != rem.first && done.find(rem.second) != done.end())
                    dominoes[rem.second] = '.';
            }
        }
        return dominoes;
    }
};
