package org.example._20260904;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BtAlgorithms {

    //全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permute_bt(nums, res, new ArrayList<>(), used);
        return res;
    }

    public void permute_bt(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {  // 遍历索引
            if (used[i]) {                         // 用索引标记
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            permute_bt(nums, res, path, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


    //子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets_bt(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void subsets_bt(int[] nums, List<List<Integer>> res, List<Integer> path, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            subsets_bt(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }


    //组合总和
    //输入: candidates = [2,3,5], target = 8
    //输出: [[2,2,2,2],[2,3,3],[3,5]]
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        combinationSum_bt(nums, res, new ArrayList<>(), 0, target, 0);
        return res;
    }

    public void combinationSum_bt(int[] nums, List<List<Integer>> res, List<Integer> path, int sum, int target, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] + sum > target) {
                break;
            }
            path.add(nums[i]);
            sum += nums[i];
            combinationSum_bt(nums, res, path, sum, target, i);
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }

    //括号生成
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis_bt(n, res, new ArrayList<>(), 0, 0);
        return res;
    }

    public void generateParenthesis_bt(int n, List<String> res, List<Character> path, int leftCount, int rightCount) {
        if (path.size() == 2 * n) {
            StringBuilder sb = new StringBuilder(path.size());
            for (Character c : path) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }
        //左<=n 右<=左
        if (leftCount < n) {
            path.add('(');
            generateParenthesis_bt(n, res, path, leftCount + 1, rightCount);
            path.remove(path.size() - 1);
        }
        if (rightCount < leftCount) {
            path.add(')');
            generateParenthesis_bt(n, res, path, leftCount, rightCount + 1);
            path.remove(path.size() - 1);
        }
    }
}
