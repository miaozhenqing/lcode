package org.example.test;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if (val < minStack.peek()) {
                minStack.pop();
                minStack.push(val);
            }
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop == minStack.peek()) {
                minStack.pop();
                for (Integer i : stack) {
                    if (minStack.isEmpty()) {
                        minStack.push(i);
                    }
                    if (i < minStack.peek()) {
                        minStack.push(i);
                    }
                }
            }
        }
    }

    public int top() {
        return stack.pop();
    }

    public int getMin() {
        return minStack.isEmpty() ? 0 : minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // -3.
        minStack.pop();
        System.out.println(minStack.top());      // 0.
        System.out.println(minStack.getMin());   // -2.
    }

}
