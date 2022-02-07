class Solution {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for(char ch : s.toCharArray())
            arr[ch - 'a']++;
        for(char ch : t.toCharArray()){
            if(arr[ch - 'a'] == 0)
                return ch;
            arr[ch - 'a']--;
        }
        return '-';
    }
}
