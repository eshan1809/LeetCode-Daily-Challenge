class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet(Arrays.asList(words));
        for(String word: words) for(int k=1; k<word.length(); k++) set.remove(word.substring(k));
        int ans = 0;
        for(String word: set) ans += word.length()+1;
        return ans;
    }
}
