class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] != arr2[0])
                    return (int)(((long)arr1[0] - (long)arr2[0]) % Integer.MAX_VALUE);
                else
                    return (int)(((long)arr2[1] - (long)arr1[1]) % Integer.MAX_VALUE);
            }
        });
        int n = points.length, ans = 1, right = points[0][1];
        for(int i = 1; i < n; i++){
            if(points[i][0] <= right)
                right = Math.min(right, points[i][1]);
            else{
                ans++;
                right = points[i][1];
            }
        }
        return ans;
    }
}
