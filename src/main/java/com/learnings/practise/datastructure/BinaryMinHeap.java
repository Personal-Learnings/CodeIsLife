package com.learnings.practise.datastructure;

import java.util.*;

public class BinaryMinHeap {

    private int [] data;
    private int size = 0;
    private final int ROOT_INDEX = 0;

    BinaryMinHeap(int initialCapacity) {
        this.data = new int[initialCapacity];
    }

    private void insert(int input) {
        data[getSize()] = input;
        bubbleUp(getSize());
        ++size;
    }

    private void bubbleUp(int index) {
        if(index == 0) {
            return;
        }
        int parentIndex = getParentIndex(index);
        if(data[parentIndex] > data[index]) {
            int parent = data[parentIndex];
            data[parentIndex] = data[index];
            data[index] = parent;
            data[index] = parent;
            bubbleUp(parentIndex);
        }
    }

    private void bubbleDown(int index) {
        if(isLeaf(index) && index >= getLastIndex()) {
            return;
        }
        Integer smallestChildIndex = getSmallestChildIndex(index);
        if(null != smallestChildIndex) {
            int parent = data[index];
            data[index] = data[smallestChildIndex];
            data[smallestChildIndex] = parent;
            bubbleDown(smallestChildIndex);
        }
    }

    private boolean isLeaf(int index) {
        return getLeftChildIndex(index) >= getSize() && getRightChildIndex(index) >= getSize();
    }

    private int delete() {
        int root  = data[ROOT_INDEX];
        data[ROOT_INDEX] = data[getLastIndex()];
        data[getLastIndex()] = 0;
        size--;
        bubbleDown(ROOT_INDEX);
        return root;
    }

    private int getLastIndex() {
        return getSize() - 1;
    }

    private int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return getSize() == 0;
    }

    private int getParentIndex(int index) {
        int a = Math.abs(index - 1);
        double parent = a / 2d;
        return (int) Math.floor(parent);
    }

    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    private Integer getSmallestChildIndex(int index) {
        if(isLeaf(index)) {
            return null;
        }
        if(data[getRightChildIndex(index)] == 0) {
            return data[getLeftChildIndex(index)] < data[index] ? getLeftChildIndex(index) : null;
        }
        return (data[getLeftChildIndex(index)] < data[getRightChildIndex(index)]) ? getLeftChildIndex(index) : getRightChildIndex(index);
    }

    @Override
    public String toString() {
        return "BinaryMinHeap: " + Arrays.toString(data);
    }

    public static void main(String[] args) {
        BinaryMinHeap binaryMinHeap = new BinaryMinHeap(10);
        binaryMinHeap.insert(4);
        binaryMinHeap.insert(5);
        binaryMinHeap.insert(6);
        binaryMinHeap.insert(2);
        binaryMinHeap.insert(7);
        binaryMinHeap.insert(8);
        binaryMinHeap.insert(3);
        binaryMinHeap.insert(9);

        System.out.println("After Inserting      : " + binaryMinHeap);
        System.out.println("After Deleting root " + binaryMinHeap.delete() + ": " + binaryMinHeap);
        System.out.println("After Deleting root " + binaryMinHeap.delete() + ": " + binaryMinHeap);

        binaryMinHeap.insert(10);
        System.out.println("After Inserting 10   : " + binaryMinHeap);
        System.out.println("After Deleting root " + binaryMinHeap.delete() + ": " + binaryMinHeap);

        System.out.println("Heap Sort >>>>>");
        int [] unSortedArray = new int[] {7, 3, 8, 2, 10, 23, 1, 17, 15, 12};
        System.out.println("Sorted Array : " + Arrays.toString(unSortedArray));

        //Step 1: Construction
        binaryMinHeap = new BinaryMinHeap(unSortedArray.length);
        for(int i : unSortedArray) {
            binaryMinHeap.insert(i);
        }
        System.out.println("After Heap Construction: " + binaryMinHeap);

        //Step 2: Keep Deleting the Root and collect it in a sorted array
        int [] sortedArray = new int[unSortedArray.length];
        for(int i = 0; i < unSortedArray.length; i++) {
            sortedArray[i] = binaryMinHeap.delete();
        }
        System.out.println("After Removing Root and Collecting as Sorted Array : " + Arrays.toString(sortedArray));
    }
}