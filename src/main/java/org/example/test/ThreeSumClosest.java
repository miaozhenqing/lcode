package org.example.test;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right && nums[left] + nums[right] + nums[i] < target) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                left++;
            }
            while (left < right && nums[left] + nums[right] + nums[i] > target) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                right--;
            }
            while (left < right && nums[left] + nums[right] + nums[i] == target) {
                closest = target;
                left++;
                right--;
            }
        }
        return closest;
    }
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int best = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    int a = right - 1;
                    while (a > left && nums[right] == nums[a]) {
                        a--;
                    }
                    right = a;
                } else {
                    int b = left + 1;
                    while (right > b && nums[left] == nums[b]) {
                        b++;
                    }
                    left = b;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(new ThreeSumClosest().threeSumClosest2(nums, 1));
//        int[] nums2 = new int[]{0, 1, 2};
//        System.out.println(new ThreeSumClosest().threeSumClosest(nums2, 3));
    }
}
