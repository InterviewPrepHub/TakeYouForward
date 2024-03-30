package com.problems.TakeYouForward.Heap.Easy;

import java.util.PriorityQueue;

/*
Given an array of N elements, where each element is at most K away from its target position,
devise an algorithm that sorts in O(N log K) time.


 */
public class SortKSortedArray {

    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 8, 10, 9}, K = 3;

        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        int n = arr.length;
        int[] num = new int[n];
        int j = 0;
        int i;
        for (i = 0; i < n; i++) {
            min_heap.add(arr[i]);

            if(min_heap.size() > K) {
                num[j] = min_heap.poll();
                j++;
            }
        }

        while(!min_heap.isEmpty() && j < n) {
            num[j] = min_heap.poll();
            j++;
        }

        for (int k = 0; k < n; k++) {
            System.out.println(num[k]);
        }

    }
}
