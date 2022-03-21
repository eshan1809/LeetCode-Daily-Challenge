class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] lastOcc = new int[26];
        for(int i = 0; i < n; i++)
            lastOcc[s.charAt(i) - 'a'] = i;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < n){
            int j = i, upto = lastOcc[s.charAt(i) - 'a'];
            while(j <= upto)
                upto = Math.max(upto, lastOcc[s.charAt(j++) - 'a']);
            list.add(j - i);
            i = j;
        }
        return list;
    }
}
