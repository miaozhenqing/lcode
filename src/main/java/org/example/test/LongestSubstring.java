package org.example.test;

import java.util.HashMap;
import java.util.Map;


public class LongestSubstring {

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || s.length() < k) {
            return 0;
        }
        int index = findIndex(s, k);
        if (index < 0) {
            return s.length();
        }
        String sub1 = s.substring(0, index);
        String sub2 = s.substring(index + 1, s.length());
        return Math.max(longestSubstring(sub1, k), longestSubstring(sub2, k));
    }


    public int findIndex(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int index = -1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k) {
                index = s.indexOf(entry.getKey());
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().longestSubstring("aaabb", 3));//3
        System.out.println(new LongestSubstring().longestSubstring("ababbc", 2));//5
        System.out.println(new LongestSubstring().longestSubstring("ababacb", 3));//0
    }

}
