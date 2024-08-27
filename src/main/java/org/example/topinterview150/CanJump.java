package org.example.topinterview150;

public class CanJump {
    public static boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(a));
    }
}
