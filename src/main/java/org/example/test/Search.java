package org.example.test;

public class Search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int minIndex = findMinIndex(nums);
        if (target >= nums[minIndex] && target <= nums[n - 1]) {
            return binarySearch(nums, minIndex, n - 1, target);
        } else {
            return binarySearch(nums, 0, minIndex - 1, target);
        }
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public int findMinIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        System.out.println(new Search().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));//4
//        System.out.println(new Search().search(new int[]{9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8}, 3));//-1
//        System.out.println(new Search().search(new int[]{1}, 0));//-1
//        //测试用例:[1,3]
//        System.out.println(new Search().search(new int[]{1, 3}, 0));//-1
//        System.out.println(new Search().search(new int[]{3, 1}, 0));//-1
        //测试用例:[5,1,3]
        //			5
        //	期望结果:0
        System.out.println(new Search().search(new int[]{5, 1, 3}, 5));//0
    }

}
