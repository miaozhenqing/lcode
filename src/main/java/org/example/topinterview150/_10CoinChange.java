package org.example.topinterview150;

public class _10CoinChange {
    /**
     * f(n)表示凑满n钱需要最少硬币数量
     * f(n)=f(n-1)+2 =27
     * f(n)=f(n-1)+5 =27
     * f(n)=f(n-1)+7 =27
     * <p>
     * <p>
     * f(n-1)=f(n-2)+2 =27
     * f(n-1)=f(n-2)+5 =27
     * f(n-1)=f(n-2)+7 =27
     */
    public static int coinChange(int[] nums, int target) {
        int[] count = new int[target];
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 1 : -1;
        }
        for (int i = 1; i < count.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                count[i]=Math.min(count[i-nums[j]]+1, count[i]);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 7};
        System.out.println(coinChange(nums, 27));
    }
}
