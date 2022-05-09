class Solution {
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        helper(digits, 0, "");
        return list;
    }
    
    String[] keys = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list;
    
    private void helper(String digits, int i, String ssf){
        if(i == digits.length()){
            if(ssf.length() > 0)
                list.add(ssf);
            return;
        }
        
        int idx = digits.charAt(i) - '2';
        for(int j = 0; j < keys[idx].length(); j++)
            helper(digits, i + 1, ssf + keys[idx].charAt(j));
    }
}
