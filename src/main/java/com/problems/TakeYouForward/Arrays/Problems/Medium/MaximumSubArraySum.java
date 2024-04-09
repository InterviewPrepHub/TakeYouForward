package com.problems.TakeYouForward.Arrays.Problems.Medium;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        
        maxSumSubArray(arr);

        printMaxSumSubArray(arr);
    }

    private static void printMaxSumSubArray(int[] arr) {

        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int start = 0, end = 0, s = 0;

        for (int i = 0; i < arr.length; i++) {

            max_ending_here = max_ending_here + arr[i];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = s+1;
            }
        }

        System.out.println("start : "+start+" end : "+end);

        for (int i = start; i <= end ; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void maxSumSubArray(int[] arr) {
        
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int i = 0; i < arr.length; i++) {

            max_ending_here = max_ending_here + arr[i];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }

        System.out.println(max_so_far);
    }
}
