package org.example.test;

import java.util.Stack;

public class Calculate {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }


    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate("3+2*2"));// 7
        System.out.println(calculate.calculate(" 3/2 "));// 1
        System.out.println(calculate.calculate(" 3+5 / 2 "));// 5
        System.out.println(calculate.calculate("1-1+1"));// 1
        System.out.println(calculate.calculate("1-1"));// 0
        System.out.println(calculate.calculate("1+1"));// 2
        System.out.println(calculate.calculate("1+1+1"));// 3
        System.out.println(calculate.calculate("1+1-1"));// 1
        System.out.println(calculate.calculate("1+1-1*2"));// 0
    }


}
