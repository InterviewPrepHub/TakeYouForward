package com.problems.TakeYouForward.TwoPointers;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
//        int[] arr = {1, 1, 1, 3, 5, 5, 7};

        int[] arr = {0,0,1,1,1,2,2,3,3,4};

        int n = arr.length;
        int j = 0;

        for (int i = 0; i < n; i++) {

            if (i<n-1 && arr[i] == arr[i+1]) {
                continue;
            }

            arr[j++] = arr[i];
        }

        for (int k = 0; k < j; k++) {
            System.out.println(arr[k]);
        }

    }
}
