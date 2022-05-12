class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        helper(nums.length, nums, new ArrayList<>(), map);
        return list;
    }
    
    List<List<Integer>> list;
    
    private void helper(int n, int[] nums, List<Integer> al, Map<Integer, Integer> map){
        if(map.isEmpty()){
            list.add(new ArrayList<>(al));
            return;
        }
        
        Map<Integer, Integer> nmap = new HashMap<>(map);
        for(int i : map.keySet()){
            int f = map.get(i);
            if(f == 1){
                nmap.remove(i);
                al.add(i);
                helper(n, nums, al, nmap);
                al.remove(al.size() - 1);
                nmap.put(i, 1);
            } else{
                nmap.put(i, f - 1);
                al.add(i);
                helper(n, nums, al, nmap);
                al.remove(al.size() - 1);
                nmap.put(i, f);
            }
        }
    }
}
