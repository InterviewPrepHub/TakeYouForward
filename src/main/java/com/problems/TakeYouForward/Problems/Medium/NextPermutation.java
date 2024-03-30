package com.problems.TakeYouForward.Problems.Medium;


import com.problems.TakeYouForward.Utils.PrintArray;
import com.problems.TakeYouForward.Utils.Swap;

import java.util.Arrays;

/*
ex1: 1,2,4,1
1. traverse the array from back and find the break point
2. breakpoint where arr[i] < arr[i+1]
3. swap the two indices

 */
public class NextPermutation {

    public static void main(String[] args) {
        
        int[] arr1 = {1,2,3,2,3};
        int[] arr2 = {1,2,3,4};
        int[] arr3 = {4,3,2,1};
        int[] arr4 = {1,2,4,1};

        PrintArray.print(arr4);
        
        nextPerm(arr4);
    }

    private static void nextPerm(int[] arr) {

        int n = arr.length;

        for (int i = n-2; i >= 0; i--) {

            if(i == 0) {
                if(arr[i] > arr[i+1]) {
                    //the arr is in desc order
//                    Arrays.sort(arr);
                    Swap.swap(arr, n-2, n-1);
                    break;
                } else {

                }
            } else {
                if(arr[i] < arr[i+1]) {
                    Swap.swap(arr, i,i+1);
                    //sort arr from index i+1
                    Arrays.sort(arr, i+1, n);
                    break;
                }
            }
        }

        System.out.println();
        System.out.print("Next permutation : ");
        PrintArray.print(arr);
    }

}
