class Solution {
    public int maxDistToClosest(int[] seats) {
        int x = 20000, max = 0, n = seats.length;
        int[] seat1 = new int[n], seat2 = new int[n];
        for(int i = 0; i < n; i++){
            if(seats[i] == 1){
                x = 1;
                seat1[i] = 0;
            } else
                seat1[i] = x++;
        }
        for(int i = n - 1; i >= 0; i--){
            if(seats[i] == 1){
                x = 1;
                seat2[i] = 0;
            } else
                seat2[i] = x++;
        }
        for(int i = 0; i < n; i++)
            max = Math.max(max, Math.min(seat1[i], seat2[i]));
        return max;
    }
}
