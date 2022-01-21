class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, gb = 0, mgb = 0;
        for(int i = 0; i < n; i++){
            gb += gas[i] - cost[i];
            mgb = Math.min(mgb, gb);
        }
        if(gb < 0)
            return -1;
        for(int i = 0; i < n; i++){
            if(mgb >= 0)
                return i;
            mgb -= gas[i] - cost[i];
        }
        return -1;
    }
}
