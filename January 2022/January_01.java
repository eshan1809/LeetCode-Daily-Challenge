class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < time.length; i++)
            map.put(time[i] % 60, map.getOrDefault(time[i] % 60, 0) + 1);
        int count = 0;
        for(int i : map.keySet())
            if(i < 30 && i != 0)
                count += map.get(i) * map.getOrDefault(60 - i, 0);
        if(map.containsKey(0))
            count += (map.get(0) * (map.get(0) - 1)) / 2;
        if(map.containsKey(30))
            count += (map.get(30) * (map.get(30) - 1)) / 2;
        return count;
    }
}
