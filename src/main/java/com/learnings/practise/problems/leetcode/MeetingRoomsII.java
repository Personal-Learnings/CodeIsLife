package com.learnings.practise.problems.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;

        //Sort Based on Start Time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        //Add the current Ongoing Meeting
        Queue<Integer> ongoingQueue = new PriorityQueue<>(intervals.length);

        for (int[] interval : intervals) {
            int startTime = interval[0], endTime = interval[1];

            if (!ongoingQueue.isEmpty() && startTime >= ongoingQueue.peek()) {
                ongoingQueue.poll();
            }
            ongoingQueue.offer(endTime);
        }
        return ongoingQueue.size();
    }

    public static void main(String[] args) {
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{{1, 5}, {8, 9}, {8, 9}}));
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{}));
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{{5, 8}, {6, 8}}));
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{{5, 8}, {5, 8}}));
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{{9, 10}, {4, 9}, {4, 17}}));
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{{6, 15}, {13, 20}, {6,17}}));
    }
}