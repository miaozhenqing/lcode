package org.example.test;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0][0] > target) {
            return false;
        }
        int highIndex = firstGreaterThan(matrix, target) - 1;
        if (highIndex < 0) {
            return false;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[highIndex][mid];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


    public static int firstGreaterThan(int[][] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7}
                , {10, 11, 16, 20}
                , {23, 30, 34, 50}};
        System.out.println(new SearchMatrix().searchMatrix(matrix, 3));//true
        System.out.println(new SearchMatrix().searchMatrix(matrix, 13));//false
        System.out.println(new SearchMatrix().searchMatrix(matrix, 50));//true
    }
}
