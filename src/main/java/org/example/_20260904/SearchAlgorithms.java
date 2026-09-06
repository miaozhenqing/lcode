package org.example._20260904;

public class SearchAlgorithms {

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = arr[mid];
            if (midValue == target) {
                return mid;
            } else if (target < midValue) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
