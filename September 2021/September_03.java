class Solution {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if(n < 4)
            return trees;
        Set<int[]> set = new HashSet<>();
        int lmt = 0;
        for(int i = 1; i < n; i++)
            if(trees[i][0] < trees[lmt][0])
                lmt = i;
        int idx = lmt;
        while(true){
            int idx2 = idx == n - 1 ? 0 : idx + 1;
            for(int i = 0; i < n; i++)
                if(leftMost(trees[idx], trees[idx2], trees[i]) > 0)
                    idx2 = i;
            for(int i = 0; i < n; i++)
                if(i != idx && i != idx2 && leftMost(trees[idx], trees[idx2], trees[i]) == 0 && liesBetween(trees[idx], trees[i], trees[idx2]))
                    set.add(trees[i]);
            set.add(trees[idx]);
            idx = idx2;
            if(idx == lmt)
                break;
        }
        int[][] ans = new int[set.size()][2];
        int i = 0;
        for(int[] curr : set)
            ans[i++] = curr;
        return ans;
    }
    
    private int leftMost(int[] tree1, int[] tree2, int[] tree3){
        return (tree3[0] - tree1[0]) * (tree2[1] - tree1[1]) - (tree2[0] - tree1[0]) * (tree3[1] - tree1[1]);
    }
    
    private boolean liesBetween(int[] tree1, int[] tree2, int[] tree3){
        int dist12 = Math.abs(tree1[0] - tree2[0]) + Math.abs(tree1[1] - tree2[1]);
        int dist23 = Math.abs(tree3[0] - tree2[0]) + Math.abs(tree3[1] - tree2[1]);
        int dist13 = Math.abs(tree1[0] - tree3[0]) + Math.abs(tree1[1] - tree3[1]);
        return dist12 + dist23 == dist13;
    }
}
