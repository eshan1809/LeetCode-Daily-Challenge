class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] ch = dominoes.toCharArray();
        int[] forces = new int[n];
        int force = 0;
        for(int i = 0; i < n; i++){
            if(ch[i] == 'R') force = n;
            else if(ch[i] == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] = force;
        }
        for(int i = n - 1; i >= 0; i--){
            if(ch[i] == 'L') force = n;
            else if(ch[i] == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] -= force;
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(forces[i] > 0)
                str.append('R');
            else if(forces[i] < 0)
                str.append('L');
            else
                str.append('.');
        }
        return str.toString();
    }
}
