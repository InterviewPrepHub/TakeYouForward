package com.problems.TakeYouForward.Heap.Easy;

import java.util.PriorityQueue;

public class KthLargestElementInArr {

    public static void main(String[] args) {

        int[] nums = {3, 1, 4, 2, 5};
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        System.out.println(pq.peek());

    }
}
