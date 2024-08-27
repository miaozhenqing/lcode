package org.example.topinterview150;

public class _7WaysToStep {
    /**
     * f(i)=f(i-1)+f(i-2)+f(i-3)
     */
    public static int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        int step[] = new int[n];
        step[0] = 1;
        step[1] = 2;
        step[2] = 4;
        for (int i = 3; i < n; i++) {
            step[i] = step[i - 1] + step[i - 2] + step[i - 3];
        }
        return step[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(waysToStep(3));//4
        System.out.println(waysToStep(5));//13
    }
}
