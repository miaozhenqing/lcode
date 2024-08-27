package org.example.topinterview150;

public class _122MaxProfit {
    public static int maxProfit(int[] prices) {
        //dp[i][0]表示第i天不持有股票的最大利润:前一天已经没有股票，或前一天有股票，今天卖
        //dp[i][0]=dp[i-1][0]或者dp[i-1][1]+prices[i],求最大值
        //dp[i][1]表示第i天持有股票的最大利润：前一天有股票，或前一天没股票，今天买
        //dp[i][1]=dp[i-1][1]或dp[i-1][0]-prices[i]
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[dp.length-1][0];
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        int[] prices2 = {1,2,3,4,5};
        System.out.println(maxProfit(prices2));
    }
}
