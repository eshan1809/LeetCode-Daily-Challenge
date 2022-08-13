class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        int len = words[0].length(), tot = words.length;
        for(int l = 0; l < len; l++){
            Map<String, Integer> check = new HashMap<>();
            int count = 0, p = l;
            for(int i = l; i + len <= s.length(); i += len){
                String curr = s.substring(i, i + len);
                if(!map.containsKey(curr)){
                    check.clear();
                    p = i + len;
                    count = 0;
                } else{
                    check.put(curr, check.getOrDefault(curr, 0) + 1);
                    count++;
                    while(map.get(curr) < check.get(curr)){
                        String prev = s.substring(p, p + len);
                        check.put(prev, check.getOrDefault(prev, 0) - 1);
                        p += len;
                        count--;
                    }
                    if(count == tot)
                        list.add(p);
                }
            }
        }
        return list;
    }
}
