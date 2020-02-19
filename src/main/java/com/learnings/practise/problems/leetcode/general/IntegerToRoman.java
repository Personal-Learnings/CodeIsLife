package com.learnings.practise.problems.leetcode.general;

public class IntegerToRoman {

    public String intToRoman(int num) {
        int [] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String [] romans = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        if(num < 1 || num > 3999) throw new IllegalArgumentException("Invalid Number");

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            if(num - numbers[i] >= 0) {
                sb.append(romans[i]);
                num -= numbers[i];
            }
            else i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(10));
        System.out.println(new IntegerToRoman().intToRoman(9));
        System.out.println(new IntegerToRoman().intToRoman(4));
        System.out.println(new IntegerToRoman().intToRoman(19));
        System.out.println(new IntegerToRoman().intToRoman(49));
    }
}
