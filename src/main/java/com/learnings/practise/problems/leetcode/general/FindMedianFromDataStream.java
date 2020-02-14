package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class FindMedianFromDataStream {

    /* Bucket Holds Larger Values */
    private Queue<Integer> minHeap;

    /* Bucket Holds Smaller Values */
    private Queue<Integer> maxHeap;

    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    /**
     * Time Complexity: O(Log N) for each time it is invoked
     * Space Complexity: O(Log N)
     */
    public void addNum(int num) {
        if(minHeap.size() == maxHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    /**
     * Time Complexity: O(1) for each time it is invoked
     * Space Complexity: O(1) to return result
     */
    public double findMedian() {
        return minHeap.size() == maxHeap.size() ? ((minHeap.peek() + maxHeap.peek()) * 0.5) : maxHeap.peek();
    }

    //Slower
    /*private List<Integer> list;

    public FindMedianFromDataStream() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        int midIndex = list.size() / 2;
        return (list.size() % 2 == 0) ? ((list.get(midIndex - 1) + list.get(midIndex)) * 0.5) : list.get(midIndex);
    }*/

    public static void main(String[] args) {
        FindMedianFromDataStream findMedianFromDataStream = new FindMedianFromDataStream();
        findMedianFromDataStream.addNum(6);
        System.out.println(findMedianFromDataStream.findMedian());
        findMedianFromDataStream.addNum(10);
        System.out.println(findMedianFromDataStream.findMedian());
        findMedianFromDataStream.addNum(2);
        System.out.println(findMedianFromDataStream.findMedian());
        findMedianFromDataStream.addNum(5);
        System.out.println(findMedianFromDataStream.findMedian());
        findMedianFromDataStream.addNum(4);
        System.out.println(findMedianFromDataStream.findMedian());
        findMedianFromDataStream.addNum(9);
        System.out.println(findMedianFromDataStream.findMedian());
    }
}