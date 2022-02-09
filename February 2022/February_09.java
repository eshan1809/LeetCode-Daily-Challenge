class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); 
        for(int num: nums)
          map.put(num, map.getOrDefault(num, 0) + 1);
        int count = 0;
        for(int num: map.keySet()){
            if(k == 0 && map.get(num) > 1)
              count++;
            if(k != 0 && map.containsKey(num + k))
              count++;
        }
        return count;
    }
}
