package com.learnings.practise;

import java.nio.charset.Charset;

public class StringHasUniqueCharacters {

    private boolean isUnique_BigO_nSquare(char [] input) {
        if(input == null) return false;
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] == input[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isUnique_BigO_n_ASCII(char [] input) {
        if(input == null) return false;
        if(input.length > 256) return false;
        boolean [] results = new boolean[256];

        for (int ascii : input) {
            if (results[ascii]) {
                return false;
            }
            results[ascii] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Result " +  new StringHasUniqueCharacters().isUnique_BigO_nSquare("9876351".toCharArray()));
        System.out.println("Result " +  new StringHasUniqueCharacters().isUnique_BigO_n_ASCII("12©45".toCharArray()));

        int unicodePlanes = 17;
        int charactersInUnicodePlane = 65536;
        int unicodeCharacters = unicodePlanes * charactersInUnicodePlane;

        for (int i = 0; i <= unicodeCharacters; i++) {
            char unicode = (char) i;
            if(i > unicodeCharacters - 100) {
                System.out.println("Unicode Number: " + i + " Unicode Char: " + unicode + " Bytes: ");
            }
        }

        for (char c : "Madan".toCharArray()) {
            System.out.println((int) c);
            System.out.printf(c + ">>" + "\\u%04x\n", (int) c);
            System.out.println("u%04x");
        }

        System.out.println(Integer.toHexString(697));
        System.out.println( "\\u" + Integer.toHexString('n' | 0x10000).substring(1) );
        System.out.println(Charset.defaultCharset());
        char c = '﷽';
        char s = 'A';
        System.out.println("Widest Unicode Character: " + c + " \uD809\uDC29");
    }
}