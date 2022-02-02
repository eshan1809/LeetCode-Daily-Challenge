class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length())
            return list;
        int[] first = new int[26], second = new int[26];
        for(int i = 0; i < s.length() && i < p.length(); i++){
            first[s.charAt(i) - 'a']++;
            second[p.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length() - p.length(); i++){
            if(same(first, second))
                list.add(i);
            first[s.charAt(i) - 'a']--;
            first[s.charAt(i + p.length()) - 'a']++;
        }
        if(same(first, second))
            list.add(s.length() - p.length());
        return list;
    }
    
    private boolean same(int[] a, int[] b){
        for(int i = 0; i < 26; i++)
            if(a[i] != b[i])
                return false;
        return true;
    }
}
