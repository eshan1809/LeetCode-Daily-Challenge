class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> ((b[0] == a[0]) ? (b[1] - a[1]) : (b[0] - a[0])));
        TreeSet<Integer> set = new TreeSet<>();
        int i = 0, ans = 0, n = properties.length;
        while(i < n){
            int j = i;
            while(j < n && properties[j][0] == properties[i][0])
                if(set.ceiling(properties[j++][1] + 1) != null)
                    ans++;
            while(i < j)
                set.add(properties[i++][1]);
        }
        return ans;
    }
}
