package org.example.test;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        int start = 0;
        int end = 0;
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        while (end < nums.length) {
            if (end == nums.length - 1 || nums[end + 1] != nums[end] + 1) {
                builder.append(nums[start]);
                builder.append(nums[end]);
                end = end + 1;
                start = end;
                list.add(builder.toString());
                builder = new StringBuilder();
            } else {
                end++;
            }
        }
        return list;
    }

    public static List<String> summaryRanges2(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges2(nums));//["0->2","4->5","7"]
    }
}
