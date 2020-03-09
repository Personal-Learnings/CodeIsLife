package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.*;

public class WordSearchII {

    private int [][] SIDES = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * Time Complexity: O(m * n * 4 ^ w) where M & N are Row Size and Col Size of Matrix and W is the length
     *                  of the word and 4 because we iterate in four directions
     *
     * Better Analysis:
     *      Time: O(m * n * wl) = max(O(l * wl), O(m * n * l * wl)) where
     *      O(l * wl) - Build the trie
     *      O(m * n * l * wl) - In the worst case where all words start with different characters, and there is
     *      a word starting with a character in the cell board[m - 1][n - 1], we have O(m * n * l * wl). However,
     *      if there are words starting with same characters and paths sharing cells, Trie can check multiple
     *      words when DFS from a certain cell, rather than check only one word when DFS from a certain cell like the naive way.
     *
     *      Space: O(l * wl) = max(O(wl), O(l * wl)) where
     *      O(wl) - The recursive stack can grow at most to wl layers.
     *      O(l * wl) - In the worst case when all words start with different characters, the trie has l * wl nodes. Also, since each
     *      word is stored in a leaf node, all the leaf nodes require l * wl memory.
     *
     */
    public List<String> findWords(char[][] board, String[] words) {
        if(words == null || words.length == 0 || board == null) return Collections.emptyList();

        List<String> result = new ArrayList<>();
        //Build a trie with marking end as word itself instead of boolean
        Node node = buildTrie(words);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                searchInMatrix(i, j, node, board, result);
            }
        }
        return result;
    }

    private void searchInMatrix(int row, int col, Node trie, char [][] board, List<String> result) {
        char currentChar = board[row][col];
        if(currentChar == '#' || trie.children[currentChar - 'a'] == null) return;

        Node child = trie.children[currentChar - 'a'];

        //if the current location of the trie is a word then add to list and remove the word from the trie
        if(child.word != null) {
            result.add(child.word);
            child.word = null;
        }

        //marking the current space in the board as # because it shouldn't be visited again.
        board[row][col] = '#';
        for(int [] side : SIDES) {
            int newRow = row + side[0], newCol = col + side[1];

            //search all four valid directions of the matrix
            if(newRow > -1 && newRow < board.length && newCol > -1 && newCol < board[newRow].length)
                searchInMatrix(newRow, newCol, child, board, result);
        }

        //once done replace the char back to the original char
        board[row][col] = currentChar;
    }

    private Node buildTrie(String [] words) {
        Node trie = new Node();
        for(String word : words) {
            Node node = trie;

            //adding the word to trie data structure
            for(char c : word.toCharArray()) {
                int charIndex = c - 'a';
                if(node.children[charIndex] == null) {
                    node.children[charIndex] = new Node();
                }
                node = node.children[charIndex];
            }
            //instead of having boolean as typical trie this one saves the word itself
            node.word = word;
        }
        return trie;
    }

    static class Node {
        //using char array instead of using HashMap for faster retrieval
        //But when the alphabets are not lowercase only or upper case only we have to go with HashMap
        Node[] children;
        String word;

        Node() {
            children = new Node[26];
        }
    }

    //Brute Force - Incomplete
    private boolean searchInMatrix(String word, char[][] board) {
        int i = 0, j;

        for(; i < board.length; i++) {
            for(j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(word.length() == 1) return true;

                    int k = i, l = j, charsFound = 0;
                    Set<String> visited = new HashSet<>();
                    visited.add(k + "#" + l);
                    for(char c : word.substring(1).toCharArray()) {
                        int [][] SIDES = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

                        boolean found = false;
                        for(int [] SIDE : SIDES) {
                            int newRow = k + SIDE[0], newCol = l + SIDE[1];
                            if(newRow > -1 && newRow < board.length && newCol > -1 && newCol < board[0].length && board[newRow][newCol] == c && !visited.contains(newRow + "#" + newCol)) {
                                k = newRow; l = newCol;
                                found = true;
                                charsFound++;
                                visited.add(k + "#" + l);
                                break;
                            }
                        }
                        if(!found) break;
                    }
                    if(charsFound == word.length() - 1) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

       /* System.out.println(new WordSearchII().findWords(
            new char[][] { {'b','a','a','b','a','b'}, {'a','b','a','a','a','a'} ,{'a','b','a','a','a','b'}, {'a','b','a','b','b','a'}, {'a','a','b','b','a','b'}, {'a','a','b','b','b','a'}, {'a','a','b','a','a','b'} },
            new String[] { "bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa" }
        ));*/

        System.out.println(new WordSearchII().findWords(
            new char[][] { {'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'} },
            new String[] { "oath", "pea", "eat", "rain" }
        ));

        System.out.println(new WordSearchII().findWords(
            new char[][] { {'a', 'a'} },
            new String[] { "aaa" }
        ));
    }
}