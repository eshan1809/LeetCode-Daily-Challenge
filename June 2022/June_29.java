class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while(i < n && people[i][1] == 0)
            list.add(people[i++]);
        while(i < n){
            int count = 0;
            for(int j = 0; j < i; j++){
                if(people[i][0] <= list.get(j)[0])
                    count++;
                if(count == people[i][1] + 1){
                    list.add(j, people[i]);
                    break;
                }
            }
            if(count <= people[i][1])
                list.add(people[i]);
            i++;
        }
        
        int[][] ans = new int[n][2];
        for(i = 0; i < n; i++)
            ans[i] = list.get(i);
        return ans;
    }
}
