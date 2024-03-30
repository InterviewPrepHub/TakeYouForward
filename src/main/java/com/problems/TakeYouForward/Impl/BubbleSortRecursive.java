package com.problems.TakeYouForward.Impl;

import com.problems.TakeYouForward.Utils.PrintArray;
import com.problems.TakeYouForward.Utils.Swap;

public class BubbleSortRecursive {

    public static void main(String[] args) {
        int[] arr={7,2,1,6,8,5,3,4};
        sort(arr, arr.length);
        PrintArray.print(arr);
    }
    
    public static void sort(int[] arr, int n) {

        if (n == 1) {
            return;
        }

        for (int i = 0; i < n-1; i++) {

            if(arr[i] > arr[i+1]) {
                Swap.swap(arr, i, i+1);
            }
        }

        sort(arr, n-1);
    }

}
