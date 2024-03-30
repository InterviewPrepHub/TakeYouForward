package com.problems.TakeYouForward.SlidingWindow;

import java.util.PriorityQueue;

public class MaxOfAllSubArraysOfSizeK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;

        maxInEachSubArr(arr,k);
    }

    private static void maxInEachSubArr(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b.compareTo(a));
        
        int window_start = 0;

        for (int window_end = 0; window_end < arr.length; window_end++) {
            pq.add(arr[window_end]);

            if(window_end - window_start + 1 == k) {
                int num = pq.peek();
                System.out.println(num);

                if (num == arr[window_start]) {
                    pq.remove();
                }

                window_start++;
            }
        }
    }
}
