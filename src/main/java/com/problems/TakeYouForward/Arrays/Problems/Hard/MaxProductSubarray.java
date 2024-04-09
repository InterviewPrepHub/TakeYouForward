package com.problems.TakeYouForward.Arrays.Problems.Hard;

public class MaxProductSubarray {

    public static void main(String[] args) {
       int[] arr = {-2, 3, -4, 0};
       int n = arr.length;

       int max_ending_here = 1;
       int max_so_far = Integer.MIN_VALUE;

        for (int i = 1; i < n-1; i++) {
            max_ending_here = max_ending_here * arr[i];

            max_so_far = Math.max(max_so_far, max_ending_here);

            if (max_ending_here == 0) {
                max_ending_here = 1;
            }

        }


        max_ending_here = 1;

        for (int i = n-1; i >=0 ; i--) {
            max_ending_here *= arr[i];

            max_so_far = Math.max(max_so_far, max_ending_here);

            if (max_ending_here == 0) {
                max_ending_here = 1;
            }
        }

        System.out.println("max product subarray: "+max_so_far);
    }
}
