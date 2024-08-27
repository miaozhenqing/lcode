package org.example.test;

import java.util.Arrays;

public class MaxEnvelopes {
    //   [[2,3], [5,4], [6,4], [6,7]]
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 0) {
            return 0;
        }
        if (envelopes.length == 1) {
            return 1;
        }
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) { // 若宽度不同，直接比较宽度
                return o1[0] - o2[0];
            } else { // 宽度相同，按照高度非递增排序
                return o2[1] - o1[1];
            }
        });
        System.out.println(Arrays.deepToString(envelopes));
        int[] dp = new int[envelopes.length];
        //初始为1
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //返回最大值
        return Arrays.stream(dp).max().getAsInt();
    }

    // envelopes = [[w, h], [w, h]...]
    public int maxEnvelopes1(int[][] envelopes) {
        int n = envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            return a[0] == b[0] ?
                    b[1] - a[1] : a[0] - b[0];
        });
        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++){
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    int lengthOfLIS(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] envelopes = {{3, 4}, {6, 4}, {6, 7}, {2, 3}};
                          //[[2,3], [5,4], [6,4], [6,7]]
                          //3,4,7,4

        System.out.println(new MaxEnvelopes().maxEnvelopes1(envelopes));
    }
}
