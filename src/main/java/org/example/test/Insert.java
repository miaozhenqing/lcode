package org.example.test;


import java.util.Arrays;
import java.util.stream.Stream;

public class Insert {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] array = Stream.concat(Arrays.stream(intervals), Stream.of(newInterval)).toArray(int[][]::new);
        return Merge.merge(array);
    }


    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));//[[1,5],[6,9]]
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        System.out.println(Arrays.deepToString(insert(intervals2, newInterval2)));//[[1,2],[3,10],[12,16]]
    }
}
