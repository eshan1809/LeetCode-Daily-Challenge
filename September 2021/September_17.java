class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        for(int num: nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for(int num: nums2){
            if(map.containsKey(num)){
                list.add(num);
                int freq = map.get(num);
                if(freq == 1)
                    map.remove(num);
                else
                    map.put(num, freq - 1);
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for(int num : list)
            ans[i++] = num;
        return ans;
    }
}
