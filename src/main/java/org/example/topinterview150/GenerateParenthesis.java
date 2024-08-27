package org.example.topinterview150;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    void generateParenthesis(int n, String current, List<String> result, int open, int close) {
        if (close == n) {
            result.add(current);
            return;
        }

        if (open < n) {
            generateParenthesis(n, current + "(", result, open + 1, close);
        }

        if (close < open) {
            generateParenthesis(n, current + ")", result, open, close + 1);
        }
    }

    List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, "", result, 0, 0);
        return result;
    }


    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> res = generateParenthesis.generateParenthesis(3);
        System.out.println(res);
    }

//    public static void main(String[] args) {
//        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
//        List<Character> list1 = Lists.newArrayList('(', '(', '(', ')', ')', ')');
//        boolean valid = generateParenthesis.isValid(list1);
//        System.out.println(valid);
//        List<Character> list2 = Lists.newArrayList('(', '(', ')', '(', ')', ')');
//        boolean valid1 = generateParenthesis.isValid(list2);
//        System.out.println(valid1);
//        List<Character> list3 = Lists.newArrayList('(', ')', '(', ')', '(', ')');
//        boolean valid2 = generateParenthesis.isValid(list3);
//        System.out.println(valid2);
//    }
}
