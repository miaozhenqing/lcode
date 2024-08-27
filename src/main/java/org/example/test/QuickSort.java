package org.example.test;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        System.out.println(Arrays.toString(array));
        System.out.println("----------------");
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 1, 8, 7, 2};
        System.out.println(Arrays.toString(array));
        System.out.println("----------------");
        quickSort3(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    private static void quickSort3(int[] arr, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition3(arr, low, high);
            quickSort3(arr, low, pivot - 1);
            quickSort3(arr, pivot + 1, high);
        }
    }

    private static int partition3(int[] arr, int low, int high) {
        int base = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= base) {
                high--;
            }
            swap(arr, low, high);
            while (low < high && arr[low] <= base) {
                low++;
            }
            swap(arr, low, high);
        }
        return low;
    }

    private static void quickSort2(int[] arr, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition2(arr, low, high);
            quickSort2(arr, low, pivot - 1);
            quickSort2(arr, pivot + 1, high);
        }
    }

    private static int partition2(int[] arr, int low, int high) {
        int pivotKey = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivotKey) {
                high--;
            }
            swap(arr, low, high);
            while (low < high && arr[low] <= pivotKey) {
                low++;
            }
            swap(arr, low, high);
        }
        return low;
    }
}
