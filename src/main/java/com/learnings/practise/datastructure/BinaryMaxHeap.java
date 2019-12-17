package com.learnings.practise.datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BinaryMaxHeap {

    private int [] data;
    private int size = 0;
    private final int ROOT_INDEX = 0;

    BinaryMaxHeap(int initialCapacity) {
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
        if(data[parentIndex] < data[index]) {
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
        Integer getBiggestChildIndex = getBiggestChildIndex(index);
        if(null != getBiggestChildIndex) {
            int parent = data[index];
            data[index] = data[getBiggestChildIndex];
            data[getBiggestChildIndex] = parent;
            bubbleDown(getBiggestChildIndex);
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

    private Integer getBiggestChildIndex(int index) {
        if(isLeaf(index)) {
            return null;
        }
        if(data[getRightChildIndex(index)] == 0) {
            return data[getLeftChildIndex(index)] > data[index] ? getLeftChildIndex(index) : null;
        }
        return (data[getLeftChildIndex(index)] > data[getRightChildIndex(index)]) ? getLeftChildIndex(index) : getRightChildIndex(index);
    }

    @Override
    public String toString() {
        return "BinaryMinHeap: " + Arrays.toString(data);
    }

    public static void main(String[] args) {
        BinaryMaxHeap binaryMaxHeap = new BinaryMaxHeap(10);
        binaryMaxHeap.insert(4);
        binaryMaxHeap.insert(5);
        binaryMaxHeap.insert(6);
        binaryMaxHeap.insert(2);
        binaryMaxHeap.insert(7);
        binaryMaxHeap.insert(8);
        binaryMaxHeap.insert(3);
        binaryMaxHeap.insert(9);

        System.out.println("After Inserting      : " + binaryMaxHeap);
        System.out.println("After Deleting root " + binaryMaxHeap.delete() + ": " + binaryMaxHeap);
        System.out.println("After Deleting root " + binaryMaxHeap.delete() + ": " + binaryMaxHeap);

        binaryMaxHeap.insert(10);
        System.out.println("After Inserting 10   : " + binaryMaxHeap);
        System.out.println("After Deleting root " + binaryMaxHeap.delete() + ": " + binaryMaxHeap);

        System.out.println("Heap Sort >>>>>");
        int [] unSortedArray = new int[] {7, 3, 8, 2, 10, 23, 1, 17, 15, 12};
        System.out.println("UnSorted Array : " + Arrays.toString(unSortedArray));

        //Step 1: Construction
        binaryMaxHeap = new BinaryMaxHeap(unSortedArray.length);
        for(int i : unSortedArray) {
            binaryMaxHeap.insert(i);
        }
        System.out.println("After Heap Construction: " + binaryMaxHeap);

        //Step 2: Keep Deleting the Root and collect it in a sorted array
        int [] sortedArray = new int[unSortedArray.length];
        for(int i = 0; i < unSortedArray.length; i++) {
            sortedArray[i] = binaryMaxHeap.delete();
        }
        System.out.println("After Removing Root and Collecting as Sorted Array : " + Arrays.toString(sortedArray));
    }
}