package DFS;


/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */

// 用target word的第一个char决定是否要开始dfs，一旦开始了就要mark当前的visited为true，
// 同时用一个index的count去表示当前走到了word的第几个char，如果当前方向的字母不是index那里的char直接返回就行了
// 这题的关键在于以下这里的DFS，但是同一层里面要走四个方向，只要一个方向满足了就行了。
// 这题tricky的点在于如何判断找到了，index == word.length 这个是关键，如果有一边找到了就行，就可以往上返回true
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
