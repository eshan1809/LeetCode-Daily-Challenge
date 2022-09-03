class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        list = new ArrayList();
        for(int i = 1; i < 10; i++)
            solution(n - 1, k, i);
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i++)
            arr[i] = list.get(i);
        return arr;
    }
    
    List<Integer> list;
    
    public void solution(int n, int k, int num){
        if(n == 0){
            list.add(num);
            return;
        }
        int prev = num % 10;
        if(k == 0)
            solution(n - 1, k, num * 10 + prev);
        else{
            if(prev + k < 10)
                solution(n - 1, k, num * 10 + prev + k);
            if(prev - k >= 0)
                solution(n - 1, k, num * 10 + prev - k);
        }
    }
}
