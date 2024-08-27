package org.example.test;

import java.util.Arrays;

public class MergeSort {
    private void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        doMergeSort(array, 0, array.length - 1);
    }

    private void doMergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            doMergeSort(array, left, mid);
            doMergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] array1 = new int[len1];
        for (int i = 0; i < len1; i++) {
            array1[i] = array[left + i];
        }
        int[] array2 = new int[len2];
        for (int j = 0; j < len2; j++) {
            array2[j] = array[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int index = left;
        while (i < len1 && j < len2) {
            if (array1[i] <= array2[j]) {
                array[index] = array1[i];
                i++;
            } else {
                array[index] = array2[j];
                j++;
            }
            index++;
        }
        while (i < len1) {
            array[index] = array1[i];
            i++;
            index++;
        }
        while (j < len2) {
            array[index] = array2[j];
            j++;
            index++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 1, 8, 7, 2, 10, 5, 9, 3};
        new MergeSort().mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}

