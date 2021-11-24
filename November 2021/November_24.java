class Solution {
    public class Pair {
        int st, et;
        Pair(int a, int b) {
            st = a;
            et = b;
        }
    }
    
    public int[][] intervalIntersection(int intervalList1[][], int intervalList2[][]) {
        List<Pair> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < intervalList1.length && j < intervalList2.length){
            int st = Math.max(intervalList1[i][0], intervalList2[j][0]);
            int et = Math.min(intervalList1[i][1], intervalList2[j][1]);
            if(st <= et)
                list.add(new Pair(st, et));
            if(et == intervalList1[i][1])
                i++;
            else
                j++;
        }
        int[][] arr = new int[list.size()][2];
        for(i = 0; i < list.size(); i++){
            arr[i][0] = list.get(i).st;
            arr[i][1] = list.get(i).et;
        }
        return arr;
    }
}
