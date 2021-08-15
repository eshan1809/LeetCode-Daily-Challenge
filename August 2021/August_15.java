class Solution {
    public String minWindow(String s, String t) {
        int[] arr1 = new int[58];
        for(char ch : t.toCharArray())
            arr1[ch - 'A']++;
        int[] arr2 = new int[58];
        int i = 0, j = 0, count = 0, ai = 0, aj = 0, len = t.length();
        String ans = "";
        while(j < s.length()){
            int ch = s.charAt(j) - 'A';
            if(arr1[ch] >= ++arr2[ch])
                count++;
            while(count == len){
                if(aj == ai || aj - ai > j - i + 1){
                    ai = i;
                    aj = j + 1;
                }
                int beg = s.charAt(i) - 'A';
                if(--arr2[beg] < arr1[beg])
                    count--;
                i++;
            }
            j++;
        }
        return s.substring(ai, aj);
    }
}
