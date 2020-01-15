package com.learnings.practise.problems.leetcode.amazon.oa;

import java.util.*;

public class ReorderDataInLogFiles {

    //Time Complexity: O(NLogN*C) Where N is the number of logs and C is the characters in the logs (Assuming new Java Substring would take O(N) Time)
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return new String[]{};

        Map<String, String> letterLogs = new TreeMap<>();
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
        List<String> outputLogs = new ArrayList<>(letterLogs.values());
        outputLogs.addAll(digitLogs);

        return outputLogs.toArray(new String[logs.length]);
    }

    public String[] reorderLogFiles_1(String[] logs) {
        if(logs == null || logs.length == 0) return new String[]{};

        Arrays.sort(logs, (a, b) -> {
            if(null != a && null != b) {
                String aIdentifier = a.substring(0, a.indexOf(" ")).trim();
                String aLog = a.substring(a.indexOf(" ")).trim();
                char aLogKey = aLog.substring(0, !aLog.contains(" ") ? aLog.length() : aLog.indexOf(" ")).trim().charAt(0);

                String bIdentifier = b.substring(0, b.indexOf(" ")).trim();
                String bLog = b.substring(b.indexOf(" ")).trim();
                char bLogKey = bLog.substring(0, !bLog.contains(" ") ? bLog.length() : bLog.indexOf(" ")).trim().charAt(0);

                if(Character.isDigit(aLogKey) && Character.isDigit(bLogKey)) {
                    return 0;
                } else if(Character.isLetter(aLogKey) && Character.isDigit(bLogKey)) {
                    return -1;
                } else if(Character.isDigit(aLogKey) && Character.isLetter(bLogKey)) {
                    return 1;
                } else if(aLog.equals(bLog)) {
                    return aIdentifier.compareTo(bIdentifier);
                } else {
                    return aLog.compareTo(bLog);
                }
            }
            return 0;
        });
        return logs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ReorderDataInLogFiles().reorderLogFiles(
                new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}
        )));
        System.out.println(Arrays.toString(new ReorderDataInLogFiles().reorderLogFiles(
                new String[] {"1 n u", "r 527", "j 893", "6 14", "6 82"}
        )));
        System.out.println(Arrays.toString(new ReorderDataInLogFiles().reorderLogFiles(
                new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"}
        )));
    }
}