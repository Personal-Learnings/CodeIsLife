package com.learnings.practise.problems.leetcode.ms.explore;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 2) return true;

        int p1 = 0, p2 = s.length() - 1;
        while(p1 < p2) {
            char charAtP1 = Character.toLowerCase(s.charAt(p1));
            char charAtP2 = Character.toLowerCase(s.charAt(p2));

            boolean isCharAtP1Valid = Character.isDigit(charAtP1) || Character.isLetter(charAtP1);
            boolean isCharAtP2Valid = Character.isDigit(charAtP2) || Character.isLetter(charAtP2);

            if(isCharAtP1Valid && isCharAtP2Valid) {
                if(charAtP1 == charAtP2) {
                    p1++; p2--;
                } else {
                    return false;
                }
            } else if(isCharAtP1Valid) {
                p2--;
            } else if(isCharAtP2Valid) {
                p1++;
            } else {
                p1++; p2--;
            }
        }
        return true;
    }

    public boolean isPalindrome_littleSlower(String s) {
        if(s == null || s.length() < 2) return true;

        StringBuilder sb = new StringBuilder();
        for(Character c : s.toCharArray()) {
            if(Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        if(sb.length() < 2) return true;

        int p1 = 0, p2 = sb.length() - 1;
        while(p1 < p2) {
            if(sb.charAt(p1) == sb.charAt(p2)) {
                p1++; p2--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome_littleSlower("He*llo, oll+eH"));
        System.out.println(new ValidPalindrome().isPalindrome_littleSlower("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome_littleSlower("race a car"));

        System.out.println(new ValidPalindrome().isPalindrome("He*llo, oll+eH"));
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
    }
}