package org.example.topinterview150;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        /**
         * 示例 [1,2,3,4]
         * 输入：n = 4, k = 2
         * 输出：
         * [
         *   [2,4],
         *   [3,4],
         *   [2,3],
         *   [1,2],
         *   [1,3],
         *   [1,4],
         * ]
         */
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        backTrace(res, combine, 1, n, k);
        return res;
    }

    private void backTrace(List<List<Integer>> res, List<Integer> combine, int start, int n, int k) {
        if (combine.size() == k) {
            res.add(new ArrayList<>(combine));
            return;
        }
        for (int i = start; i <= n; i++) {
            combine.add(i);
            backTrace(res, combine, i + 1, n, k);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 2));
    }
}
