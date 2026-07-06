package org.example.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonUtil {

    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @SafeVarargs
    public static <T> List<T> listOf(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }


    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("(empty tree)");
            return;
        }
        int height = getHeight(root);
        int width = (1 << height) - 1;
        String[][] grid = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = " ";
            }
        }
        fill(grid, root, 0, 0, width - 1);
        for (int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < width; j++) {
                sb.append(grid[i][j]);
            }
            System.out.println(sb.toString());
        }
    }


    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void fill(String[][] grid, TreeNode node, int level, int left, int right) {
        if (node == null) {
            return;
        }
        int mid = (left + right) / 2;
        grid[level][mid] = String.valueOf(node.val);
        fill(grid, node.left, level + 1, left, mid - 1);
        fill(grid, node.right, level + 1, mid + 1, right);
    }


}
