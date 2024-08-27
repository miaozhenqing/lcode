package org.example.test;

public class Reverse {
    public int reverse(int x) {
        int newNum = 0;
        while (x != 0) {
            int tail = x % 10;
            if (newNum < Integer.MIN_VALUE / 10 || newNum > Integer.MAX_VALUE / 10) {
                return 0;
            }
            newNum = newNum * 10 + tail;
            x = x / 10;
        }
        return newNum;
    }

    public static void main(String[] args) {

        System.out.println(new Reverse().reverse(123));
        //测试用例:-123
        System.out.println(new Reverse().reverse(-123));//-321
        System.out.println(new Reverse().reverse(1534236469));//0
        System.out.println(new Reverse().reverse(-2147483412));//-2143847412
    }

    public int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            int t = x % 10;
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + t;
            x /= 10;
        }
        return ans;
    }
}
