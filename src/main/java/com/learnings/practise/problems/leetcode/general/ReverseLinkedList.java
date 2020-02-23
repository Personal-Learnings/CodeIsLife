package com.learnings.practise.problems.leetcode.general;

import com.learnings.practise.problems.leetcode.CopyListWithRandomPointer;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode prevNode = null;
        ListNode currentNode = head;

        while(currentNode != null) {
            ListNode temp = currentNode.next;
            currentNode.next = prevNode;

            prevNode = currentNode;
            currentNode = temp;
        }
        return prevNode;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
