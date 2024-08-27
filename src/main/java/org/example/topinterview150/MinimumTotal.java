package org.example.topinterview150;

import com.google.common.collect.Lists;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        /**
         * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
         * 输出：11
         * 解释：如下面简图所示：
         *    2
         *   3 4
         *  6 5 7
         * 4 1 8 3
         */
        //f(i)(j) 为该处数字的最小路径和
        //f(i)(j)=f(i-1)(j-1) 和 f(i-1)(j) 的最小值 + triangle(i)(j)
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        //给dp每个位置设置初始值为int最大
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[dp.length - 1].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
        }
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 1; j < triangle.get(i).size(); j++) {
                int left = dp[i - 1][j - 1];
                int right = dp[i - 1][j];
                int cur = triangle.get(i).get(j);
                int tmpMin = Math.min(left, right) + cur;
                dp[i][j] = tmpMin;
            }
        }
        int min = dp[dp.length - 1][0];
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            min = Math.min(dp[dp.length - 1][i], min);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = Lists.newArrayList(Lists.newArrayList(2)
                , Lists.newArrayList(3, 4), Lists.newArrayList(6, 5, 7), Lists.newArrayList(4, 1, 8, 3));
        System.out.println(new MinimumTotal().minimumTotal(triangle));
    }
}
