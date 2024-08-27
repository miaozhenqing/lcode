package org.example.test;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i]<9){
                digits[i]=digits[i]+1;
                return digits;
            }
            digits[i]=0;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        System.out.println(new PlusOne().plusOne(new int[]{9,9,9}));
        System.out.println(new PlusOne().plusOne(new int[]{1,2,3}));
        System.out.println(new PlusOne().plusOne(new int[]{4,3,2,1}));
    }
}
