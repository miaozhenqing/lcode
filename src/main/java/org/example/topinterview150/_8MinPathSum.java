package org.example.topinterview150;


public class _8MinPathSum {
    public static int minPathSum(int[][] grid) {
        int length = grid.length;
        int height = grid.length > 0 ? grid[0].length : 0;

//        int[][] temp = new int[length][height];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                int tempL = 0;
                int tempH = 0;
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    tempL = grid[0][j - 1];
                    tempH = Integer.MAX_VALUE;
                } else if (j == 0) {
                    tempL = Integer.MAX_VALUE;
                    tempH = grid[i - 1][0];
                } else {
                    tempL = grid[i - 1][j];
                    tempH = grid[i][j - 1];
                }
                grid[i][j] = grid[i][j] + Math.min(tempL, tempH);
                System.out.println();
            }
        }
        return grid[length - 1][height - 1];
    }


    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 3, 1}
                , {1, 5, 1}
                , {4, 2, 1}
        };
        System.out.println(minPathSum(nums));//7
        int[][] nums2 = new int[][]{
                {1, 2, 3}
                , {4, 5, 6}
        };
        System.out.println(minPathSum(nums2));//12
    }
}
