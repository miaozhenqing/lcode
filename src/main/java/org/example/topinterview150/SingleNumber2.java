package org.example.topinterview150;

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                res |= 1 << i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(new SingleNumber2().singleNumber(nums));//3
        nums = new int[]{0, 1, 0, 1, 0, 1, 99};
        System.out.println(new SingleNumber2().singleNumber(nums));//99
    }
}
