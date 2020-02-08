package DFS;

public class WordSearch {

    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfsHelper(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsHelper(char[][] board, String word, int index, int i, int j) {

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        if (dfsHelper(board, word, index + 1, i + 1, j) ||
                dfsHelper(board, word, index + 1, i - 1, j) ||
                dfsHelper(board, word, index + 1, i, j + 1) ||
                dfsHelper(board, word, index + 1, i, j - 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
