class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char ch : text.toCharArray())
            freq[ch - 'a']++;
        return Math.min((Math.min(Math.min(freq[1], freq[0]), Math.min(freq[11] / 2, freq[14] / 2))), freq[13]);
        // b -> 1, a -> 0, l -> 11, o -> 14, n -> 13
    }
}
