package org.example.test;


public class MaxArea {
    public static int solution(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        int max = 0;
        while (i != j) {
            int tempValue = (numbers[i] < numbers[j] ? numbers[i] : numbers[j]) * (j - i);
            max = tempValue > max ? tempValue : max;
            if (numbers[i] < numbers[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(nums));
    }
}
