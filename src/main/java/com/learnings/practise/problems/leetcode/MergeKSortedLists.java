package com.learnings.practise.problems.leetcode;

import java.util.*;

public class MergeKSortedLists {

    //Time Complexity: O(NLogK) where N is the number of nodes and K is the number of ListNode in array
    // Better than the _2 approach because always there will be only K items in the priority queue so the offer and poll will take only Log K time.
    // BUT the _2 is faster in leetcode take only 6ms but this one takes 8ms :(
    //Space Complexity: O(n) Creating a new linked list costs and Priority queue will occupy only K space
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        Queue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(list -> list.val));

        for(ListNode node : lists) {
            if(node != null) {
                queue.offer(node);
            }
        }

        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        while(!queue.isEmpty()) {
            currentNode.next = queue.poll();
            currentNode = currentNode.next;

            if(currentNode.next != null) {
                queue.offer(currentNode.next);
            }
        }
        return result.next;
    }

    //Time Complexity: O(NLogN + N) where N are the number of nodes and NLogN for Sorting and N for adding to LinkedList => O(N Log N)
    public ListNode mergeKLists_2(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        Queue<Integer> queue = new PriorityQueue<>();

        for(ListNode node : lists) {
            ListNode currentNode = node;

            while(currentNode != null) {
                queue.offer(currentNode.val);
                currentNode = currentNode.next;
            }
        }

        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        while(!queue.isEmpty()) {
            currentNode.next = new ListNode(queue.poll());
            currentNode = currentNode.next;
        }
        return result.next;
    }

    //Brute Force: Time Complexity: O(N + NLogN + N) where N are the number of nodes and NLogN for Sorting and N for adding to LinkedList => O(N Log N)
    public ListNode mergeKLists_1(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        List<Integer> list = new ArrayList<>();
        for(ListNode node : lists) {
            ListNode currentNode = node;

            while(currentNode != null) {
                list.add(currentNode.val);
                currentNode = currentNode.next;
            }
        }
        Collections.sort(list);

        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        for(Integer val : list) {
            currentNode.next = new ListNode(val);
            currentNode = currentNode.next;
        }
        return result.next;
    }

    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
