package com.learnings.practise.problems.leetcode;

import java.util.*;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists_BigO_nLogN(ListNode l1, ListNode l2) {

        List<Integer> result = new ArrayList<>();
        ListNode x = l1;
        ListNode y = l2;

        while(x != null) {
            result.add(x.val);
            x = x.next;
        }
        while(y != null) {
            result.add(y.val);
            y = y.next;
        }
        Collections.sort(result);

        ListNode resultNode = null;
        ListNode tailNode = null;
        for(int i : result) {

            if(resultNode == null) {
                resultNode = new ListNode(i);
                tailNode = resultNode;
            } else {
                tailNode.next = new ListNode(i);
                tailNode = tailNode.next;
            }
        }
        return resultNode;
    }

    public ListNode mergeTwoLists_BigO_N(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists_BigO_N(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_BigO_N(l2.next, l1);
            return l2;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Integer [][] ss = new Integer[1][2];
        ss[0][0] = 3;
        ss[0][1] = 4;
        Integer [][] sa = ss.clone();;

        ss[0][0] = 5;
        ss[0][1] = 6;

        for(int i = 0; i < sa.length; i++) {
            for(int j = 0; j < sa[i].length; j++) {
                System.out.println(sa[i][j]);
            }
        }
        for(int i = 0; i < ss.length; i++) {
            for(int j = 0; j < ss[i].length; j++) {
                System.out.println(ss[i][j]);
            }
        }
    }
}
