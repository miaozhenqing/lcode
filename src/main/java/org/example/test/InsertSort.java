package org.example.test;

import java.util.Arrays;

public class InsertSort {
    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmpValue = array[i];
            int pos = findPos(array, 0, i - 1, tmpValue);
            for (int j = i; j > pos; j--) {
                array[j] = array[j - 1];
            }
            array[pos] = tmpValue;
        }
    }

    private static int findPos(int[] array, int from, int to, int target) {
        int left = from;
        int right = to;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left++;
            } else {
                right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 1, 8, 7, 2};
        System.out.println(Arrays.toString(array));
        System.out.println("----------------");
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
