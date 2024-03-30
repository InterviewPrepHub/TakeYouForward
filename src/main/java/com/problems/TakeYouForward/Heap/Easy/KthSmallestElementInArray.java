package com.problems.TakeYouForward.Heap.Easy;

import java.util.PriorityQueue;

public class KthSmallestElementInArray {

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 5};
        int k = 2;
        int n = nums.length;

        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a,b) -> b.compareTo(a));
        for (int i = 0; i < nums.length; i++) {
            max_heap.add(nums[i]);

            if(max_heap.size() > k) {
                max_heap.poll();
            }
        }

        System.out.println(max_heap.peek());
    }
}
