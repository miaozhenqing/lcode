package org.example.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        backTrack1(res, comb, candidates, target, 0, 0);
        return res;
    }

    private void backTrack1(List<List<Integer>> res, List<Integer> comb, int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (sum + candidate > target) {
                continue;
            }
            comb.add(candidate);
            sum += candidate;
            backTrack1(res, comb, candidates, target, sum, startIndex + 1);
            comb.remove(comb.size() - 1);
            sum -= candidate;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            dfs(candidates, i, len, target - candidates[i], path, res);

            path.removeLast();
        }
    }

}
