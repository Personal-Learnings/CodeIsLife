package com.learnings.practise.string;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PalindromePermutations {

    private boolean isPalindromePermutation_BigO_N_Extended_ASCII(String inputString) {
        char [] inputArray = inputString.toCharArray();
        int [] asciiArray = new int[256];
        int oddCount = 0;

        for (char c : inputArray) asciiArray[c]++;
        for(int j : asciiArray) {
            if(j % 2 == 1) oddCount++;
        }
        return (oddCount <= 1);
    }

    private boolean isPalindromePermutation_BigO_N(String inputString) {
        char [] inputArray = inputString.toCharArray();
        Map<Character, Integer> occurrencesMap = new HashMap<>();
        AtomicInteger oddCount = new AtomicInteger();

        for (char c : inputArray) {
            Integer occurrences = occurrencesMap.get(c);
            occurrencesMap.put(c, (null == occurrences) ? 1 : occurrences + 1);
        }
        occurrencesMap.forEach((character, occurrence) -> {
            if(occurrence % 2 == 1) oddCount.getAndIncrement();
        });
        return (oddCount.get() <= 1);
    }

    public static void main(String[] args) {
        PalindromePermutations palindromePermutations = new PalindromePermutations();

        String inputString = "DAMMA";
        System.out.println("Input: " + inputString + " Output: " + palindromePermutations.isPalindromePermutation_BigO_N_Extended_ASCII(inputString));

        inputString = "MALAYALAMA";
        System.out.println("Input: " + inputString + " Output: " + palindromePermutations.isPalindromePermutation_BigO_N_Extended_ASCII(inputString));

        inputString = "ASASA";
        System.out.println("Input: " + inputString + " Output: " + palindromePermutations.isPalindromePermutation_BigO_N_Extended_ASCII(inputString));

        System.out.println("----------------------------------------------");

        inputString = "DAMMA";
        System.out.println("Input: " + inputString + " Output: " + palindromePermutations.isPalindromePermutation_BigO_N(inputString));

        inputString = "MALAYALAMA";
        System.out.println("Input: " + inputString + " Output: " + palindromePermutations.isPalindromePermutation_BigO_N(inputString));

        inputString = "ASASA";
        System.out.println("Input: " + inputString + " Output: " + palindromePermutations.isPalindromePermutation_BigO_N(inputString));

        inputString = "SS﷽﷽A";
        System.out.println("Input: " + inputString + " Output: " + palindromePermutations.isPalindromePermutation_BigO_N(inputString));
    }
}