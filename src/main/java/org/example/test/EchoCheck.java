package org.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EchoCheck {
    public static boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ((c >= 65 && c <= 90) || c >= 97 && c <= 122) {
                char lowerC = Character.toLowerCase(c);
                list.add(lowerC);
                stack.push(lowerC);
            }
        }
        for (Character c : list) {
            char pop = stack.pop();
            if (pop != c) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else if (leftChar != rightChar) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome2(str1));
        String str2 = "race a car";
        System.out.println(isPalindrome2(str2));
        String str3 = "0p";
        System.out.println(isPalindrome2(str3));
    }
}
