package com.problems.TakeYouForward.TusharRoy.DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {4,6,1,3,8,4,6};

        maxSum(arr);
    }

    private static void maxSum(int[] arr) {

        int n = arr.length;

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = arr[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    int sum = input[j]+arr[i];
                    if (input[i] < sum) {
                        input[i] = sum;
                    }
                }

            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(input[i]+" ");
        }
    }
}
