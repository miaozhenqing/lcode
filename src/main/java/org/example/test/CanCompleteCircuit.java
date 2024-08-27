package org.example.test;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) {
                startIndex = i + 1;
                currentTank = 0;
            }
        }
        return totalTank >= 0 ? startIndex : -1;
    }

    public static void main(String[] args) {
        System.out.println(new CanCompleteCircuit().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));//3
        System.out.println(new CanCompleteCircuit().canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));//-1
        System.out.println(new CanCompleteCircuit().canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));//4
    }

}
