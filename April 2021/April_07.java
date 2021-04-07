class Solution {
    public boolean halvesAreAlike(String s) {
        int count1 = 0, count2 = 0, len = s.length();
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for(int i = 0; i < len/2; i++) if(set.contains(s.charAt(i))) count1++;
        for(int i = len/2; i < len; i++) if(set.contains(s.charAt(i))) count2++;
        return count1 == count2;
    }
}
