class Solution {
    public String customSortString(String order, String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) map.put(order.charAt(i), i + 1);
        for(char i = 'a'; i <= 'z'; i++) if(!map.containsKey(i)) map.put(i, order.length() + 1);
        Character[] arr = new Character[str.length()];
        for(int i = 0; i < str.length(); i++) arr[i] = str.charAt(i);
        Arrays.sort(arr, new Comparator<Character>(){
            @Override
            public int compare(Character ch1, Character ch2){
                return map.get(ch1) - map.get(ch2);
            }
        });
        String ans = "";
        for(char ch : arr) ans += ch;
        return ans;
    }
}
