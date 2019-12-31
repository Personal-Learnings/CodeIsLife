package com.learnings.practise.problems.leetcode;

import java.util.Stack;

public class LongestAbsoluteFilePath {

    // Time Complexity: O(input.split("\n"))
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int maxLength = 0;

        for(String s : input.split("\n")) {

            //Level would start from 0 so adding +1 to tab index, when tab is not found it returns -1
            int level = s.lastIndexOf("\t") + 1;

            //This is done to get the maximum length of that string for that level
            while(level < stack.size() - 1) stack.pop();

            //stack.peek will give the last string length for that level + current string length - level (remove tabs) +1 for slash
            int length = stack.peek() + s.length() - level + 1;

            //dir will not have \t in the front
            if(level == 0) --length;

            //when string contains . then we have arrived to the file level so compare the current length and new length and take whatever is maximum
            if(s.contains(".")) maxLength = Math.max(length, maxLength);

            //push the new length to stack
            else stack.push(length);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestAbsoluteFilePath().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(new LongestAbsoluteFilePath().lengthLongestPath("a/aa/aaa/file1.txt\naaaaaaaaaaaaaaaaaaaaa/sth.png"));
        System.out.println(new LongestAbsoluteFilePath().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}