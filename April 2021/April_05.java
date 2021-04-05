class Solution {
    public boolean isIdealPermutation(int[] A) {
        int gi = 0, li = 0;
        for(int i = 0; i < A.length-1; i++){
            for(int j = i+1; j < A.length; j++) if(A[i] > A[j]) gi++;
            if(A[i] > A[i+1]) li++;
        }
        return gi == li;
    }
}
