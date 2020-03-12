package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeSortedArray {

    public void merge_twoPointer(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while ((p1 >= 0) && (p2 >= 0)) {
            if(nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        //When all the elements from nums2 are lesser than num1 we have to copy those elements back to nums1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /**
     * Time Complexity: O((m+n) log (m+n))
     * Space Complexity: O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * Time Complexity: O((m+n) log (m+n))
     * Space Complexity: O((m+n) log (m+n))
     */
    public void merge_queue(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < m; i++) queue.offer(nums1[i]);
        for(int i = 0; i < n; i++) queue.offer(nums2[i]);

        int i = 0;
        while(!queue.isEmpty()) {
            nums1[i] = queue.poll();
            ++i;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        int [] nums1 = new int[] {1,2,3,0,0,0};
        int [] nums2 = new int[] {2,5,6};
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[] {1,2,3,0,0,0};
        nums2 = new int[] {2,5,6};
        mergeSortedArray.merge_queue(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[] {1,2,3,0,0,0};
        nums2 = new int[] {2,5,6};
        mergeSortedArray.merge_twoPointer(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[] {2,2,3,5,7,0,0,0};
        nums2 = new int[] {1,1,1};
        mergeSortedArray.merge_twoPointer(nums1, 5, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
