package org.example._20260904;

import org.example.common.CommonUtil;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SortAlgorithms {

    public void quickSort(int[] arr) {

    }

    public void doQuickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int pIndex = partition(arr, l, r);
        doQuickSort(arr, l, pIndex - 1);
        doQuickSort(arr, pIndex + 1, r);
    }

    public int partition(int[] arr, int l, int r) {
        int pIndex = ThreadLocalRandom.current().nextInt(l, r + 1);
        int pValue = arr[pIndex];
        CommonUtil.swap(arr, pIndex, r);
        //1,2,5, 3,6 ,4
        //i左边为小于
        int i = l;
        int j = l;
        while (j < r) {
            if (arr[j] <= pValue) {
                CommonUtil.swap(arr, i, j);
                i++;
            }
            j++;
        }
        CommonUtil.swap(arr, i, r);
        return i;
    }

    public void doMergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        doMergeSort(nums, left, mid);
        doMergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int tmpIndex = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[tmpIndex++] = nums[i++];
            } else {
                tmp[tmpIndex++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[tmpIndex++] = nums[i++];
        }
        while (j <= right) {
            tmp[tmpIndex++] = nums[j++];
        }
        System.arraycopy(tmp, 0, nums, left, right - left + 1);
    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        //第k大=第n-k小
        int target = nums.length - k;
        while (true) {
            int p = partition(nums, left, right);
            if (p == target) {
                return nums[p];
            }
            if (target < p) {
                right = p - 1;
            } else {
                left = p + 1;
            }
        }
    }

}
