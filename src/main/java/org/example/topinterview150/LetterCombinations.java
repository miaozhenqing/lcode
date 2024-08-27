package org.example.topinterview150;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String[] numToLetter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> letterList = new ArrayList<>(digits.length());
        for (Character c : digits.toCharArray()) {
            int i = Character.getNumericValue(c);
            letterList.add(numToLetter[i]);
        }
        List<String> res = new ArrayList<>();
        backtrack(res, letterList, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<String> res, List<String> letterList, int index, List<Character> path) {
        if (path.size() == letterList.size()) {
            StringBuilder s = new StringBuilder();
            for (Character character : path) {
                s.append(character);
            }
            res.add(s.toString());
            return;
        }
        char[] chars = letterList.get(index).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            path.add(chars[i]);
            backtrack(res, letterList, index + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
//        System.out.println(letterCombinations.letterCombinations("23"));
        System.out.println(letterCombinations.letterCombinations(""));
    }
}
