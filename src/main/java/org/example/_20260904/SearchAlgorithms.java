package org.example._20260904;

public class SearchAlgorithms {

    //二分查找
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = arr[mid];
            if (midValue == target) {
                return mid;
            } else if (target < midValue) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    //33. 搜索旋转排序数组
    //4,5,6,7,1,2,3
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //左边部分有序
            if (nums[start] <= nums[mid]) {
                //是否在左半部分有序区间
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {//右边部分有序
                //是否在右边有序区间
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    //在排序数组中查找元素的第一个和最后一个位置
    //输入：nums = [5,7,7,8,8,10], target = 8
    //输出：[3,4]
    public int[] searchRange(int[] nums, int target) {
        int first = searchRange_findFirst(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = searchRange_findLast(nums, target);

        return new int[]{first, last};
    }

    private int searchRange_findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private int searchRange_findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

}
