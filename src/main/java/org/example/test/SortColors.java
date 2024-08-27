package org.example.test;

import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] ints = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(ints);
        System.out.println(Arrays.toString(ints));// [0, 0, 1, 1, 2, 2]
    }
}
