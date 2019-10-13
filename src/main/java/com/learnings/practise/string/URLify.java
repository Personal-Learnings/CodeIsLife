package com.learnings.practise.string;

public class URLify {

    private String urliFyString_BigO_N_usingArray(String inputString, int validCharacters) {
        int noOfSpaces = 0;
        char [] inputArray = inputString.toCharArray();
        char [] trimmedArray = new char[validCharacters];
        boolean isNonSpaceCharStarted = false;

        for(int c = 0, i = 0; c < inputArray.length; c++) {
            if(inputArray[c] != ' ') {
                isNonSpaceCharStarted = true;
            }
            if(isNonSpaceCharStarted && i < validCharacters) {
                if(inputArray[c] == ' ') noOfSpaces++;
                trimmedArray[i] = inputArray[c];
                ++i;
            }
        }
        int outputArraySize = trimmedArray.length + (noOfSpaces * 2);
        char [] outputArray = new char[outputArraySize];
        int k = 0;
        int s = 0;
        while(s < validCharacters && k < outputArraySize) {
            char currentChar = trimmedArray[s];
            if(currentChar != ' ') {
                outputArray[k] = currentChar;
                k++;
            } else {
                outputArray[k] = '%';
                outputArray[k + 1] = '2';
                outputArray[k + 2] = '0';
                k+=3;
            }
            s++;
        }
        return String.valueOf(outputArray);
    }

    private String urliFyString_BigO_N_usingStringUtilities(String inputString) {
        return null != inputString ? inputString.trim().replaceAll(" ", "%20") : null;
    }

    public static void main(String[] args) {
        URLify urLify = new URLify();
        System.out.println(urLify.urliFyString_BigO_N_usingStringUtilities("My Name is Madanraj Venkatesan"));
        System.out.println(urLify.urliFyString_BigO_N_usingStringUtilities("     My Name is Madanraj Venkatesan       "));

        System.out.println(urLify.urliFyString_BigO_N_usingArray("My Name is Madanraj Venkatesan", 30));
        System.out.println(urLify.urliFyString_BigO_N_usingArray("     My Name is Madanraj Venkatesan       ", 30));
        System.out.println(urLify.urliFyString_BigO_N_usingArray("     My Name ﷽﷽ is   Madanraj Venkatesan       ", 35));
    }
}
