package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;

        ListNode aCopy = headA;
        ListNode bCopy = headB;

        while(headA != headB && headA != null && headB != null) {

            headA = headA.next;
            headB = headB.next;

            if(headA == null) {
               headA = bCopy;
               bCopy = null;
            }
            if(headB == null) {
                headB = aCopy;
                aCopy = null;
            }
        }
        return headA;
    }

    public ListNode getIntersectionNode_withExtraSpace(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode currentNode = headA;
        while (currentNode != null) {
            set.add(currentNode);
            currentNode = currentNode.next;
        }

        currentNode = headB;
        while (currentNode != null) {
            if (set.contains(currentNode)) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    public static void main(String[] args) {

        ListNode three = new ListNode(3);
        three.next = new ListNode(4);

        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = three;

        ListNode m = new ListNode(8);
        m.next = new ListNode(6);
        m.next.next = new ListNode(7);
        m.next.next.next = three;

        IntersectionOfTwoLinkedLists i = new IntersectionOfTwoLinkedLists();
        ListNode result = i.getIntersectionNode(l, m);
        System.out.println(result);

        i = new IntersectionOfTwoLinkedLists();
        ListNode t = new ListNode(3);
        ListNode s = new ListNode(2);
        s.next = t;
        result = i.getIntersectionNode(t, s);
        System.out.println(result);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }
}
