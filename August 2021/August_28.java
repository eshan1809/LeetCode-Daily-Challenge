class Solution {
    class Pair implements Comparable<Pair>{
        int st, et, p;
        Pair(int st, int et, int p){
            this.st = st;
            this.et = et;
            this.p = p;
        }
        
        public int compareTo(Pair o){
            return this.st - o.st;
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length, size = 0;
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++){
            pairs[i] = new Pair(startTime[i], endTime[i], profit[i]);
            size = Math.max(size, endTime[i]);
        }
        Arrays.sort(pairs);
        Arrays.sort(startTime);
        int[] dp = new int[size];
        for(int i = size - 2; i >= 0; i--){
            int j = getIdx(startTime, i + 1);
            if(j == -1)
                dp[i] = dp[i + 1];
            else{
                int max = dp[i + 1];
                while(j < n && startTime[j] == i + 1){
                    max = Math.max(max, pairs[j].p + dp[pairs[j].et - 1]);
                    j++;
                }
                dp[i] = max;
            }
        }
        return dp[0];
    }
    
    public int getIdx(int[] arr, int x){
        int i = 0, j = arr.length - 1, ret = -1;
        while(i <= j){
            int mid = (i + j) / 2;
            if(arr[mid] >= x){
                ret = mid;
                j = mid - 1;
            } else
                i = mid + 1;
        }
        return ret;
    }
}
