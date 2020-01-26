package com.learnings.practise.problems.leetcode.an;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionLabels {

    /**
     * Time Complexity: O(s) where s is the length of String
     * Space Complexity: O(1) the space is constant because for any size of the input the space would never be more than 26
     */
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0) return Collections.emptyList();

        //As the input says string will have range from a to z
        int[] lastOccurrence = new int[26];

        //Get all last occurrences of the chars
        for (int i = 0; i < S.length(); ++i) {
            lastOccurrence[S.charAt(i) - 'a'] = i;
        }

        //To Track the End of Current Partition
        int endOfPartition = 0;

        //To Track the Result
        List<Integer> partitions = new ArrayList<>();

        //Grow the window until the end of the partition is reached
        for (int windowStart = 0, windowEnd = 0; windowEnd < S.length(); ++windowEnd) {

            endOfPartition = Math.max(endOfPartition, lastOccurrence[S.charAt(windowEnd) - 'a']);

            //When end of partition is reached add to the result and slide the window start
            if (windowEnd == endOfPartition) {
                partitions.add(windowEnd - windowStart + 1);
                windowStart = windowEnd + 1;
            }
        }
        return partitions;
    }

    public List<Integer> partitionLabels_1(String S) {
        if(S == null || S.length() == 0) return Collections.emptyList();

        int[] lastOccurrence = new int[26];
        for (int i = 0; i < S.length(); ++i)
            lastOccurrence[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, lastOccurrence[S.charAt(i) - 'a']);
            if (i == j) {
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("amabmmijklkjkccccc"));
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}