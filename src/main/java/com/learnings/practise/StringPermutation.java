package com.learnings.practise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

    private boolean isStringPermutationOfOther_BigO_nSquare(String stringA, String stringB) {
        Set<String> permutations = new HashSet<>();

        if(stringA.length() != stringB.length()) {
            System.out.println("Length of " + stringA + " and " + stringB + " are not equal so it cannot be a permutation of the other.");
            return false;
        }
        else if(stringA.equals(stringB)) {
            System.out.println(stringA + " and " + stringB + " are equal so it is a permutation of the other.");
            return true;
        }
        for(int i = 0; i < stringA.length(); i++) {
            Character pivot = stringA.charAt(i);
            StringBuilder remainingCharacters = new StringBuilder(stringA.substring(0, i) + stringA.substring(i + 1));

            for(int j = 0; j < stringA.length(); j++) {
                if(j < remainingCharacters.length()) {
                    permutations.add(remainingCharacters.insert(j, pivot).toString());
                } else {
                    permutations.add(remainingCharacters.append(stringA.charAt(i)).toString());
                }
                remainingCharacters.deleteCharAt(j);
            }
        }
        System.out.println(stringB + (permutations.contains(stringB) ? " is a " : " is not a ") + "permutation of " + permutations);
        return permutations.contains(stringB);
    }

    private boolean isStringPermutationOfOther_BigO_NLogN(String stringA, String stringB) {
        if(stringA.length() != stringB.length()) {
            System.out.println("Length of " + stringA + " and " + stringB + " are not equal so it cannot be a permutation of the other.");
            return false;
        }
        else if(stringA.equals(stringB)) {
            System.out.println(stringA + " and " + stringB + " are equal so it is a permutation of the other.");
            return true;
        }

        char [] arrayA = stringA.toCharArray();
        char [] arrayB = stringB.toCharArray();

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        boolean isEqual = false;
        for(int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] != arrayB[i]) {
                isEqual = false;
                break;
            }
            isEqual = true;
        }
        System.out.println(stringB + (isEqual ? " is a " : " is not a ") + "permutation of " + stringA);
        return isEqual;

        //.equals and .toString is gonna take some time, so shifting to the above approach
        //boolean isEqual = Arrays.toString(arrayA).equals(Arrays.toString(arrayB));
        //System.out.println(stringB + (isEqual ? " is a " : " is not a ") + "permutation of " + stringA);
        //return isEqual;
    }

    private boolean isStringPermutationOfOther_BigO_N(String stringA, String stringB) {
        if (stringA.length() != stringB.length()) {
            System.out.println("Length of " + stringA + " and " + stringB + " are not equal so it cannot be a permutation of the other.");
            return false;
        } else if (stringA.equals(stringB)) {
            System.out.println(stringA + " and " + stringB + " are equal so it is a permutation of the other.");
            return true;
        }

        //Assuming the String is a Extended ASCII
        final int EXTENDED_ASCII_COUNT = 256;
        int [] countArray1 = new int[EXTENDED_ASCII_COUNT];
        int [] countArray2 = new int[EXTENDED_ASCII_COUNT];

        for(int i = 0; i < stringA.length(); i++) {
            countArray1[stringA.charAt(i)]++;
            countArray2[stringB.charAt(i)]++;
        }

        boolean isEqual = false;
        for(int j = 0; j < EXTENDED_ASCII_COUNT; j++) {
            if(countArray1[j] != countArray2[j]) {
                isEqual = false;
                break;
            }
            isEqual = true;
        }
        System.out.println(stringB + (isEqual ? " is a " : " is not a ") + "permutation of " + stringA);
        return isEqual;
    }

    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        stringPermutation.isStringPermutationOfOther_BigO_nSquare("AMC", "CAM");
        stringPermutation.isStringPermutationOfOther_BigO_nSquare("SMC", "MCS");
        stringPermutation.isStringPermutationOfOther_BigO_nSquare("SSC", "SCS");
        stringPermutation.isStringPermutationOfOther_BigO_nSquare("AAA", "BBA");
        stringPermutation.isStringPermutationOfOther_BigO_nSquare("$$", "BBA");
        stringPermutation.isStringPermutationOfOther_BigO_nSquare("﷽﷽", "\uD809\uDC29");
        stringPermutation.isStringPermutationOfOther_BigO_nSquare("\uD809\uDC29", "\uD809\uDC29");

        System.out.println("-------------------------------------");

        stringPermutation.isStringPermutationOfOther_BigO_NLogN("AMC", "CAM");
        stringPermutation.isStringPermutationOfOther_BigO_NLogN("SMC", "MCS");
        stringPermutation.isStringPermutationOfOther_BigO_NLogN("SSC", "SCS");
        stringPermutation.isStringPermutationOfOther_BigO_NLogN("AAA", "BBA");
        stringPermutation.isStringPermutationOfOther_BigO_NLogN("$$", "BBA");
        stringPermutation.isStringPermutationOfOther_BigO_NLogN("﷽﷽", "\uD809\uDC29");
        stringPermutation.isStringPermutationOfOther_BigO_NLogN("\uD809\uDC29", "\uD809\uDC29");

        System.out.println("-------------------------------------");

        stringPermutation.isStringPermutationOfOther_BigO_N("AMC", "CAM");
        stringPermutation.isStringPermutationOfOther_BigO_N("SMC", "MCS");
        stringPermutation.isStringPermutationOfOther_BigO_N("SSC", "SCS");
        stringPermutation.isStringPermutationOfOther_BigO_N("AAA", "BBA");
        stringPermutation.isStringPermutationOfOther_BigO_N("$$", "BBA");
        stringPermutation.isStringPermutationOfOther_BigO_N("AAA", "aaa");

        //stringPermutation.isStringPermutationOfOther_BigO_N("﷽﷽", "\uD809\uDC29");
        //stringPermutation.isStringPermutationOfOther_BigO_N("\uD809\uDC29", "\uD809\uDC29");
    }
}