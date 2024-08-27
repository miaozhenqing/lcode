package org.example.test;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int startMax = 0, endMax = 0;
        //长度为1和2
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            if ((i + 1) < length && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                if (1 > endMax - startMax) {
                    startMax = i;
                    endMax = i + 1;
                }
            }
        }
        //长度为3以上
        for (int i = 3; i <= length; i++) {
            for (int startJ = 0; startJ <= length - i; startJ++) {
                int endJ = startJ + i - 1;
                if (s.charAt(startJ) == s.charAt(endJ) && dp[startJ + 1][endJ - 1]) {
                    dp[startJ][endJ] = true;
                    if (endJ - startJ > endMax - startMax) {
                        startMax = startJ;
                        endMax = endJ;
                    }
                } else {
                    dp[startJ][endJ] = false;
                }
            }
        }
        return s.substring(startMax, endMax + 1);
    }

    public static void main(String[] args) {
//        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindrome().longestPalindrome("a"));
        System.out.println(new LongestPalindrome().longestPalindrome("ac"));
        System.out.println(new LongestPalindrome().longestPalindrome("bb"));
        System.out.println(new LongestPalindrome().longestPalindrome("ccc"));
    }

}
