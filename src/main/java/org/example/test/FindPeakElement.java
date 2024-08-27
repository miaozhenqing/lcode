package org.example.test;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findPeakUtil(nums, 0, nums.length - 1);
    }

    private static int findPeakUtil(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;

        if ((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1])) {
            return mid;
        }

        if (mid > 0 && nums[mid - 1] > nums[mid]) {
            return findPeakUtil(nums, left, mid - 1);
        }

        return findPeakUtil(nums, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new FindPeakElement().findPeakElement(nums));//2
        nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(new FindPeakElement().findPeakElement(nums));//1 or 5
    }
}
