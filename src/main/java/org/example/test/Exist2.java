package org.example.test;

public class Exist2 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int pos) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (visited[row][col] || board[row][col] != word.charAt(pos)) {
            return false;
        }

        if (pos == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;

        boolean result = dfs(board, word, visited, row + 1, col, pos + 1) ||
                dfs(board, word, visited, row - 1, col, pos + 1) ||
                dfs(board, word, visited, row, col + 1, pos + 1) ||
                dfs(board, word, visited, row, col - 1, pos + 1);

        visited[row][col] = false;

        return result;
    }

    public static void main(String[] args) {
        Exist2 exist = new Exist2();
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));//true
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));//true
    }
}
