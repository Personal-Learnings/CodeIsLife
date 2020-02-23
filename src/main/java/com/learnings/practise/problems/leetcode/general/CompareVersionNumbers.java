package com.learnings.practise.problems.leetcode.general;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int l1 = v1.length;
        int l2 = v2.length;
        int max = Math.max(l1, l2);

        for(int i = 0; i < max; i++) {
            int r1 = (i < l1) ? Integer.parseInt(v1[i]) : 0;
            int r2 = (i < l2) ? Integer.parseInt(v2[i]) : 0;
            if(r1 != r2) {
                return r1 > r2 ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("1.1", "1.2"));
        System.out.println(new CompareVersionNumbers().compareVersion("1.2", "1.1"));
        System.out.println(new CompareVersionNumbers().compareVersion("1.01", "1.001"));
    }
}