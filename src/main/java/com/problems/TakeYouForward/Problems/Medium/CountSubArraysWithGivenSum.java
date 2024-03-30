package com.problems.TakeYouForward.Problems.Medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithGivenSum {

    public static void main(String[] args) {

//        int[] arr = {3, 2, 1, 4};
//        int k = 6;
//        System.out.println("Number of subarrays with sum " + k + ": " + findSubarraySum(arr, arr.length, k)); // Output: 2

        int arr[] = { 10, 2, -2, -20, 10 };
        int sum = -10;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));

    }

    static int findSubarraySum(int arr[], int n, int sum)
    {
        // HashMap to store number of subarrays starting from index zero having
        // particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0,1);
        int res = 0;
        int currSum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currSum += arr[i];
            //calculate the sum that have to be removed
            //so that we can get the desired sum

            int removeSum=currSum-sum;

            //get count of occurrences of that sum that
            //have to removed and add it to res value
            if (prevSum.containsKey(removeSum))
                res += prevSum.get(removeSum);

            // Add currsum value to count of
            // different values of sum.
            prevSum.put(currSum,prevSum.getOrDefault(currSum,0)+1);
        }

        return res;
    }


    private static int countSubArraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0,1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            int res = (prefixSum-k);

            if (prefixSumFreq.containsKey(res)) {
                count += prefixSumFreq.get(res);
            }

            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0)+1);
        }

        return count;
    }
}
