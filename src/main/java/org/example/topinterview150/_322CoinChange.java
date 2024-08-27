package org.example.topinterview150;

import java.util.Arrays;

public class _322CoinChange {

    public static int coinChange(int[] coins, int amount) {
        //coins = [1, 2, 5], amount = 11
        //f(i) 为金额i所需的最少金币个数
        //f(i)=f(i-1)+1、f(i-2)+1、f(i-5)+1 的最小值
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }

        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
        int[] coins1 = {2};
        System.out.println(coinChange(coins1, 3));
        int[] coins2 = {1};
        System.out.println(coinChange(coins2, 0));
    }
}
