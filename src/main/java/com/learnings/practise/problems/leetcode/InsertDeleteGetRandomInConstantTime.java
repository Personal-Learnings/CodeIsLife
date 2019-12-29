package com.learnings.practise.problems.leetcode;

import java.util.*;

public class InsertDeleteGetRandomInConstantTime {
    private Random random;
    private List<Integer> data;
    private Map<Integer, Integer> dataIndexMap;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomInConstantTime() {
        random = new Random();
        data = new ArrayList<>();
        dataIndexMap = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(dataIndexMap.containsKey(val)) return false;
        dataIndexMap.put(val, data.size());
        data.add(data.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!dataIndexMap.containsKey(val)) return false;
        int lastIndex = data.size() - 1;
        int indexToBeDeleted = dataIndexMap.get(val);

        if(indexToBeDeleted == lastIndex) {
            data.remove(indexToBeDeleted);
        } else {
            Integer valueInLastIndex = data.get(lastIndex);
            data.set(indexToBeDeleted, valueInLastIndex);
            data.remove(lastIndex);
            dataIndexMap.put(valueInLastIndex, indexToBeDeleted);
        }
        dataIndexMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public Integer getRandom() {
        return data.get(random.nextInt(data.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomInConstantTime i = new InsertDeleteGetRandomInConstantTime();
        i.insert(1);
        i.insert(10);
        i.remove(10);
        i.insert(20);
        i.insert(30);
        i.insert(40);
        i.insert(50);
        i.remove(20);
        System.out.println(i.getRandom());
        System.out.println(i.getRandom());
        System.out.println(i.getRandom());
        System.out.println(i.getRandom());
        System.out.println(i.getRandom());
    }
}