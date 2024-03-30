package com.problems.TakeYouForward.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class MinSizeSubArraySum {

    public static void main(String[] args) {

        int[] a = {2, 1, 4, 3, 2, 5};
        int k = 7;

//        Output: 2
//        Explanation: The smallest subarray with a sum greater than or equal to '7' is [4, 3]

        smallestSubarray(a,k);

    }

    private static void smallestSubarray(int[] a, int k) {

        int window_start = 0;
        int window_sum = 0;
        int min_len = Integer.MAX_VALUE;

        for (int window_end = 0; window_end < a.length; window_end++) {
            window_sum += a[window_end];

            if(window_sum >= k) {
                min_len = Math.min(min_len, window_end-window_start);
                window_sum = window_sum - a[window_start];
                window_start++;
            }
        }

        System.out.println(min_len);
    }
}
