package org.example.test;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] v = new int[nums.length];
        dfs(nums, v, res);
        return list;
    }

    public void dfs(int[] nums, int[] v, List<Integer> res) {
        if (res.size() == nums.length) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (v[i] == 1) {
                continue;
            }
            res.add(nums[i]);
            v[i] = 1;
            dfs(nums, v, res);
            v[i] = 0;
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }
}
