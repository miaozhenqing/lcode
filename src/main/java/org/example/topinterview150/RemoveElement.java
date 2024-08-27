package org.example.topinterview150;
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        RemoveElement remover = new RemoveElement();
        int length = remover.removeElement(nums, val);

        System.out.println("New Length: " + length);  // 输出：New Length: 2
        System.out.print("Updated Array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");  // 输出：Updated Array: 2 2
        }
    }
}
