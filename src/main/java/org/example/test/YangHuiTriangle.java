package org.example.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1
 * 1 # 1
 * 1 # 2 # 1
 * 1 # 3 # 3 # 1
 * 1 # 4 # 6 # 4 # 1
 */
public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int x = numRows;
        int y = numRows + numRows - 1;
        int[][] dp = new int[x][y];
        for (int i = 0; i < x; i++) {
            dp[i][0] = 1;
            dp[i][2 * i] = 1;
        }
        List<Integer> fist = new ArrayList<>();
        fist.add(1);
        result.add(fist);
        for (int i = 1; i < x; i++) {
            List<Integer> rows = new ArrayList<>();
            rows.add(dp[i][0]);
            for (int j = 2; j <= 2 * i; j++) {
                if (j % 2 == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 2];
                    rows.add(dp[i][j]);
                }
            }
            result.add(rows);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new YangHuiTriangle().generate(5));
    }
}
