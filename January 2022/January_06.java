class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> pickup = new HashMap<>(), drop = new HashMap<>();
        int people = 0, min = 1000, max = 0;
        for(int i = 0; i < trips.length; i++){
            pickup.put(trips[i][1], pickup.getOrDefault(trips[i][1], 0) + trips[i][0]);
            drop.put(trips[i][2], drop.getOrDefault(trips[i][2], 0) + trips[i][0]);
            min = Math.min(min, trips[i][1]);
            max = Math.max(max, trips[i][2]);
        }
        for(int i = min; i <= max; i++){
            people += pickup.getOrDefault(i, 0);
            people -= drop.getOrDefault(i, 0);
            if(people > capacity)
                return false;
        }
        return true;
    }
}
