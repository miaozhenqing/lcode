package org.example.topinterview150;


public class _12LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                length++;
            } else if (chars[i] == ' ' && length > 0) {
                return length;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));//5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));//4
        System.out.println(lengthOfLastWord("luffy is still joyboy"));//6
    }
}
