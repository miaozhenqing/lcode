package org.example.test;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>(intervals.length);
        for (int i = 0; i < intervals.length; i++) {
            if (list.isEmpty()) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                int[] last = list.get(list.size() - 1);
                if (last[1] < intervals[i][0]) {
                    list.add(new int[]{intervals[i][0], intervals[i][1]});
                } else {
                    last[1] = Math.max(last[1], intervals[i][1]);
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }


    public static void main(String[] args) {
        int[][] array = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(JSONObject.toJSONString(merge(array)));//[[1,6],[8,10],[15,18]]
        int[][] array2 = {{1, 4}, {4, 5}};
        System.out.println(JSONObject.toJSONString(merge(array2)));//[[1,5]]
        int[][] array3 = {};
        System.out.println(JSONObject.toJSONString(merge(array3)));//[[]]
        int[][] array4 = {{1, 3}};
        System.out.println(JSONObject.toJSONString(merge(array4)));//[[1,3]]
        int[][] array5 = {{1, 4}, {5, 6}};
        System.out.println(JSONObject.toJSONString(merge(array5)));//[[1,4],[5,6]]
        int[][] array6 = {{1, 4}, {2, 3}};
        System.out.println(JSONObject.toJSONString(merge(array6)));//[[1,4]]
    }
}
