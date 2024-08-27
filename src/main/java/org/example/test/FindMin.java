package org.example.test;

public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        //输入：nums = [3,4,5,1,2]
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(new FindMin().findMin(nums));//1
        nums = new int[]{4, 5, 6, 7, 0, 1, 2,3,4};
        System.out.println(new FindMin().findMin(nums));//0
    }


}
