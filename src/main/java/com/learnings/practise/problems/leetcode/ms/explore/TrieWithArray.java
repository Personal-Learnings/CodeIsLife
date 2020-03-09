package com.learnings.practise.problems.leetcode.ms.explore;

public class TrieWithArray {

    private Node trie;

    /** Initialize your data structure here. */
    public TrieWithArray() {
        trie = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.isEmpty()) return;

        Node node = trie;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                Node newNode = new Node();
                node.children[c - 'a'] = newNode;
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.isEmpty()) return false;

        Node node = trie;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c -'a'];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.isEmpty()) return false;

        Node node = trie;
        for(char c : prefix.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c -'a'];
        }
        return true;
    }

    static class Node {
        Node [] children;
        boolean isWord;

        Node() {
            children = new Node[26];
        }
    }

    public static void main(String[] args) {
        TrieWithArray trie = new TrieWithArray();
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
