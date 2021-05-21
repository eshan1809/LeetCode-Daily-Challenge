class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList();
        for(String word : words){
            Map<Character, Character> map = new HashMap();
            int flag = 0;
            boolean[] used = new boolean[26];
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i), p = pattern.charAt(i);
                if(map.containsKey(p)){
                    if(map.get(p) != ch){
                        flag = 1;
                        break;
                    }
                } else{
                    if(used[ch - 'a'] == false){
                        map.put(p, ch);
                        used[ch - 'a'] = true;
                    } else{
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 0) list.add(word);
        }
        return list;
    }
}
