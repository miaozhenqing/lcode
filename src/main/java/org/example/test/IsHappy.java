package org.example.test;


public class IsHappy {

    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int tail = n % 10;
            sum += tail * tail;
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    public static void main(String[] args) {
        System.out.println(new IsHappy().isHappy(19));//true
        System.out.println(new IsHappy().isHappy(116));//false
    }
}
