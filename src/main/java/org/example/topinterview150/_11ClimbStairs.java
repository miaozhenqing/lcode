package org.example.topinterview150;

/**
 * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，爬到顶部的方法有多少种？
 */
public class _11ClimbStairs {
    /**
     * f(n)=f(n-1)+1
     * f(n)=f(n-1)+2
     */
    public static int climbStairs(int n) {
        int[] num = new int[n];
        if (n <= 2) {
            return n;
        }
        num[0] = 1;
        num[1] = 2;
        for (int i = 2; i < num.length; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
