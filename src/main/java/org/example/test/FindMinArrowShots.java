package org.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinArrowShots {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return a1[1] > a2[1] ? 1 : -1;
            }
            return a1[0] > a2[0] ? 1 : -1;
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            if (list.isEmpty()) {
                list.add(new int[]{points[i][0], points[i][1]});
            } else {
                int[] last = list.get(list.size() - 1);
                //有交集
                if (points[i][0] <= last[1]) {
                    last[0] = Math.max(points[i][0], last[0]);
                    last[1] = Math.min(points[i][1], last[1]);
                } else {
                    list.add(new int[]{points[i][0], points[i][1]});
                }
            }
        }
        return list.size();
    }

    public static int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (point1, point2) -> {
            if (point1[1] > point2[1]) {
                return 1;
            } else if (point1[1] < point2[1]) {
                return -1;
            } else {
                return 0;
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

    public static int findMinArrowShots3(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return a1[1] > a2[1] ? 1 : -1;
            }
            return a1[0] > a2[0] ? 1 : -1;
        });
        int right = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= right) {
                right = Math.min(right, points[i][1]);
            } else {
                count++;
                right = points[i][1];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] array = {{1, 6}, {2, 8}, {7, 12}, {10, 16}};
        System.out.println(findMinArrowShots3(array));//2
        int[][] array2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(findMinArrowShots3(array2));//4
        int[][] array3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(findMinArrowShots3(array3));//2
    }
}
