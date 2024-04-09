package com.problems.TakeYouForward.Sorting.Impl;

import com.problems.TakeYouForward.Utils.PrintArray;
import com.problems.TakeYouForward.Utils.Swap;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr={7,2,1,6,8,5,3,4};
        sort(arr, 0, arr.length-1);
        PrintArray.print(arr);

    }

    public static void sort(int[] arr, int start, int end) {

        if (start < end) {
            int pIndex = partition(arr, start, end);
            sort(arr, start, pIndex-1);
            sort(arr, pIndex+1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int pIndex = start - 1;

        for (int i = start; i < end; i++) {
            if(arr[i] < pivot) {
                pIndex++;
                Swap.swap(arr, i, pIndex);
            }
        }

        Swap.swap(arr, pIndex+1, end);
        return pIndex+1;
    }

}
