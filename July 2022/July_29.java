class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int n = pattern.length();
        List<String> list = new ArrayList<>();
        int[] arr = new int[26], rev = new int[26];
        for(String word : words){
            Arrays.fill(arr, -1);
            Arrays.fill(rev, -1);
            boolean flag = true;
            for(int i = 0; i < n; i++){
                char ch1 = word.charAt(i), ch2 = pattern.charAt(i);
                if(arr[ch1 - 'a'] == -1 && rev[ch2 - 'a'] == -1){
                    arr[ch1 - 'a'] = ch2 - 'a';
                    rev[ch2 - 'a'] = ch1 - 'a';
                } else if(arr[ch1 - 'a'] != ch2 - 'a' && rev[ch2 - 'a'] != ch1 - 'a'){
                    flag = false;
                    break;
                }
            }
            if(flag)
               list.add(word); 
        }
        return list;
    }
}
