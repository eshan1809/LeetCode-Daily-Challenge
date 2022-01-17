class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] parts = s.split(" ");
        if(parts.length != pattern.length())
            return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < parts.length; i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(parts[i]))
                    return false;
            } else{
                if(set.contains(parts[i]))
                    return false;
                set.add(parts[i]);
                map.put(pattern.charAt(i), parts[i]);
            }
        }
        return true;
    }
}
