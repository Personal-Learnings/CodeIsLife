package com.learnings.practise.problems.leetcode;

import java.util.*;

public class FlattenNestedListIterator implements Iterator<Integer> {

    private Queue<Integer> queue;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        addToQueue(nestedList);
    }

    private void addToQueue(List<NestedInteger> nestedList) {
        for(NestedInteger n : nestedList) {
            if(n.isInteger()) {
                queue.add(n.getInteger());
            } else {
                addToQueue(n.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();
        System.out.println(new FlattenNestedListIterator(list));
    }

    interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }
}
