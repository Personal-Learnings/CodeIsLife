package com.learnings.practise.problems.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class ReorderDataInLogFiles {

    public String[] reorderLogFiles_BigO_N(String[] logs) {

        TreeMap<String, String> letterLogs = new TreeMap<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String identifier = log.substring(0, log.indexOf(" "));
            String restOfString = log.substring(log.indexOf(" ")).trim();
            boolean isDigitLog = Character.isDigit(restOfString.charAt(0));

            if (isDigitLog) {
                digitLogs.add(log);
            } else {
                letterLogs.put(restOfString + identifier, log);
            }
        }

        List<String> outputLogs = new ArrayList<>();

        letterLogs.forEach((key, value) -> outputLogs.add(value));

        outputLogs.addAll(digitLogs);
        return outputLogs.toArray(new String[0]);
    }

}
