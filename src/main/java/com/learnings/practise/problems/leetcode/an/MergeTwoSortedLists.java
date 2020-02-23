package com.learnings.practise.problems.leetcode.an;

public class MergeTwoSortedLists {

    /**
     * Time Complexity: O(n + m) where n and m are length of the two input nodes
     * Space Complexity: O(1) as there are no extra space used apart from the the node required for output
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    /**
     * Time Complexity: O(n + m) where n and m are length of the two input nodes
     * Space Complexity: O(1) as there are no extra space used apart from the the node required for output
     **/
    public ListNode mergeTwoLists_iterative(ListNode l1, ListNode l2) {
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;

        ListNode dummyNode = new ListNode(0);
        ListNode iteratorNode = dummyNode;

        while(currentNode1 != null || currentNode2 != null) {
            if(currentNode1 != null && currentNode2 != null) {
                if(currentNode1.val <= currentNode2.val) {
                    iteratorNode.next = new ListNode(currentNode1.val);
                    currentNode1 = currentNode1.next;
                } else {
                    iteratorNode.next = new ListNode(currentNode2.val);
                    currentNode2 = currentNode2.next;
                }
            } else if(currentNode1 != null) {
                iteratorNode.next = new ListNode(currentNode1.val);
                currentNode1 = currentNode1.next;
            } else {
                iteratorNode.next = new ListNode(currentNode2.val);
                currentNode2 = currentNode2.next;
            }
            iteratorNode = iteratorNode.next;
        }
        return dummyNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
