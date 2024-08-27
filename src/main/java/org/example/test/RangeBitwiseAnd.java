package org.example.test;

public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left = left >> 1;
            right = right >> 1;
            shift++;
        }
        return left << shift;
    }

    public static void main(String[] args) {
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(5, 7));//4
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(5, 5));//5
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(5, 6));//4
    }
}
