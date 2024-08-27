package org.example.test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CanConstruct {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, AtomicInteger> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            AtomicInteger atomicInteger = map.computeIfAbsent(magazine.charAt(i), k -> new AtomicInteger());
            atomicInteger.incrementAndGet();
        }
        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c)) {
                int num = map.get(c).decrementAndGet();
                if (num <= 0) {
                    map.remove(c);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct2("a", "b"));
        System.out.println(canConstruct2("aa", "ab"));
        System.out.println(canConstruct2("aa", "aab"));
    }
}
