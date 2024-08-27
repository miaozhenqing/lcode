package org.example.topinterview150;

public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return 0;
        }
        int result = left;
        for (int i = left + 1; i <= right; i++) {
            result = result & i;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(5, 7));//4
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(5, 5));//0
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(1, 1));//0
    }
}
