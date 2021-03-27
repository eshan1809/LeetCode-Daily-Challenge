class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++)
            for(int j=i+1; j<=s.length(); j++) 
                if(isPalindrome(s.substring(i, j))) count++;
        return count;
    }
    
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i < j) if(s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}
