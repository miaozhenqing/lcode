package org.example._20260904;

import javax.print.attribute.standard.NumberUp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashAlgorithms {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (valueIndex.containsKey(need)) {
                return new int[]{valueIndex.get(need), i};
            }
            valueIndex.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    //最长连续序列
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            //包含，不是起点
            if (set.contains(num - 1)) {
                continue;
            }
            //num是起点，找num+1、num+2...
            int currentNum = num;
            int currentLen = 1;
            while (set.contains(currentNum + 1)) {
                currentNum++;
                currentLen++;
            }
            max = Math.max(max, currentLen);
        }
        return max;
    }
}
