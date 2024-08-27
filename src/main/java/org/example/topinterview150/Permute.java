package org.example.topinterview150;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        /**
         * 输入：nums = [1,2,3]
         * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
         */
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> comb, int[] nums) {
        if (comb.size() == nums.length) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (comb.contains(value)) {
                continue;
            }
            comb.add(value);
            backTrack(res, comb, nums);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute permute = new Permute();
        System.out.println(permute.permute(nums));
    }
}
