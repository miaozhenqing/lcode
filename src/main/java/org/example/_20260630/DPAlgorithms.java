package org.example._20260630;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 动态规划
 */
public class DPAlgorithms {
    // -------------------------- 简单难度 --------------------------

    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @param n 楼梯阶数
     * @return 不同的方法数
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        //dp[i]=dp[i-1]+ dp[i-2]
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
     * 设计一个算法来计算你所能获取的最大利润。
     * @param prices 股票价格数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        //第i天不持有股票收益:dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0])
        //第i天持有股票收益:dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i])
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 不持有股票
            dp[i][0] = Math.max(
                    dp[i - 1][0],
                    dp[i - 1][1] + prices[i]
            );
            // 持有股票
            dp[i][1] = Math.max(
                    dp[i - 1][1],
                    dp[i - 1][0] - prices[i]
            );
        }
        //最后一天一定要卖出才是利润最大
        return dp[n - 1][0];
    }

    /**
     * 53. 最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * @param nums 整数数组
     * @return 最大子数组和
     */
    public int maxSubArray(int[] nums) {
        //2,4,-8,6,7,1,
        //dp[i]=Math.max(dp[i-1]+nums[i],nums[i])
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * @param nums 每个房屋的现金数额
     * @return 不触动警报装置的情况下，一夜之内能够偷窃到的最高金额
     */
    public int rob(int[] nums) {
        //1,2,3,4,5,6
        //第i个房间总收益：dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(
                    dp[i - 1],
                    dp[i - 2] + nums[i]
            );
        }
        return dp[n - 1];
    }

    // -------------------------- 中等难度 --------------------------

    /**
     * 62. 不同路径
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * @param m 网格行数
     * @param n 网格列数
     * @return 不同路径数
     */
    public int uniquePaths(int m, int n) {
        //dp[i][j]表示达到i,j的路径数
        //dp[i][j]=dp[i][j-1]+dp[i-1][j]

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 64. 最小路径和
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     * @param grid 网格
     * @return 最小路径和
     */
    public int minPathSum(int[][] grid) {
        //dp[i][j]表示达到i,j的最小和
        //dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 152. 乘积最大子数组
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
     * 并返回该子数组所对应的乘积。
     * @param nums 整数数组
     * @return 最大乘积
     */
    public int maxProduct(int[] nums) {

        return 0;
    }

    /**
     * 300. 最长递增子序列
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * @param nums 整数数组 nums = [10,9,2,5,3,7]
     * @return 最长递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        //dp[i] 表示 以 nums[i] 结尾的最长递增子序列长度
        //
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 1143. 最长公共子序列
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 最长公共子序列长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        return 0;
    }

    // -------------------------- 困难难度 --------------------------

    /**
     * 123. 买卖股票的最佳时机 III
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * @param prices 股票价格数组
     * @return 最大利润
     */
    public int maxProfitIII(int[] prices) {
        return 0;
    }

    /**
     * 188. 买卖股票的最佳时机 IV
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。(一买一卖)
     * @param k 最大交易次数
     * @param prices 股票价格数组
     * @return 最大利润
     */
    public int maxProfitIV(int k, int[] prices) {
        //dp[i][j][0]：第i天结束，完成j次交易，未持有
        //dp[i][j][1]：第i天结束，完成j次交易，持有
        //dp[i][j][0] = Math.max(dp[i-1][j-1][1]+prices[i],dp[i-1][j][0])
        //dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j][0]-prices[i])

        int n = prices.length;

        int[][][] dp = new int[n][k][2];

        // 初始化为负无穷
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = Integer.MIN_VALUE / 2;
                dp[i][j][1] = Integer.MIN_VALUE / 2;
            }
        }

        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                // 不持股
                if (j == 0) {
                    dp[i][0][0] = dp[i - 1][0][0];
                } else {
                    dp[i][j][0] = Math.max(
                            dp[i - 1][j][0],
                            dp[i - 1][j - 1][1] + prices[i]
                    );
                }

                // 持股
                dp[i][j][1] = Math.max(
                        dp[i - 1][j][1],
                        dp[i - 1][j][0] - prices[i]
                );
            }
        }
        int ans = 0;
        for (int j = 0; j <= k; j++) {
            ans = Math.max(ans, dp[n - 1][j][0]);
        }


        return 0;
    }

    /**
     * 239. 滑动窗口最大值
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     * @param nums 整数数组
     * @param k 滑动窗口大小
     * @return 滑动窗口最大值数组
     *
     * nums = [1,3,-1,-3,5,3,6,7]
     * k = 3
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        //这种写法复杂度过高
//        int[] ans = new int[nums.length - k + 1];
//        int idx = 0;
//        for (int i = 0; i < nums.length - k; i++) {
//            int max = nums[i];
//            for (int j = i; j < i + k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            ans[idx++] = max;
//        }

        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            //删除已经离开队列的元素
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            //删除队尾所有比当前元素小的下标
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            //当前元素加入队尾
            deque.offerLast(i);
            //窗口形成后记录答案
            if (i >= k - 1) {
                ans[index++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        // 存放下标
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // ① 删除已经离开窗口的元素
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // ② 删除队尾所有比当前元素小的下标
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // ③ 当前元素加入队尾
            deque.offerLast(i);

            // ④ 窗口形成后记录答案
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }

    /**
     * 32. 最长有效括号
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * @param s 括号字符串
     * @return 最长有效括号长度
     */
    public int longestValidParentheses(String s) {
        return 0;
    }

    /**
     * 72. 编辑距离
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数。
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * @param word1 单词1
     * @param word2 单词2
     * @return 最少操作数
     */
    public int minDistance(String word1, String word2) {
        return 0;
    }
}