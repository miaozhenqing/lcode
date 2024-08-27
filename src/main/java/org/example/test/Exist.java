package org.example.test;

public class Exist {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        char[][] visited = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrace(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrace(char[][] board, int i, int j, String word, int index, char[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i > board.length - 1 || j > board[0].length - 1 || i < 0 || j < 0) {
            return false;
        }
        if (visited[i][j] == 1) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = 1;
        boolean found = backtrace(board, i - 1, j, word, index + 1, visited)
                || backtrace(board, i, j + 1, word, index + 1, visited)
                || backtrace(board, i + 1, j, word, index + 1, visited)
                || backtrace(board, i, j - 1, word, index + 1, visited);
        visited[i][j] = 0;
        return found;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'}
                , {'S', 'F', 'C', 'S'}
                , {'A', 'D', 'E', 'E'}
        };
        System.out.println(new Exist().exist(board, "ABCCED"));//true
        //测试用例:[["C","A","A"],["A","A","A"],["B","C","D"]]
        System.out.println(new Exist().exist(new char[][]{
                {'C', 'A', 'A'}
                , {'A', 'A', 'A'}
                , {'B', 'C', 'D'}
        }, "AAB"));//true

    }
}
