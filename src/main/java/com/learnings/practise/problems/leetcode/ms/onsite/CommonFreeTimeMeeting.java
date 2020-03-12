package com.learnings.practise.problems.leetcode.ms.onsite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CommonFreeTimeMeeting {

    private List<Schedule> getCommonFreeTime(List<Schedule> schedules) {
        TreeMap<Integer, Schedule> scheduleMap = new TreeMap<>();
        populateSchedulesMap(schedules, scheduleMap);
        return getFreeTimes(scheduleMap);
    }

    private List<Schedule> getFreeTimes(TreeMap<Integer, Schedule> scheduleMap) {
        List<Schedule> freeTimes = new ArrayList<>();
        Map.Entry<Integer, Schedule> currentEntry = scheduleMap.firstEntry();

        while(currentEntry != null) {
            Schedule currentSchedule = currentEntry.getValue();
            Map.Entry<Integer, Schedule> nextEntry = scheduleMap.higherEntry(currentSchedule.endTime);

            if(nextEntry != null) {
                Schedule nextSchedule = nextEntry.getValue();
                if (nextSchedule.startTime > currentSchedule.endTime) {
                    freeTimes.add(new Schedule(currentSchedule.endTime, nextSchedule.startTime));
                }
            }
            currentEntry = nextEntry;
        }

        return freeTimes;
    }

    private void populateSchedulesMap(List<Schedule> schedules, TreeMap<Integer, Schedule> schedulesMap) {
        for(Schedule schedule : schedules) {
            if(schedulesMap.containsKey(schedule.startTime)) {
                Schedule existing = schedulesMap.get(schedule.startTime);
                if(schedule.endTime > existing.endTime) {
                    schedulesMap.put(schedule.startTime, schedule);
                }
            }
            else schedulesMap.put(schedule.startTime, schedule);
        }
    }

    public static void main(String[] args) {
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule(8, 9));
        schedules.add(new Schedule(11, 12));
        schedules.add(new Schedule(13, 14));
        schedules.add(new Schedule(8, 10));
        schedules.add(new Schedule(12, 13));
        schedules.add(new Schedule(13, 15));

        System.out.println(new CommonFreeTimeMeeting().getCommonFreeTime(schedules));
    }

    static class Schedule {
        int startTime;
        int endTime;

        Schedule(int start, int end) {
            startTime = start;
            endTime = end;
        }

        @Override
        public String toString() {
            return "{ startTime=" + startTime + ", endTime=" + endTime + " }";
        }
    }
}
