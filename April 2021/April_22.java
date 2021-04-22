class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list : wall){
            int val = 0;
            for(int i = 0; i < list.size(); i++){
                if(i != list.size() - 1){
                    val += list.get(i);
                    map.put(val, map.getOrDefault(val, 0) + 1);
                }
            }
        }
        int max = 0;
        for(int i: map.keySet()) max = Math.max(max, map.get(i));
        return wall.size() - max;
    }
}
