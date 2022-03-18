class Solution {
    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        for(char ch : arr)
            freq[ch - 'a']++;
        Stack<Character> st = new Stack<>();
        boolean[] used = new boolean[26];
        for(char ch : arr){
            freq[ch - 'a']--;
            if(used[ch - 'a'])
                continue;
            while(!st.isEmpty() && st.peek() > ch && freq[st.peek() - 'a'] > 0)
                used[st.pop() - 'a'] = false;
            st.push(ch);
            used[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }
}
