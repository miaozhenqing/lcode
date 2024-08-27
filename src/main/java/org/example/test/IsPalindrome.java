package org.example.test;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int res = 0;
        while (res < x) {
            int tail = x % 10;
            x = x / 10;
            res = res * 10 + tail;
        }
        return x == res || x == (res / 10);
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome(121));
        System.out.println(new IsPalindrome().isPalindrome(12321));
    }
}
