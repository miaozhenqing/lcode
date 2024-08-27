package org.example.test;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            Integer index = valueToIndexMap.get(value);
            if (index == null) {
                valueToIndexMap.put(value, i);
            } else {
                if (value == nums[index]) {
                    valueToIndexMap.put(value, i);
                }
                if (Math.abs(i - index) <= k) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(nums, 3));//true
        int[] nums2 = new int[]{1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums2, 1));//true
        int[] nums3 = new int[]{1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(nums3, 2));//false
    }
}
