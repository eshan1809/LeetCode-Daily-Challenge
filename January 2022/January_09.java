class Solution {
    public boolean isRobotBounded(String instructions) {
        int dir = 0, x = 0, y = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(char ch : instructions.toCharArray()){
            if(ch == 'L')
                dir = (dir + 1) % 4;
            else if(ch == 'R')
                dir = (dir + 3) % 4;
            else{
                x += dirs[dir][0];
                y += dirs[dir][1];
            }
        }
        return (dir != 0) || (x == 0 && y == 0);
    }
}
