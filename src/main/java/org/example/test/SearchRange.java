package org.example.test;

public class SearchRange {
    public String searchRangeStr(int[] nums, int target) {
        int[] ints = searchRange(nums, target);
        return "[" + ints[0] + "," + ints[1] + "]";
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findMinIndex(nums, target);
        res[1] = findMaxIndex(nums, target);
        return res;
    }

    private int findMinIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private int findMaxIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(new SearchRange().searchRangeStr(nums, target));//[3,4]
        System.out.println(new SearchRange().searchRangeStr(new int[]{5, 7, 7, 8, 8, 10}, 6));//[-1,-1]
        System.out.println(new SearchRange().searchRangeStr(new int[]{}, 0));//[-1,-1]
    }
}
