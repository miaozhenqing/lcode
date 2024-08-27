package org.example.test;


public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        char[] mainCharArray = t.toCharArray();
        char[] subCharArray = s.toCharArray();

        int mainIndex = 0;
        for (int i = 0; i < subCharArray.length; i++) {
            char subC = subCharArray[i];
            boolean found = false;
            for (int j = mainIndex; j < mainCharArray.length; j++) {
                char mainC = mainCharArray[j];
                if (subC == mainC) {
                    mainIndex = j + 1;
                    found = true;
                } else if (j == mainCharArray.length - 1) {
                    return false;
                }
                if (found) {
                    break;
                }
            }
        }
        return true;
    }
    public static boolean isSubsequence2(String s, String t) {
        int subPointer = 0; // 子字符串指针
        int mainPointer = 0; // 主字符串指针

        while (subPointer < s.length() && mainPointer < t.length()) {
            if (s.charAt(subPointer) == t.charAt(mainPointer)) {
                subPointer++;
            }
            mainPointer++;
        }

        // 子字符串指针是否指向了子字符串的末尾
        return subPointer == s.length();
    }
    public static void main(String[] args) {
        String main = "abcdefg";
        String sub = "acef";
        System.out.println(isSubsequence2(main, sub));
        String main2 = "axc";
        String sub2 = "";
        System.out.println(isSubsequence2(main2, sub2));
    }
}
