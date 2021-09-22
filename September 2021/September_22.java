class Solution {
    public int maxLength(List<String> arr) {
        max = 0;
        for(int i = arr.size() - 1; i >= 0; i--){
            boolean[] flag = new boolean[26];
            for(char ch : arr.get(i).toCharArray()){
                if(!flag[ch - 'a'])
                    flag[ch - 'a'] = true;
                else{
                    arr.remove(i);
                    break;
                }
            }
        }
        helper(arr, 0, "", new boolean[26]);
        return max;
    }
    
    int max;
    
    private void helper(List<String> arr, int idx, String asf, boolean[] occupied){
        if(idx == arr.size()){
            max = Math.max(max, asf.length());
            return;
        }
        
        helper(arr, idx + 1, asf, occupied);
        boolean flag = true;
        String str = arr.get(idx);
        for(char ch : str.toCharArray()){
            if(occupied[ch - 'a']){
                flag = false;
                break;
            }
        }
        if(flag){
            for(char ch : str.toCharArray())
                occupied[ch - 'a'] = true;
            helper(arr, idx + 1, asf + str, occupied);
            for(char ch : str.toCharArray())
                occupied[ch - 'a'] = false;
        }
    }
}
