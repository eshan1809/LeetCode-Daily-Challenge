class Solution {
    public String tictactoe(int[][] moves) {
        if(moves.length < 5)
            return "Pending";
        
        String[][] ttt = new String[3][3];
        for(int i = 0; i < moves.length; i++)
            if(i % 2 == 0)
                ttt[moves[i][0]][moves[i][1]] = "A";
            else
                ttt[moves[i][0]][moves[i][1]] = "B";
        
        for(int i = 0; i < 3; i++)
            if(ttt[0][i] != null && ttt[0][i] == ttt[1][i] && ttt[0][i] == ttt[2][i])
                return ttt[0][i];
        
        for(int i = 0; i < 3; i++)
            if(ttt[i][0] != null && ttt[i][0] == ttt[i][1] && ttt[i][0] == ttt[i][2])
                return ttt[i][0];
        
        if(ttt[0][0] != null && ttt[0][0] == ttt[1][1] && ttt[0][0] == ttt[2][2])
            return ttt[0][0];
        if(ttt[0][2] != null && ttt[0][2] == ttt[1][1] && ttt[0][2] == ttt[2][0])
            return ttt[0][2];
        
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
