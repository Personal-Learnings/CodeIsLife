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

        if(l1 == null && l2 != null) return l2;
        if(l2 == null && l1 != null) return l1;

        ListNode l1Iterator = l1;
        ListNode l2Iterator = l2;
        ListNode resultNode = new ListNode(0);
        ListNode resultNodeIterator = resultNode;

        while(l1Iterator != null || l2Iterator != null) {
            int l1Val = (l1Iterator == null) ? Integer.MAX_VALUE : l1Iterator.val;
            int l2Val = (l2Iterator == null) ? Integer.MAX_VALUE : l2Iterator.val;

            if(l1Val < l2Val) {
                resultNodeIterator.next = new ListNode(l1Val);
                l1Iterator = l1Iterator.next;
            } else {
                resultNodeIterator.next = new ListNode(l2Val);
                l2Iterator = l2Iterator.next;
            }
            resultNodeIterator = resultNodeIterator.next;
        }
        return resultNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
