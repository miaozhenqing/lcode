package org.example.group;

import java.util.Arrays;

/**
 * 数组和字符串相关算法
 */
public class ArrayAndString {

    public static void main(String[] args) {
        ArrayAndString test = new ArrayAndString();
        //合并两个有序数组
//        int[] ints = {1, 2, 3, 0, 0, 0};
//        int[] ints1 = {2, 5, 6};
//        test.merge(ints, 3, ints1, 3);
//        System.out.println(Arrays.toString(ints));
//        //输入：nums1 = [1], m = 1, nums2 = [], n = 0
//        //输出：[1]
//        ints = new int[]{1};
//        ints1 = new int[]{};
//        test.merge(ints, 1, ints1, 0);
//        System.out.println(Arrays.toString(ints));
//        //输入：nums1 = [0], m = 0, nums2 = [1], n = 1
//        //输出：[1]
//        ints = new int[]{0};
//        ints1 = new int[]{1};
//        test.merge(ints, 0, ints1, 1);

        //删除有序数组中的重复项
//        int[] ints = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
//        System.out.println(test.removeDuplicates(ints));//5

        //删除有序数组中的重复项
        //输入：nums = [1,1,1,2,2,3]
        //输出：5, nums = [1,1,2,2,3]
//        int[] ints = {1, 1, 1, 2, 2, 3};
//        System.out.println(test.removeDuplicatesII(ints));

        //轮转数组
        //输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]
//        int[] ints = {1, 2, 3, 4, 5, 6, 7};
//        test.rotate(ints, 3);
//        System.out.println(Arrays.toString(ints));

        //买卖股票的最佳时机
//        int[] ints = {7, 1, 5, 3, 6, 4};
//        System.out.println(test.maxProfit(ints));//5

        //买卖股票的最佳时机 II
        //输入：prices = [7,1,5,3,6,4]
        //输出：7
//        int[] ints = {7, 1, 5, 3, 6, 4};
//        System.out.println(test.maxProfitII_2(ints));

        //跳跃游戏
        //输入：nums = [2,3,1,1,4]
        //输出：true
//        int[] ints = {2, 3, 1, 1, 4};
//        System.out.println(test.canJump(ints));
//        //输入：nums = [3,2,1,0,4]
//        //输出：false
//        int[] ints1 = {3, 2, 1, 0, 4};
//        System.out.println(test.canJump(ints1));

        //跳跃游戏 II
        //输入: nums = [2,3,1,1,4]
        //输出: 2
//        int[] ints = {2, 3, 1, 1, 4};
//        System.out.println(test.jump(ints));
//        //输入: nums = [2,3,0,1,4]
//        //输出: 2
//        int[] ints2 = {2, 3, 0, 1, 4};
//        System.out.println(test.jump(ints2));
    }

    /**
     * H 指数
     * 数组中有h个不小于h的值，求最大的
     */
    public int hIndex(int[] citations) {
        //[6, 5, 3, 1, 0]
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (i>=0&&citations[i]>i){

            }
        }
        //todo 待续 2025 11 15
        return 0;
    }

    /**
     * 跳跃游戏 II
     */
    public int jump(int[] nums) {
        int maxIndex = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, nums[i] + i);
            if (end == i) {
                end = maxIndex;
                step++;
            }
        }
        return step;
    }

    /**
     * 跳跃游戏
     */
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int length = nums.length;
        int maxIndex = 0;
        for (int i = 0; i < length; i++) {
            //如果当前位置已经超过能到达的最远位置，返回 false
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(i + nums[i], maxIndex);
            if (maxIndex >= length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 买卖股票的最佳时机 II
     * 计算上升趋势的差值
     */
    public int maxProfitII_2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int p = prices[i] - prices[i - 1];
            if (p > 0) {
                sum += p;
            }
        }
        return sum;
    }

    /**
     * 买卖股票的最佳时机 II
     * 动态规划
     */
    public int maxProfitII(int[] prices) {
        //输入：prices = [7,1,5,3,6,4]
        //输出：7
        //dp[i][0] 第i天手里没股票最大利润:前一天已经没有股票，或当天有股票并卖出,两者取最大
        //dp[i][0]=Math.max(dp[i-1][0],dp[i- 1][1]+prices[i])
        //dp[i][1] 第i天手机有股票的最大利润:前一天有股票，或当天买入股票，两者取最大
        //dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i])
        if (prices == null || prices.length <= 1) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }


    /**
     * 买卖股票的最佳时机
     */
    public int maxProfit(int[] prices) {
        //输入：[7,1,5,3,6,4]
        //输出：5
        int minPrice = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > max) {
                max = price - minPrice;
            }
        }
        return max;
    }

    /**
     * 轮转数组
     */
    public void rotate(int[] nums, int k) {
        //新位置为：(i+k) mod n
        int[] newNum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNum[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(newNum, 0, nums, 0, nums.length);
    }

    /**
     * 删除有序数组中的重复项 II
     * (出现次数超过两次的元素只出现两次)
     */
    public int removeDuplicatesII(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 2;
        int j = i;
        while (j < nums.length) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    /**
     * 删除有序数组中的重复项
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = i + 1;
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        return ++i;
    }

    /**
     * 合并两个有序数组
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        //输出：[1,2,2,3,5,6]
        //把大的元素从nums1后面添加
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }

}
