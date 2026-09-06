package org.example._20260904;

public class DPAlgorithms {

    //爬楼梯
    public int climbStairs(int n) {
        if (n <= 2) return n;
        //dp[i]=到达该阶有多少种
        //dp[i]=dp[i-1]+dp[i-2]
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    //最大子数组
    public int maxSubArray(int[] nums) {
        //dp[i]=Math.max(nums[i],nums[i]+dp[i-1])
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArrayV2(int[] nums) {
        int prev = nums[0];
        int max = prev;
        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(nums[i], nums[i] + prev);
            max = Math.max(max, prev);
        }
        return max;
    }

    //打家劫舍
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //dp[i]=Math.max(dp[i-1],dp[i-2]+num[i])
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public int robV2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //dp[i]=Math.max(dp[i-1],dp[i-2]+num[i])
        int prev2 = nums[0];
        int prev1 = Math.max(prev2, nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;

        }
        return prev1;
    }

}
