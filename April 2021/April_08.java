class Solution {
    static String[] codes = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        return helper(digits);
    }
    public List<String> helper(String digits){
        if(digits.length() == 0){
            List<String> al = new ArrayList<>();
            al.add("");
            return al;
        }
        
        int c = digits.charAt(0) - '2';
        List<String> list = helper(digits.substring(1));
        List<String> ans = new ArrayList<>();
        for(int i=0; i < codes[c].length(); i++){
            char ch = codes[c].charAt(i);
            for(int j=0; j<list.size(); j++){
                String str = ch + list.get(j);
                ans.add(str);
            }
        }
        return ans;
    }
}
