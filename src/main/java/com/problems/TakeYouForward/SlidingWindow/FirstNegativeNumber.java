package com.problems.TakeYouForward.SlidingWindow;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FirstNegativeNumber {

    public static void main(String[] args) {
        int[] arr = {-5, 1, 2, -6, 9};
        int k = 3;

        firstNegNum(arr,k);
    }

    private static void firstNegNum(int[] arr, int k) {

        Queue<Integer> queue = new LinkedList<>();

        int window_start = 0;

        for (int window_end = 0; window_end < arr.length; window_end++) {
            if(arr[window_end] < 0) {
                queue.add(arr[window_end]);
            }

            if (window_end-window_start+1 == k) {
                if(!queue.isEmpty()) {
                    int num = queue.peek();
                    System.out.println(num);

                    if(num == arr[window_start]) {
                        queue.remove();
                    }
                } else {
                    System.out.println(0);
                }
                window_start++;
            }


        }

    }
}
