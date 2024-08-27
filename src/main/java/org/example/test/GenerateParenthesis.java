package org.example.test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }

    public void dfs(List<String> results, String current, int leftCount, int rightCount, int max) {
        if (leftCount == max && rightCount == max) {
            results.add(current);
            return;
        }
        if (leftCount < max) {
            dfs(results, current + "(", leftCount + 1, rightCount, max);
        }
        if (rightCount < leftCount) {
            dfs(results, current + ")", leftCount, rightCount + 1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));// [((())), (()()), (())(), ()(()), ()()()]
    }

}
