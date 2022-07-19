class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            List<Integer> al = new ArrayList<>();
            al.add(1);
            for(int j = 2; j < i; j++)
                al.add(list.get(i - 2).get(j - 2) + list.get(i - 2).get(j - 1));
            if(i > 1)
                al.add(1);
            list.add(al);
        }
        return list;
    }
}
