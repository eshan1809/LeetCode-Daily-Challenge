class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return helper(arr, start, visited);
    }
    
    public boolean helper(int[] arr, int start, boolean[] visited){
        if(arr[start] == 0)
            return true;
        if(visited[start])
            return false;
        
        visited[start] = true;
        boolean b1 = false, b2 = false;
        if(start + arr[start] < arr.length)
            b1 = helper(arr, start + arr[start], visited);
        if(start - arr[start] >= 0
           b2 = helper(arr, start - arr[start], visited);
        return (b1 || b2);
    }
}
