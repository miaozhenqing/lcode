package org.example.topinterview150;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backTrack(res, n, board, 0);
        return res;
    }

    private void backTrack(List<List<String>> res, int n, char[][] board, int row) {
        if (row == n) {
            res.add(boardToString(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, board)) {
                board[row][i] = 'Q';
            } else {
                continue;
            }
            backTrack(res, n, board, row + 1);
            board[row][i] = '.';
        }
    }

    private List<String> boardToString(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] strings : board) {
            StringBuilder sb = new StringBuilder();
            for (char string : strings) {
                sb.append(string);
            }
            res.add(sb.toString());
        }
        return res;
    }

    private boolean isValid(int row, int i, char[][] board) {
        for (int j = 0; j < row; j++) {
            if (board[j][i] == 'Q') {
                return false;
            }
        }
        for (int j = row - 1, k = i - 1; j >= 0 && k >= 0; j--, k--) {
            if (board[j][k] == 'Q') {
                return false;
            }
        }
        for (int j = row - 1, k = i + 1; j >= 0 && k < board.length; j--, k++) {
            if (board[j][k] == 'Q') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int n = 4;
        System.out.println(new SolveNQueens().solveNQueens(n));
    }

}
