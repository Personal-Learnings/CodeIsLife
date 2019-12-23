package com.learnings.practise.problems.leetcode;

import java.util.Arrays;

public class TwoSumLessThanK {

    public int twoSumLessThanK_BigO_n2(int[] a, int k) {
        int s = -1;
        for(int i=0; i < a.length; i++) {
            for(int j=i; j < a.length; j++) {
                int sum = a[i] + a[j];
                if(i < j && sum < k && sum > s) {
                    s = sum;
                }
            }
        }
        return s;
    }

    public int twoSumLessThanK_BigO_nlogn(int[] a, int k) {
        //Sorting the Array o(n log n)
        Arrays.sort(a);

        int l = a.length;
        int s = -1, lowerBound = 0, upperBound = l - 1;

        while(lowerBound < upperBound) {
            int sum = a[lowerBound] + a[upperBound];
            if(sum < k) {
                s = Math.max(s, sum);
                ++lowerBound; //may be too lower increase the lower bound
            } else {
                --upperBound; //may be too higher decrease the upper bound
            }
        }
        return s;
    }
}