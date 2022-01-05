class Solution {
    List<List<String>> list;
    public List<List<String>> partition(String s) {
        list = new ArrayList();
        List<String> al = new ArrayList();
        solution(s, al);
        return list;
    }
    
    public void solution(String str, List<String> al) {
		if(str.length() == 0){
		    list.add(new ArrayList<>(al));
		    return;
		}
		String ssf = "";
		for(int i = 0; i < str.length(); i++){
		    ssf += str.charAt(i);
            al.add(ssf);
		    if(isPalindrome(ssf))
                solution(str.substring(i + 1), al);
            al.remove(al.size() - 1);
		}
	}
    
    public boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        while(i < j)
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        return true;
    }
}
