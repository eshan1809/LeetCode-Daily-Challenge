class Solution {                                     
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = map.get(s.charAt(s.length() - 1));
        for(int i=s.length() - 2; i >= 0; i--){
            int x = map.get(s.charAt(i));
            if(x >= map.get(s.charAt(i + 1)))
                num += x;
            else
                num -= x;
        }
        return num;
    }
}
