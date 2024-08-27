package org.example.test;

import java.util.Stack;

public class EvalRPN {
    public static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer right = stack.pop();
                Integer left = stack.pop();
                int newValue;
                if (token.equals("+")) {
                    newValue = left + right;
                } else if (token.equals("-")) {
                    newValue = left - right;
                } else if (token.equals("*")) {
                    newValue = left * right;
                } else {
                    newValue = left / right;
                }
                stack.push(newValue);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] str = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(str));//9
        String[] str2 = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(str2));//6
        String[] str3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(str3));//22
    }
}
