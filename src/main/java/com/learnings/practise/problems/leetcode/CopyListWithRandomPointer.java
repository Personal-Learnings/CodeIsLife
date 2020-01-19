package com.learnings.practise.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    /**
     * Time Complexity: O(N) where N is the number of nodes in the linked list.
     * Space Complexity: O(1). As we have to perform a deep copy we have to create a node with similar structure, apart from the
     * space used to create result/output there are no other data structure used for processing. so the Space Complexity is O(1)
     */
    private Node copyRandomList(Node head) {

        //Create a copy of the same node and place it to adjacent to it
        Node iteratorNode = head;
        while(iteratorNode != null) {
            Node nextNode = iteratorNode.next;

            Node copyNode = new Node(iteratorNode.val);
            copyNode.next = nextNode;
            iteratorNode.next = copyNode;

            iteratorNode = nextNode;
        }

        //Create Random Pointer Link
        iteratorNode = head;
        while(iteratorNode != null) {
            if(iteratorNode.random != null) {
                iteratorNode.next.random = iteratorNode.random.next;
            }
            iteratorNode = iteratorNode.next.next;
        }

        //Split the list
        Node result = new Node(0);
        Node resultIterator = result;
        iteratorNode = head;
        while(iteratorNode != null) {
            resultIterator.next = iteratorNode.next;
            iteratorNode.next = iteratorNode.next.next;

            resultIterator = resultIterator.next;
            iteratorNode = iteratorNode.next;
        }
        return result.next;
    }

    /**
     * Time Complexity: O(N) where N is the number of nodes in the linked list.
     * Space Complexity: O(N). If we look closely, we have the recursion stack and we also have the space complexity
     * to keep track of nodes already cloned i.e. using the visited dictionary. But asymptotically, the complexity is O(N)
     */
    private Map<Node, Node> cache = new HashMap<>();
    public Node copyRandomList_recursive(Node head) {
        if(head == null) return null;

        if(cache.containsKey(head)) return cache.get(head);

        Node node = new Node(head.val);
        cache.put(head, node);

        node.next = copyRandomList_recursive(head.next);
        node.random = copyRandomList_recursive(head.random);

        return node;
    }

    /**
     * Time Complexity: O(N) where N is the number of nodes in the linked list.
     * Space Complexity: O(N). If we look closely, we have the recursion stack and we also have the space complexity
     * to keep track of nodes already cloned i.e. using the visited dictionary. But asymptotically, the complexity is O(N)
     *
     * EASY TO UNDERSTAND
     */
    public Node copyRandomList_iterative(Node head) {
        Map<Node, Node> cache = new HashMap<>();
        if(head == null) return null;

        Node currentNode = head;
        while(currentNode != null) {
            cache.put(currentNode, new Node(currentNode.val));
            currentNode = currentNode.next;
        }

        currentNode = head;
        while(currentNode != null) {
            cache.get(currentNode).next = cache.get(currentNode.next);
            cache.get(currentNode).random = cache.get(currentNode.random);
            currentNode = currentNode.next;
        }

        return cache.get(head);
    }

    public static void main(String[] args) {

        Node ten = new Node(10);
        Node nine = new Node(9);
        Node eight = new Node(8);

        eight.next = nine;
        eight.random = ten;

        nine.next = ten;
        ten.random = nine;

        new CopyListWithRandomPointer().copyRandomList(eight);

        /** Practise or Linked List */
        //Basic Iteration of Linked List
        Node iteratorNode = eight;
        while(iteratorNode != null) {
            System.out.print(iteratorNode.val + " -> ");
            iteratorNode = iteratorNode.next;
        }

        System.out.println("\n--------");

        //Iterate, copy and Print a Linked List with only values
        iteratorNode = eight;
        Node result = new Node(0);
        Node resultIterator = result;

        while(iteratorNode != null) {
            resultIterator.next = new Node(iteratorNode.val);
            resultIterator = resultIterator.next;
            iteratorNode = iteratorNode.next;
        }

        iteratorNode = result.next;
        while(iteratorNode != null) {
            System.out.print(iteratorNode.val + " -> ");
            iteratorNode = iteratorNode.next;
        }

        System.out.println("\n--------");

        //Iterate, copy and Print a Linked List with values and other references
        iteratorNode = eight;
        Map<Node, Node> map = new HashMap<>();
        while(iteratorNode != null) {
            map.putIfAbsent(iteratorNode, new Node(iteratorNode.val));
            iteratorNode = iteratorNode.next;
        }

        iteratorNode = eight;

        while(iteratorNode != null) {
            map.get(iteratorNode).next = map.get(iteratorNode.next);
            map.get(iteratorNode).random = map.get(iteratorNode.random);
            iteratorNode = iteratorNode.next;
        }

        System.out.println(map.get(eight));
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
