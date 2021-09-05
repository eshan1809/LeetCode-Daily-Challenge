class Solution {
    public String orderlyQueue(String s, int k) {
        if(k == 1){
            int n = s.length();
            String min = s;
            for(int i = 1; i < n; i++){
                s = s.substring(1) + s.charAt(0);
                if(s.compareTo(min) < 0)
                    min = s;
            }
            return min;
        } else{
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }
    }
}
