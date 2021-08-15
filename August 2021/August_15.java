class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        for(char ch : t.toCharArray())
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        Map<Character, Integer> map2 = new HashMap<>();
        int i = 0, j = 0, count = 0;
        String ans = "";
        while(j < s.length()){
            char ch = s.charAt(j);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            if(map1.containsKey(ch) && map1.get(ch) >= map2.get(ch))
                count++;
            while(count == t.length()){
                if(ans.equals("") || ans.length() > j - i + 1)
                    ans = s.substring(i, j + 1);
                char beg = s.charAt(i);
                if(map2.get(beg) == 1)
                    map2.remove(beg);
                else
                    map2.put(beg, map2.get(beg) - 1);
                if(map2.getOrDefault(beg, 0) < map1.getOrDefault(beg, 0))
                    count--;
                i++;
            }
            j++;
        }
        return ans;
    }
}
