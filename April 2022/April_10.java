class Solution {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        for(String op : ops){
            if(op.equals("C"))
                list.remove(list.size() - 1);
            else if(op.equals("D"))
                list.add(2 * list.get(list.size() - 1));
            else if(op.equals("+"))
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            else
                list.add(Integer.parseInt(op));
        }
        int ans = 0;
        for(int i : list)
            ans += i;
        return ans;
    }
}
