package org.example.test;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (mapS.containsKey(cs)) {
                if (mapS.get(cs) != ct) {
                    return false;
                }
            } else {
                mapS.put(cs, ct);
            }

            if (mapT.containsKey(ct)) {
                if (mapT.get(ct) != cs) {
                    return false;
                }
            } else {
                mapT.put(ct, cs);
            }
        }

        return true;
    }
    public static boolean isIsomorphic2(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
