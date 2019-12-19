package com.learnings.practise.datastructure;

import java.util.*;

public class Trie {

    private Node data;

    public Trie() {
        data = new Node(new HashMap<>(), false);
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        Map<Character, Node> currentMap = data.getChildren();

        for(int i = 0; i < chars.length; i++) {
            Character currentChar = chars[i];
            Node node = currentMap.getOrDefault(currentChar, new Node(new HashMap<>(), i == chars.length - 1));
            currentMap.put(currentChar, node);
            currentMap = node.getChildren();
        }
    }

    private String search(String word) {
        char[] chars = word.toCharArray();
        Map<Character, Node> currentMap = data.getChildren();

        for(int i = 0; i < chars.length; i++) {
            Character currentChar = chars[i];
            Node node = currentMap.get(currentChar);
            if(node == null) {
                return "Not Found";
            } else if(i == chars.length -1 && node.isWord()) {
                return word;
            }
            currentMap = node.getChildren();
        }
        return "Not Found";
    }

    public List<String> startsWith(String prefix) {
        char [] chars = prefix.toCharArray();
        Map<Character, Node> currentMap = data.getChildren();
        List<String> startWithList = new ArrayList<>();

        for(int i = 0; i < chars.length; i++) {
            Character currentChar = chars[i];
            Node node = currentMap.get(currentChar);
            if(node == null) {
                return startWithList;
            }
            if(i == chars.length - 1) {
                getStringsWithPrefix(prefix, node.getChildren(), startWithList);
            }
            currentMap = node.getChildren();
        }
        return startWithList;
    }

    private void getStringsWithPrefix(String prefix, Map<Character, Node> currentMap, List<String> startWithList) {
        if(currentMap != null) {
            currentMap.forEach((key, value) -> {
                if(value.isWord) {
                    startWithList.add(prefix + key);
                }
                getStringsWithPrefix((prefix + key), value.getChildren(), startWithList);
            });
        }
    }

    public List<String> startsWithAndHas(String inputString) {
        char [] charArray = inputString.toCharArray();
        StringBuilder sequence = new StringBuilder();
        List<String> startWithList = new ArrayList<>();

        Map<Character, Node> currentMap = data.getChildren();

        for (Character currentChar : charArray) {
            sequence.append(currentChar);
            Node node = currentMap.get(currentChar);

            if (node == null) {
                return startWithList;
            }
            if (node.isWord) {
                startWithList.add(sequence.toString());
            }
            currentMap = node.getChildren();
        }
        return startWithList;
    }

    static class Node {
        private boolean isWord;
        private Map<Character, Node> children;

        Node(Map<Character, Node> children, boolean isWord) {
            this.children = children;
            this.isWord = isWord;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }

        public boolean isWord() {
            return isWord;
        }
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("Madan");
        trie.insert("Madanraj");
        trie.insert("Many");
        trie.insert("Mapple");
        trie.insert("Mapping");
        trie.insert("Mail");
        trie.insert("Mole");

        System.out.println(trie.search("Madanraj"));
        System.out.println(trie.search("Mole"));
        System.out.println(trie.search("Molee"));
        System.out.println(trie.search("Madan"));

        System.out.println(trie.startsWith("Mada"));
        System.out.println(trie.startsWith("Ma"));
        System.out.println(trie.startsWith("M"));
    }
}