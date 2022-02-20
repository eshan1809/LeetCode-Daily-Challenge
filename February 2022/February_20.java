class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0])
                    return b[1] - a[1];
                return a[0] - b[0];
            }
        });
        
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            boolean done = false;
            for(int j = 0; j < list.size(); j++){
                if(list.get(j)[0] <= intervals[i][0] && intervals[i][1] <= list.get(j)[1]){
                    done = true;
                    break;
                }
            }
            if(!done)
                list.add(intervals[i]);
        }
        return list.size();
    }
}
