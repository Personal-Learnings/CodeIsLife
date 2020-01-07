package com.learnings.practise.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    private Map<Node, Node> cache = new HashMap<>();

    /**
     * Time Complexity: O(N) where N is the number of nodes in the linked list.
     * Space Complexity: O(N). If we look closely, we have the recursion stack and we also have the space complexity
     * to keep track of nodes already cloned i.e. using the visited dictionary. But asymptotically, the complexity is O(N)
     */
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        if(cache.containsKey(head)) return cache.get(head);

        Node node = new Node(head.val);
        cache.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    public static void main(String[] args) {

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
