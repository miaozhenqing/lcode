package org.example.topinterview150;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Map<Character, Trie> children = new HashMap<>();
    boolean isEnd;

    public Trie() {

    }

    public void insert(String word) {
        Trie current = this;
        for (char c : word.toCharArray()) {
            Trie trie = current.children.get(c);
            if (trie == null) {
                trie = new Trie();
                current.children.put(c, trie);
            }
            current = trie;
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        Trie current = this;
        for (char c : word.toCharArray()) {
            Trie foundTrie = current.children.get(c);
            //没找到当前字符
            if (foundTrie == null) {
                return false;
            }
            //找到当前字符，继续找下一个
            current = foundTrie;
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie current = this;
        for (char c : prefix.toCharArray()) {
            Trie foundTrie = current.children.get(c);
            //没找到当前字符
            if (foundTrie == null) {
                return false;
            }
            //找到当前字符，继续找下一个
            current = foundTrie;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));//true
        System.out.println(trie.search("app"));//false
        System.out.println(trie.startsWith("app"));//true
        trie.insert("app");
        System.out.println(trie.search("app"));//true
    }
}
