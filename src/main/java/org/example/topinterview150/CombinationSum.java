package org.example.topinterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int tmpSum, int start) {
        if (tmpSum > target) {
            return;
        }
        if (tmpSum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int value = candidates[i];
            list.add(value);
            tmpSum += value;
            backTrack(res, list, candidates, target, tmpSum, i);
            list.remove(list.size() - 1);
            tmpSum -= value;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates, target));
        //再给一个例子：[2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60]
        //499
//        int[] candidates2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60};
//        int target2 = 499;
//        System.out.println(new CombinationSum().combinationSum(candidates2, target2));
    }
}
