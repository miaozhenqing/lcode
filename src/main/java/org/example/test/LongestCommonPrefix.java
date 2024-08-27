package org.example.test;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs == null || strs.length == 0) {
            return res;
        }
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            boolean match = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    match = false;
                    break;
                }
                if (strs[j].charAt(i) != c) {
                    match = false;
                    break;
                }
            }
            if (!match) {
                break;
            } else {
                res = res + c;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flo2wersabc", "flower", "a"};
        System.out.println("=======");
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));

    }
}
