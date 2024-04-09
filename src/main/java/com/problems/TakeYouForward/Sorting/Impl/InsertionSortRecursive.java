package com.problems.TakeYouForward.Sorting.Impl;

import com.problems.TakeYouForward.Utils.PrintArray;

/*
Time complexity = O(n^2)
 */
public class InsertionSortRecursive {

    public static void main(String[] args) {
        int[] arr={7,2,1,6,8,5,3,4};
        sort(arr);
        PrintArray.print(arr);

        System.out.println();

        int[] arr1={7,2,1,6,8,5,3,4};
        sortRecursive(arr1, arr1.length);
        PrintArray.print(arr);
    }

    private static void sortRecursive(int[] arr, int n) {

        if(n <= 1) {
            return;
        }

        sortRecursive(arr, n-1);

        int key = arr[n-1];

        int j = n-2;

        while (j >=0 && arr[j] > key) {
            arr[j+1] = arr[j];
            j--;
        }

        arr[j+1] = key;
    }

    private static void sort(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {   // i = 1

            int key = arr[i];   // key = 2

            int j = i-1;        // j = 0

            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }

            //insert key to its correct position
            arr[j+1] = key;
        }
    }
}
