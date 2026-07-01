package org.example;

/**
 *
 * @author mzq
 * @date 2026/6/30 15:18
 */
public class CommonUtil {
    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
