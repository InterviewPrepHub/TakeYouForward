package com.problems.TakeYouForward.Arrays.Problems.Medium;

import com.problems.TakeYouForward.Utils.PrintArray;
import com.problems.TakeYouForward.Utils.Swap;

public class Sort0s1s2s {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};

        sort(arr);
        PrintArray.print(arr);
    }

    private static void sort(int[] arr) {

        int low = 0, mid = 0, high = arr.length-1;

        for (int i = 0; i < arr.length; i++) {

            if(arr[mid] == 0) {
                Swap.swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                Swap.swap(arr, mid, high);
                high--;
            }

        }
    }
}
