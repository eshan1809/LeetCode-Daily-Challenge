class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
		int[][] arr = new int[n][26];
		for(int i = 0; i < n; i++)
			for(char ch : strs[i].toCharArray()) arr[i][ch - 'a']++;
		boolean[] used = new boolean[n];
		List<List<String>> list = new ArrayList<>();
		for(int i = 0; i < n; i++){
			if(used[i]) continue;
			List<String> al = new ArrayList<>();
			al.add(strs[i]);
			for(int j = i + 1; j < n; j++){
				if(used[j]) continue;
				int flag = 0;
				for(int k = 0; k < 26; k++){
					if(arr[i][k] != arr[j][k]){
						flag = 1;
						break;
					}
				}
				if(flag == 0){
					used[j] = true;
					al.add(strs[j]);
				}
			}
			list.add(al);
		}
		return list;
    }
}
