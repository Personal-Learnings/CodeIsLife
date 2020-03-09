package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.HashMap;
import java.util.Map;

public class TrieWithHashMap {

    private Node trie;

    /** Initialize your data structure here. */
    public TrieWithHashMap() {
        trie = new Node(new HashMap<>());
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.isEmpty()) return;

        Map<Character, Node> map = trie.children;
        int lastIndex = word.length() - 1;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = map.getOrDefault(c, new Node(new HashMap<>()));
            if(i == lastIndex) node.isWord = true;
            map.put(c, node);
            map = node.children;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.isEmpty()) return false;

        int lastIndex = word.length() - 1;
        Map<Character, Node> map = trie.children;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(map.containsKey(c)) {
                Node node = map.get(c);
                map = node.children;
                if(i == lastIndex && node.isWord) return true;
            }
            else break;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.isEmpty()) return false;

        int lastIndex = prefix.length() - 1;
        Map<Character, Node> map = trie.children;

        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(map.containsKey(c)) {
                Node node = map.get(c);
                map = node.children;
                if(i == lastIndex) return true;
            }
            else break;
        }
        return false;
    }

    static class Node {
        Map<Character, Node> children;
        boolean isWord;

        Node(Map<Character, Node> map) {
            children = map;
        }
    }

    public static void main(String[] args) {
        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("ap"));
    }
}
