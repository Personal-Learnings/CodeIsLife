package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.Stack;

public class AddTwoNumbersII {

    /**
     * Without Modifying Original ListNode or not reversing the original ListNode
     */
    private ListNode addTwoNodes_without_modifying_input(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        ListNode currentNode = l1;
        while(currentNode != null) {
            s1.push(currentNode.val);
            currentNode = currentNode.next;
        }

        currentNode = l2;
        while(currentNode != null) {
            s2.push(currentNode.val);
            currentNode = currentNode.next;
        }

        int carryForward = 0;

        while(!s1.isEmpty() || !s2.isEmpty()) {
            int a = 0, b = 0;

            if(!s1.isEmpty()) a = s1.pop();
            if(!s2.isEmpty()) b = s2.pop();

            int sum = a + b + carryForward;
            carryForward = sum / 10;
            s3.push(sum % 10);
        }

        if(carryForward != 0) s3.push(carryForward);

        ListNode dummyNode = new ListNode(0);
        ListNode iteratorNode = dummyNode;

        while(!s3.isEmpty()) {
            iteratorNode.next = new ListNode(s3.pop());
            iteratorNode = iteratorNode.next;
        }
        return dummyNode.next;
    }

    private ListNode addTwoNodes_faster_but_reverses_input(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;

        l1 = reverseLinkedList(l1);
        l2 = reverseLinkedList(l2);

        int carryForward = 0;

        ListNode dummyNode = new ListNode(0);
        ListNode iteratorNode = dummyNode;

        while(l1 != null || l2 != null) {
            int val1 = 0, val2 = 0;

            if(l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int sum = val1 + val2 + carryForward;
            carryForward = sum / 10;
            iteratorNode.next = new ListNode(sum % 10);
            iteratorNode = iteratorNode.next;
        }

        if(carryForward != 0) iteratorNode.next = new ListNode(carryForward);

        return reverseLinkedList(dummyNode.next);
    }

    private ListNode reverseLinkedList(ListNode list) {

        ListNode current = list;
        ListNode prev = null;

        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(7);
        l.next = new ListNode(2);
        l.next.next = new ListNode(4);
        l.next.next.next = new ListNode(3);

        ListNode m = new ListNode(5);
        m.next = new ListNode(6);
        m.next.next = new ListNode(4);

        ListNode listNode = new AddTwoNumbersII().addTwoNodes_faster_but_reverses_input(l, m);
        System.out.println(listNode);

        l = new ListNode(5);
        m = new ListNode(5);

        listNode = new AddTwoNumbersII().addTwoNodes_faster_but_reverses_input(l, m);
        System.out.println(listNode);





        l = new ListNode(7);
        l.next = new ListNode(2);
        l.next.next = new ListNode(4);
        l.next.next.next = new ListNode(3);

        m = new ListNode(5);
        m.next = new ListNode(6);
        m.next.next = new ListNode(4);

        listNode = new AddTwoNumbersII().addTwoNodes_without_modifying_input(l, m);
        System.out.println(listNode);

        l = new ListNode(5);
        m = new ListNode(5);

        listNode = new AddTwoNumbersII().addTwoNodes_without_modifying_input(l, m);
        System.out.println(listNode);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }
}