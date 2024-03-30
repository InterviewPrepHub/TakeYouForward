package com.problems.TakeYouForward.TwoPointers;

/*
Given a sorted array, remove the duplicates from the array in-place such that each element appears at most twice, and return the new length.
 */
public class RemoveDuplicateFromSortedArrII {

    public static void main(String[] args) {

        int[] arr = {0,0,1,1,1,2,2,3,3,3,4};
        int n = arr.length;

        int j = 0;

        for (int i = 0; i < n; i++) {

            if(i < n-2 && arr[i] == arr[i+2]) {
                continue;
            }

            arr[j] = arr[i];
            j++;
        }

        for (int k = 0; k < j; k++) {
            System.out.println(arr[k]);
        }

    }
}
