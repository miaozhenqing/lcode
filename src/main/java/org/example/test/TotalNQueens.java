package org.example.test;

import java.util.ArrayList;
import java.util.List;

public class TotalNQueens {
    public int totalNQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(n, list, res, 0);
        return res.size();
    }

    private void backTrack(int n, List<Integer> list, List<List<Integer>> res, int start) {
        if (list.size() > 1) {
            Integer last1 = list.get(list.size() - 1);
            Integer last2 = list.get(list.size() - 2);
            boolean isValid = last1 > last2 + 1 || last1 < last2 - 1;
            if (!isValid) {
                return;
            }
            if (list.size() == n) {
                res.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            list.add(i);
            backTrack(n, list, res, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        TotalNQueens totalNQueens = new TotalNQueens();
        System.out.println(totalNQueens.totalNQueens(4));
    }
}
