class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> po1 = new ArrayList<>(), po2 = new ArrayList<>(), list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int n1 = 1, n2 = 1;
        if(x != 1)
            while(n1 < bound){
                po1.add(n1);
                n1 *= x;
            }
        else po1.add(1);
        if(y != 1)
            while(n2 < bound){
                po2.add(n2);
                n2 *= y;
            }
        else po2.add(1);
        for(int i : po1){
            for(int j : po2){
                if(i + j <= bound) set.add(i + j);
                else break;
            }
        }
        for(int i : set) list.add(i);
        Collections.sort(list);
        return list;
    }
}
