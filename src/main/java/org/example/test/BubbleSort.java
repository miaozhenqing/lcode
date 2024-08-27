package org.example.test;

public class BubbleSort {//n^2
    private static void bubbleSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1)
            return;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                doPrint(array);
            }
            System.out.println("-----------------");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 8,7,6,5,4};
        bubbleSort(array);
        doPrint(array);
    }

    private static void doPrint(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    private static void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
