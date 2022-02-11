class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for(char ch : s1.toCharArray())
            freq[ch - 'a']++;
        
        int i = -1;
        for(int j = 0; j < s2.length(); j++){
            char ch = s2.charAt(j);
            if(freq[ch - 'a'] == 0){
                if(j - i - 1 == s1.length())
                    return true;
                while(s2.charAt(++i) != ch)
                    freq[s2.charAt(i) - 'a']++;
            } else
                freq[ch - 'a']--;
        }
        
        return s2.length() - i - 1 == s1.length();
    }
}
