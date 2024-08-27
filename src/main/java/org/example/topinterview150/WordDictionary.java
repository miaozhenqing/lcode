package org.example.topinterview150;

public class WordDictionary {
    private WordDictionary[] children;
    boolean isEnd;

    public WordDictionary() {
        children = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary current = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new WordDictionary();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return doSearch(this, word, 0);
    }

    private boolean doSearch(WordDictionary current, String word, int startIndex) {
        if (startIndex == word.length()) {
            return current.isEnd;
        }
        char c = word.charAt(startIndex);
        if (c != '.') {
            int index = c - 'a';
            WordDictionary found = current.children[index];
            if (found != null && doSearch(found, word, startIndex + 1)) {
                return true;
            }
        } else {
            for (int j = 0; j < 26; j++) {
                WordDictionary child = current.children[j];
                if (child == null) {
                    continue;
                }
                boolean found = doSearch(child, word, startIndex + 1);
                if (found) {
                    return found;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));//false
        System.out.println(wordDictionary.search("bad"));//true
        System.out.println(wordDictionary.search(".ad"));//true
        System.out.println(wordDictionary.search("b.."));//true
        System.out.println("==============================");

        //添加测试用例：["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
        //[[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]
        WordDictionary wordDictionary2 = new WordDictionary();
        wordDictionary2.addWord("a");
        wordDictionary2.addWord("a");
        System.out.println(wordDictionary2.search("."));
        System.out.println(wordDictionary2.search("a"));
        System.out.println(wordDictionary2.search("aa"));
        System.out.println(wordDictionary2.search("a"));
        System.out.println(wordDictionary2.search(".a"));
        System.out.println(wordDictionary2.search("a."));


    }
}
