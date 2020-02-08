package com.learnings.practise.problems.leetcode.general;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AutocompleteSystem {

    private StringBuilder sentence = new StringBuilder();
    private Map<String, Integer> map = new HashMap<>();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for(int i = 0; i < times.length; i++) {
            map.put(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if(c == '#') {
            String key = sentence.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            sentence = new StringBuilder();
            return Collections.emptyList();
        } else {
            sentence.append(c);
            String key = sentence.toString();

            return map.entrySet().stream()
                    .filter(e -> e.getKey().indexOf(key) == 0)
                    .sorted((a, b) -> b.getValue().equals(a.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue())
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }

    /* This is using Trie
    public List<String> input(char c) {
        if(c == '#') {
            String key = sentence.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            trie.add(key);
            sentence = new StringBuilder();
            return Collections.emptyList();
        } else {
            sentence.append(c);
            return trie.getStartsWith(sentence.toString()).stream()
                    .collect(Collectors.toMap(e -> e, e -> map.get(e)))
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> {
                        if(b.getValue().equals(a.getValue())) {
                            return a.getKey().compareTo(b.getKey());
                        } else {
                            return b.getValue() - a.getValue();
                        }
                    })
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }

    static class Trie {

        private Node root = new Node(false, new HashMap<>());

        private void add(String str) {
            if(str != null && !str.isEmpty()) {
                char[] chars = str.toCharArray();
                Map<Character, Node> current = root.child;

                for(int i = 0; i < chars.length; i++) {
                    Character c = chars[i];
                    Node node = current.getOrDefault(c, new Node((i == chars.length - 1), new HashMap<>()));
                    if(chars.length == 1) {
                        node.isWord = true;
                    }
                    current.put(c, node);
                    current = node.child;
                }
            }
        }

        private List<String> getStartsWith(String str) {
            List<String> result = new ArrayList<>();

            if(str != null && !str.isEmpty()) {
                char[] chars = str.toCharArray();
                Map<Character, Node> current = root.child;

                for(int i = 0; i < chars.length; i++) {
                    Node node = current.get(chars[i]);
                    if(node == null) return result;
                    if(i == chars.length - 1) {
                        if(node.isWord) result.add(str);
                        getMatches(str, node.child, result);
                    }
                    current = node.child;
                }
            }
            return result;
        }

        private void getMatches(String s, Map<Character, Node> map, List<String> result) {
            map.forEach((key, value) -> {
                if(value.isWord) result.add(s + key);
                getMatches(s + key, value.child, result);
            });
        }

        static class Node {
            private boolean isWord;
            private Map<Character, Node> child;

            Node(boolean b, Map<Character, Node> c) {
                isWord = b;
                child = c;
            }
        }
    }*/

    public static void main(String[] args) {
        /*AutocompleteSystem autocompleteSystem = new AutocompleteSystem(new String[] {"i love you","island","iroman","i love leetcode"}, new int[]{ 5, 3, 2, 2});
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));

        System.out.println("--------");
        autocompleteSystem = new AutocompleteSystem(new String[] {"i love you","island","iroman","i love leetcode"}, new int[]{ 5, 3, 2, 2 });
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));*/

        System.out.println("--------");
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(new String[] {"abc", "abbc", "a"}, new int[]{ 3, 3, 3 });
        System.out.print(autocompleteSystem.input('b'));
        System.out.print(autocompleteSystem.input('c'));
        System.out.print(autocompleteSystem.input('#'));
        System.out.print(autocompleteSystem.input('b'));
        System.out.print(autocompleteSystem.input('c'));
        System.out.print(autocompleteSystem.input('#'));
        System.out.print(autocompleteSystem.input('a'));
        System.out.print(autocompleteSystem.input('b'));
        System.out.print(autocompleteSystem.input('c'));
        System.out.print(autocompleteSystem.input('#'));
        System.out.print(autocompleteSystem.input('a'));
        System.out.print(autocompleteSystem.input('b'));
        System.out.print(autocompleteSystem.input('c'));
        System.out.print(autocompleteSystem.input('#'));
    }
}
//[[],[],[],["bc"],["bc"],[],["a","abbc","abc"],["abbc","abc"],["abc"],[],["abc","a","abbc"],["abc","abbc"],["abc"],[]]
