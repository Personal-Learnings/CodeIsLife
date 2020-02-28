package com.learnings.practise.problems.leetcode.ms.oa;

import java.util.*;

public class MinAdjSwapsToMakeStringPalindrome {

    private List<String> combinationsForPrint;

    /**
     * Algorithm:
     *     1. First check the given string is a jumbled/shuffled palindrome or not.
     *     2. Next have two pointers p1 at 0 and p2 at s.length - 1 and start iterating.
     *     3. If chars at both the pointers are same then just shrink the window (increase the p1 and decrease the p2).
     *     4. or Else
     *          a. find the matching pair and swap the char to p2 index (increase swap count while swapping) and finally shrink the window.
     *          b. if not found just swap once with adjacent index and increase the swap count (do not shrink the window here)
     *     5. Print the Swap Count
     *
     * Time Complexity: O(n) to find Palindrome + [ O(n) for two pointer iteration * O(n) for checking and swapping ] so => O(n^2)
     * Space Complexity: O(n)
     *
     */
    private int getNoOfSwaps(String s) {
        combinationsForPrint = new ArrayList<>();

        if(s == null || s.length() == 0) return -1;
        int totalSwaps = 0;

        if(isShuffledPalindrome(s)) {
            char[] chars = s.toCharArray();
            int p1 = 0, p2 = chars.length - 1;

            while(p2 > p1) {
                if(chars[p1] != chars[p2]) {
                    int k = p2;
                    while(k > p1 && chars[k] != chars[p1]) k--;

                    if(k == p1) { //When no matching character found
                        swap(chars, p1, p1 + 1);
                        combinationsForPrint.add(Arrays.toString(chars).replaceAll(", ", ""));
                        totalSwaps++;

                    } else { //When Matching character found swap until K reaches p2 position
                        while(k < p2) {
                            swap(chars, k, k + 1);
                            combinationsForPrint.add(Arrays.toString(chars).replaceAll(", ", ""));
                            totalSwaps++;
                            k++;
                        }
                        p1++; p2--;
                    }
                } else {
                    p1++; p2--; //When the characters are equal move on
                }
            }
            return totalSwaps;
        }
        else return -1;
    }

    private static void swap(char[] chars, int k, int i) {
        char temp = chars[k];
        chars[k] = chars[i];
        chars[i] = temp;
    }

    private boolean isShuffledPalindrome(String s) {
        int [] occurrence = new int[26];
        int oddCount = 0;

        for(int i = 0; i < s.length(); i++) occurrence[s.charAt(i) - 'a']++;
        for (int value : occurrence) if (value % 2 != 0) oddCount++;
        return oddCount <= 1;
    }

    /** Another Alternative way to find Palindrome when chars are not has more than lowercase letters  **/
    /*private static boolean isShuffledPalindrome(String s){
        if(s == null || s.length() <= 1) return true;

        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            if(set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() <= 1;
    }*/

    public static void main(String[] args) {
        MinAdjSwapsToMakeStringPalindrome minAdjSwapsToMakeStringPalindrome = new MinAdjSwapsToMakeStringPalindrome();
        System.out.println("Swap Count: " + minAdjSwapsToMakeStringPalindrome.getNoOfSwaps("mamad") + " Swaps: " + minAdjSwapsToMakeStringPalindrome.combinationsForPrint);
        System.out.println("Swap Count: " + minAdjSwapsToMakeStringPalindrome.getNoOfSwaps("omm") + " Swaps: " + minAdjSwapsToMakeStringPalindrome.combinationsForPrint);
        System.out.println("Swap Count: " + minAdjSwapsToMakeStringPalindrome.getNoOfSwaps("acxmca") + " Swaps: " + minAdjSwapsToMakeStringPalindrome.combinationsForPrint);
        System.out.println("Swap Count: " + minAdjSwapsToMakeStringPalindrome.getNoOfSwaps("aabb") + " Swaps: " + minAdjSwapsToMakeStringPalindrome.combinationsForPrint);
        System.out.println("Swap Count: " + minAdjSwapsToMakeStringPalindrome.getNoOfSwaps("ntiin") + " Swaps: " + minAdjSwapsToMakeStringPalindrome.combinationsForPrint);
        System.out.println("Swap Count: " + minAdjSwapsToMakeStringPalindrome.getNoOfSwaps("minppnm") + " Swaps: " + minAdjSwapsToMakeStringPalindrome.combinationsForPrint);
        System.out.println("Swap Count: " + minAdjSwapsToMakeStringPalindrome.getNoOfSwaps("minpnbbpm") + " Swaps: " + minAdjSwapsToMakeStringPalindrome.combinationsForPrint);
        System.out.println("Swap Count: " + minAdjSwapsToMakeStringPalindrome.getNoOfSwaps("madam") + " Swaps: " + minAdjSwapsToMakeStringPalindrome.combinationsForPrint);
    }
}