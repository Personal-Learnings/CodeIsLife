package com.learnings.practise.problems.leetcode;

public class IntegerToEnglishWords {

    private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while(num > 0) {
            if(num % 1000 != 0) result.insert(0, getAsWord(num % 1000) + THOUSANDS[i] + " ");
            num /= 1000;
            ++i;
        }
        return result.toString().trim();
    }

    private String getAsWord(int num) {
        if(num == 0) return "";
        else if(num < 20) return LESS_THAN_TWENTY[num] + " ";
        else if(num < 100) return TENS[num / 10] + " " + getAsWord(num % 10);
        else return LESS_THAN_TWENTY[num / 100] + " Hundred " + getAsWord(num % 100);
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToEnglishWords().numberToWords(123));
        System.out.println(new IntegerToEnglishWords().numberToWords(1234));
        System.out.println(new IntegerToEnglishWords().numberToWords(12345));
        System.out.println(new IntegerToEnglishWords().numberToWords(123456));
        System.out.println(new IntegerToEnglishWords().numberToWords(1234567));
        System.out.println(new IntegerToEnglishWords().numberToWords(12345678));
        System.out.println(new IntegerToEnglishWords().numberToWords(123456789));
        System.out.println(new IntegerToEnglishWords().numberToWords(1234567899));
    }
}