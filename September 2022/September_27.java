class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int n = arr.length;
        Queue<Pair> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(arr[i] == 'L' && i > 0 && arr[i - 1] == '.')
                q.add(new Pair('L', i - 1));
            else if(arr[i] == 'R' && i + 1 < n && arr[i + 1] == '.')
                q.add(new Pair('R', i + 1));
        }
        while(!q.isEmpty()){
            int size = q.size();
            Set<Integer> done = new HashSet<>();
            while(size-- > 0){
                Pair rem = q.remove();
                if(arr[rem.pos] == '.'){
                    arr[rem.pos] = rem.dir;
                    done.add(rem.pos);
                    if(rem.dir == 'L' && rem.pos > 0)
                        q.add(new Pair('L', rem.pos - 1));
                    else if(rem.dir == 'R' && rem.pos + 1 < n)
                        q.add(new Pair('R', rem.pos + 1));
                } else if(arr[rem.pos] != rem.dir && done.contains(rem.pos))
                    arr[rem.pos] = '.';
            }
        }
        return String.valueOf(arr);
    }
    
    class Pair{
        int pos;
        char dir;
        Pair(char dir, int pos){
            this.dir = dir;
            this.pos = pos;
        }
    }
}
