package com.problems.TakeYouForward.SlidingWindow;

/*
To obtain the longest contiguous subarray of 1s, you can flip the 0s to 1s:

 */
public class LongestSubstringWithOnesAfterReplacement {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        longestSubstring(arr, k);
    }

    private static void longestSubstring(int[] arr, int k) {

        int window_start = 0;
        int max_len = Integer.MIN_VALUE;
        int count = 0;

        for (int window_end = 0; window_end < arr.length; window_end++) {

            if (arr[window_end] == 0) {
                count++;
            }

            while (count>k) {
                if (arr[window_start] == 0) {
                    count--;
                }
                window_start++;
            }

            max_len = Math.max(max_len, window_end-window_start+1);
        }

        System.out.println(max_len);
    }
}
