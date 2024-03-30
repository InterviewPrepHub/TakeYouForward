package com.problems.TakeYouForward.SlidingWindow;

public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 7};
        int k = 2;
        
        maxSumSubarray(arr,k);
    }

    private static int maxSumSubarray(int[] arr, int k) {

        int window_start = 0;
        int window_sum = 0;
        int max_sum = Integer.MIN_VALUE;

        for (int window_end = 0; window_end < arr.length; window_end++) {
            window_sum += arr[window_end];

            if (window_end-window_start+1==k) {
                max_sum = Math.max(max_sum, window_sum);
                window_sum = window_sum - window_start;
                window_start++;
            }
        }
        return max_sum;
    }
}
