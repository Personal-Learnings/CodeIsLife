package com.learnings.practise.problems.leetcode.general;

public class StringToInteger_ATOI {

    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int i = 0, result = 0; boolean isNegative = false;
        int length = str.length();
        while(i < length) {
            if(str.charAt(i) == ' ') ++i;
            else break;
        }

        if(i < length && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            isNegative = str.charAt(i) == '-';
            ++i;
        }

        while(i < length && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            ++i;
        }
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger_ATOI().myAtoi("2147483646"));
        System.out.println(new StringToInteger_ATOI().myAtoi("21"));
        System.out.println(new StringToInteger_ATOI().myAtoi("-21"));
        System.out.println(new StringToInteger_ATOI().myAtoi("-21 Hello"));
        System.out.println(new StringToInteger_ATOI().myAtoi("      21 Hello"));
        System.out.println(new StringToInteger_ATOI().myAtoi("-21474836410"));
        System.out.println(new StringToInteger_ATOI().myAtoi("214748364"));
        System.out.println(Integer.MAX_VALUE % 10);
    }
}
