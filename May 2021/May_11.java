class Solution {
    public int maxScore(int[] cardPoints, int k) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        int sum1 = 0, sum2 = 0, l = 0, r = 0, sum = 0;
        for(int i = 0; i < k; i++){
            list1.add(cardPoints[i]);
            sum1 += cardPoints[i];
        }
        for(int i = cardPoints.length - 1; i >= cardPoints.length - k; i--){
            list2.add(cardPoints[i]);
            sum2 += cardPoints[i];
        }
        while(k-- > 0){
            if(sum1 > sum2){
                sum += list1.get(l);
                sum1 -= list1.get(l++);
                sum2 -= list2.get(list2.size() - 1);
                list2.remove(list2.size() - 1);
            } else{
                sum += list2.get(r);
                sum2 -= list2.get(r++);
                sum1 -= list1.get(list1.size() - 1);
                list1.remove(list1.size() - 1);
            }
        }
        return sum;
    }
}
