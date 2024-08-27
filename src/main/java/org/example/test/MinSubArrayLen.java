package org.example.test;

public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int minLength = Integer.MAX_VALUE; // 初始化最小长度为最大整数
        int sum = 0; // 记录当前子数组的和
        int left = 0; // 子数组的左边界
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // 将当前元素加到sum中

            while (sum >= target) { // 如果sum大于等于target，更新最小长度并且移动左边界
                minLength = Math.min(minLength, right - left + 1); // 更新最小长度
                sum -= nums[left]; // 将左边界元素从sum中移除
                left++; // 移动左边界
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength; // 如果minLength没有更新过，则返回0
    }
    public static int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
        int target2 = 4;
        int[] nums2 = new int[]{1, 4, 4};
        System.out.println(minSubArrayLen(target2, nums2));
        int target3 = 11;
        int[] nums3 = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(target3, nums3));
    }
}
