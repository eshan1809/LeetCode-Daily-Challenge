class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        boolean[][] arr = new boolean[n][26];
        for(int i = 0; i < n; i++){
            String word = words[i];
            for(int j = 0; j < word.length(); j++) arr[i][word.charAt(j) - 'a'] = true;
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int flag = 0;
                for(int k = 0; k < 26; k++){
                    if(arr[i][k] && arr[j][k]){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}
