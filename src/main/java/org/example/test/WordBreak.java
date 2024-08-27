package org.example.test;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && (dict.contains(s.substring(j, i)))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(new WordBreak().wordBreak("leetcode", Lists.newArrayList("leet", "code")));//true
        System.out.println(new WordBreak().wordBreak("applepenapple", Lists.newArrayList("apple", "pen")));//true
    }
}
