class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] req = new int[26];
        for(String word : words2){
            int[] tmp = new int[26];
            for(char ch : word.toCharArray())
                tmp[ch - 'a']++;
            for(int i = 0; i < 26; i++)
                req[i] = Math.max(req[i], tmp[i]);
        }
        List<String> list = new ArrayList<>();
        for(String word : words1){
            int[] tmp = new int[26];
            for(char ch : word.toCharArray())
                tmp[ch - 'a']++;
            boolean flag = true;
            for(int i = 0; i < 26; i++)
                if(req[i] > tmp[i]){
                    flag = false;
                    break;
                }
            if(flag)
                list.add(word);
        }
        return list;
    }
}
