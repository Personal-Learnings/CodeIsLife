package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }

    public boolean hasCycle_slow(ListNode head) {
        if(head == null) return false;

        ListNode currentNode = head;
        Set<ListNode> set = new HashSet<>();

        while(currentNode != null) {
            if(set.contains(currentNode)) return true;

            set.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}