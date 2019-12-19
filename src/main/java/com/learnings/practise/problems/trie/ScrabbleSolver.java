package com.learnings.practise.problems.trie;

import com.learnings.practise.datastructure.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ScrabbleSolver {

    private Trie dictionary = new Trie();
    private static Map<Character, Byte> scrabbleScore = new HashMap<>();

    private void constructData(Path path) throws IOException {
        long startTime = System.currentTimeMillis();

        AtomicInteger atomicInteger = new AtomicInteger();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String word;
            while ((word = bufferedReader.readLine()) != null) {
                dictionary.insert(word);
                atomicInteger.getAndIncrement();
            }
        }
        System.out.println("Dictionary Construction Time: " + (System.currentTimeMillis() - startTime) + "ms" + " For " + atomicInteger.get() + " Words");
    }

    private Set<String> getPermutationsForGivenString(String input) {
        Set<String> permutations = new HashSet<>();
        findPermutations(input, "", permutations);
        return permutations;
    }

    private void findPermutations(String inputString, String result, Set<String> permutations) {
        if(inputString.length() == 0) {
            permutations.add(result);
            return;
        }
        for(int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);
            String stringExcludingCharacter = inputString.substring(0, i) + inputString.substring(i + 1);
            findPermutations(stringExcludingCharacter, result + character, permutations);
        }
    }

    private Set<String> getValidWordsFromGivenLetters(String letters) {
        letters = letters.toLowerCase();
        long startTime = System.currentTimeMillis();
        Set<String> scrabbleResult = new HashSet<>();

        Set<String> permutationsForGivenString = getPermutationsForGivenString(letters);
        System.out.println("Unique Combinations of Given String: " + permutationsForGivenString);

        permutationsForGivenString.forEach(element -> scrabbleResult.addAll(dictionary.startsWithAndHas(element)));

        System.out.println("Dictionary Lookup Time for Combinations: " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("The Dictionary contains these Words: " + scrabbleResult);
        return scrabbleResult;
    }

    static {
        scrabbleScore.put('a', (byte) 1);
        scrabbleScore.put('e', (byte) 1);
        scrabbleScore.put('i', (byte) 1);
        scrabbleScore.put('l', (byte) 1);
        scrabbleScore.put('n', (byte) 1);
        scrabbleScore.put('o', (byte) 1);
        scrabbleScore.put('r', (byte) 1);
        scrabbleScore.put('s', (byte) 1);
        scrabbleScore.put('t', (byte) 1);
        scrabbleScore.put('u', (byte) 1);

        scrabbleScore.put('d', (byte) 2);
        scrabbleScore.put('g', (byte) 2);

        scrabbleScore.put('b', (byte) 3);
        scrabbleScore.put('c', (byte) 3);
        scrabbleScore.put('m', (byte) 3);
        scrabbleScore.put('p', (byte) 3);

        scrabbleScore.put('f', (byte) 4);
        scrabbleScore.put('h', (byte) 4);
        scrabbleScore.put('v', (byte) 4);
        scrabbleScore.put('w', (byte) 4);
        scrabbleScore.put('y', (byte) 4);

        scrabbleScore.put('k', (byte) 5);

        scrabbleScore.put('j', (byte) 8);
        scrabbleScore.put('x', (byte) 8);

        scrabbleScore.put('q', (byte) 10);
        scrabbleScore.put('z', (byte) 10);
    }

    private static short getScrabbleValue(String inputString) {
        char[] charArray = inputString.toCharArray();
        AtomicInteger scrabbleValue = new AtomicInteger();
        for(Character character : charArray) {
            scrabbleValue.addAndGet(scrabbleScore.get(character));
        }
        return (short) scrabbleValue.get();
    }

    public static void main(String[] args) throws IOException {
        String fileName = System. getProperty("user.dir") + "/src/main/java/com/learnings/practise/problems/trie/dictionary.txt";
        ScrabbleSolver scrabbleSolver = new ScrabbleSolver();
        scrabbleSolver.constructData(Paths.get(fileName));
        Set<String> wordsFoundInDictionary = scrabbleSolver.getValidWordsFromGivenLetters("hat");

        PriorityQueue<ScrabbleVO> priorityQueue = new PriorityQueue<>(Comparator.comparing(ScrabbleVO::getScrabbleValue).reversed());
        wordsFoundInDictionary.forEach(word -> {
            ScrabbleVO scrabbleVO = new ScrabbleVO(word, getScrabbleValue(word));
            priorityQueue.add(scrabbleVO);
        });

        while(!priorityQueue.isEmpty()) {
            ScrabbleVO scrabbleVO = priorityQueue.poll();
            System.out.println(scrabbleVO.getWord() + " ::" + scrabbleVO.getScrabbleValue());
        }
    }

    static class ScrabbleVO {
        private String word;
        private short scrabbleValue;

        ScrabbleVO(String word, short scrabbleValue) {
            this.word = word;
            this.scrabbleValue = scrabbleValue;
        }

        public String getWord() {
            return word;
        }

        public short getScrabbleValue() {
            return scrabbleValue;
        }
    }
}