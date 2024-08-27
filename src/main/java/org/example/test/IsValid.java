package org.example.test;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class IsValid {

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || !map.containsKey(c)) {
                stack.push(c);
            } else {
                Character pop = stack.pop();
                if (!map.get(c).equals(pop)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "()";
        System.out.println(isValid(str1));//true
        String str2 = "()[]{}";
        System.out.println(isValid(str2));//true
        String str3 = "(]";
        System.out.println(isValid(str3));//false
        String str4 = "([)]";
        System.out.println(isValid(str4));//false
    }
}
