package com.learnings.practise.problems.string;

import java.util.*;

public class StringPermutation {

    private boolean isStringPermutationOfOther_BigO_nSquare(String stringA, String stringB) {
        Set<String> permutations = new HashSet<>();

        if(stringA.length() != stringB.length()) return false;
        else if(stringA.equals(stringB)) return true;

        for(int i = 0; i < stringA.length(); i++) {
            Character pivot = stringA.charAt(i);
            StringBuilder remainingCharacters = new StringBuilder(stringA.substring(0, i) + stringA.substring(i + 1));

            for(int j = 0; j < stringA.length(); j++) {
                permutations.add(
                        (j < remainingCharacters.length())
                                ? remainingCharacters.insert(j, pivot).toString()
                                : remainingCharacters.append(stringA.charAt(i)).toString()
                );
                remainingCharacters.deleteCharAt(j);
            }
        }
        return permutations.contains(stringB);
    }

    private boolean isStringPermutationOfOther_BigO_NLogN(String stringA, String stringB) {
        if(stringA.length() != stringB.length()) return false;
        else if(stringA.equals(stringB)) return true;

        char [] arrayA = stringA.toCharArray();
        char [] arrayB = stringB.toCharArray();

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        for(int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] != arrayB[i]) return false;
        }
        return true;
        //.equals and .toString is gonna take some time, so shifting to the above approach
        //boolean isEqual = Arrays.toString(arrayA).equals(Arrays.toString(arrayB));
        //System.out.println(stringB + (isEqual ? " is a " : " is not a ") + "permutation of " + stringA);
        //return isEqual;
    }

    private boolean isStringPermutationOfOther_BigO_N(String stringA, String stringB) {
        if (stringA.length() != stringB.length()) return false;

        //Assuming the String is a Extended ASCII
        final int EXTENDED_ASCII_COUNT = 256;
        int [] countArray1 = new int[EXTENDED_ASCII_COUNT];
        int [] countArray2 = new int[EXTENDED_ASCII_COUNT];

        for(int i = 0; i < stringA.length(); i++) {
            if(stringA.charAt(i) > 256 || stringB.charAt(i) > 256) {
                System.out.println("\nNot An Extended ASCII String");
                return false;
            }
            countArray1[stringA.charAt(i)]++;
            countArray2[stringB.charAt(i)]++;
        }

        for(int j = 0; j < EXTENDED_ASCII_COUNT; j++) {
            if(countArray1[j] != countArray2[j]) return false;
        }
        return true;
    }

    private boolean isStringPermutationOfOther_BigO_N_lesserSpace(String stringA, String stringB) {
        if (stringA.length() != stringB.length()) return false;

        //Assuming the String is a Extended ASCII
        final int EXTENDED_ASCII_COUNT = 256;
        int [] countArray = new int[EXTENDED_ASCII_COUNT];

        for(int i = 0; i < stringA.length(); i++) {
            if(stringA.charAt(i) > 256 || stringB.charAt(i) > 256) {
                System.out.println("\nNot An Extended ASCII String");
                return false;
            }
            countArray[stringA.charAt(i)]++;
        }

        for(int j = 0; j < stringB.length(); j++) {
            int index = stringB.charAt(j);
            countArray[index]--;
            if(countArray[index] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        StringPermutation stringPermutation = new StringPermutation();
        Map<String, String> inputMap = new LinkedHashMap<>();
        inputMap.put("AMC", "CAM");
        inputMap.put("SMC", "MCS");
        inputMap.put("SSC", "SCS");
        inputMap.put("AAA", "BBA");
        inputMap.put("$$", "BBA");
        inputMap.put("﷽﷽", "\uD809\uDC29");
        inputMap.put("\uD809\uDC29", "\uD809\uDC29");

        inputMap.forEach((stringA, stringB) -> {
            System.out.println(stringA + " & " + stringB + " => " + stringPermutation.isStringPermutationOfOther_BigO_nSquare(stringA, stringB));
        });
        System.out.println("-------------------------------------");

        inputMap.forEach((stringA, stringB) -> {
            System.out.println(stringA + " & " + stringB + " => " + stringPermutation.isStringPermutationOfOther_BigO_NLogN(stringA, stringB));
        });
        System.out.println("-------------------------------------");

        inputMap.forEach((stringA, stringB) -> {
            System.out.println(stringA + " & " + stringB + " => " + stringPermutation.isStringPermutationOfOther_BigO_N(stringA, stringB));
        });
        System.out.println("-------------------------------------");

        inputMap.forEach((stringA, stringB) -> {
            System.out.println(stringA + " & " + stringB + " => " + stringPermutation.isStringPermutationOfOther_BigO_N_lesserSpace(stringA, stringB));
        });
    }
}