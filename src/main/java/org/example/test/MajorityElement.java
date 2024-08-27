package org.example.test;

/**
 * 169. 多数元素
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int main = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                main = num;
            }
            if (num == main) {
                count++;
            } else {
                count--;
            }
        }
        return main;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 3, 2, 1, 1, 1};
        System.out.println(majorityElement(nums));
        int[] nums2 = new int[]{3, 2, 3};
        System.out.println(majorityElement(nums2));
    }


}
