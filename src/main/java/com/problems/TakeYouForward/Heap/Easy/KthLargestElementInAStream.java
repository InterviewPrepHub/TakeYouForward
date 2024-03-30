package com.problems.TakeYouForward.Heap.Easy;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    public static void main(String[] args) {
        add(10);
        add(15);
        add(3);
        System.out.println(get(2));
        add(11);
        System.out.println(get(3));
    }


    static PriorityQueue<Integer> min_heap = new PriorityQueue<>();

    private static void add(int data) {
        min_heap.add(data);
    }

    private static int get(int k) {

        if (min_heap.size()>k) {
            min_heap.poll();
        }
        return min_heap.peek();
    }
}
