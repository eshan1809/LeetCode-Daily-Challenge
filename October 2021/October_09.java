class Solution {
    class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[26];
        }
    }

    static Node root;

    private void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Node();
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    private void search(Node curr, char[][] board, int r, int c, String ans, List<String> list,
            boolean[][] visited) {
        if (curr.isEnd){
            list.add(ans);
            curr.isEnd = false;
        }

        if (r < 0 || c < 0 || r == board.length || c == board[0].length || visited[r][c])
            return;

        char ch = board[r][c];
        visited[r][c] = true;
        if (curr.children[ch - 'a'] != null) {
            search(curr.children[ch - 'a'], board, r - 1, c, ans + ch, list, visited);
            search(curr.children[ch - 'a'], board, r, c - 1, ans + ch, list, visited);
            search(curr.children[ch - 'a'], board, r + 1, c, ans + ch, list, visited);
            search(curr.children[ch - 'a'], board, r, c + 1, ans + ch, list, visited);
        }
        visited[r][c] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();

        for (String word : words)
            insert(word);

        int n = board.length, m = board[0].length;
        List<String> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                search(root, board, i, j, "", list, visited);

        return list;
    }
}
