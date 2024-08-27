package org.example.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(res, nums, 0, new HashSet<>());
        return res;
    }

    public void backtrace(List<List<Integer>> res, int[] nums, int j, Set<Integer> added) {
        res.add(new ArrayList<>(added));
        for (int i = j; i < nums.length; i++) {
            added.add(nums[i]);
            backtrace(res, nums, i + 1, added);
            added.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));//[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    }
}
