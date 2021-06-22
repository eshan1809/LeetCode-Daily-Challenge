class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        for(String word : map.keySet()){
            int x = 0;
            for(int i = 0; i < S.length(); i++){
                if(S.charAt(i) == word.charAt(x))
                    x++;
                if(x == word.length())
                    break;
            }
            if(x == word.length())
                count += map.get(word);
        }
        return count;
    }
}
