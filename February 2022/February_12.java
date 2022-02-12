class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, List<String>> map = new HashMap<>();
        int n = wordList.size();
        for(int i = 0; i < n; i++){
            String str1 = wordList.get(i);
            for(int j = i + 1; j < n; j++){
                String str2 = wordList.get(j);
                if(differ(str1, str2) == 1){
                    if(!map.containsKey(str1))
                        map.put(str1, new ArrayList<>());
                    if(!map.containsKey(str2))
                        map.put(str2, new ArrayList<>());
                    map.get(str1).add(str2);
                    map.get(str2).add(str1);
                }
            }
        }
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.add(beginWord);
        int ladder = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String rem = q.remove();
                if(rem.equals(endWord))
                    return ladder;
                if(visited.contains(rem))
                    continue;
                visited.add(rem);
                if(!map.containsKey(rem))
                    continue;
                for(String s : map.get(rem))
                    q.add(s);
            }
            ladder++;
        }
        return 0;
    }
    
    private int differ(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++)
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        return count;
    }
}
