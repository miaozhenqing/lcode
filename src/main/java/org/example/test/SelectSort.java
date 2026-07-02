package org.example.test;

import java.util.Arrays;
import org.example.common.CommonUtil;

public class SelectSort {
    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                CommonUtil.swap(array, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 1, 8, 7, 2};
        System.out.println(Arrays.toString(array));
        System.out.println("----------------");
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
