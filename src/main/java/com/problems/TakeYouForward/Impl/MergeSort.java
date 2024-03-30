package com.problems.TakeYouForward.Impl;

import com.problems.TakeYouForward.Utils.PrintArray;

public class MergeSort {
    
    public void sort(int[] arr) {
        
        if(arr.length <=1) {
            return; //already sorted
        }
        
        //find mid
        int mid = arr.length / 2;
        
        //create left and right arr
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        
        //fill the arrays
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < arr.length; i++) {
            right[i-mid] = arr[i]; 
        }
        
        //sort each array
        sort(left);
        sort(right);
        
        //merge both left and right arrays into single arr
        merge(left, right, arr);
        
    }
    
    public void merge(int[] left, int[] right, int[] arr) {
        
        int n = left.length;
        int m = right.length;
        
        int i=0, j = 0, k = 0;

        while(i < n && j < m) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        //add remaining left elements
        while(i<n) {
            arr[k] = left[i];
            i++;
            k++;
        }

        //add remaining right elements
        while(j<n) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] arr={4,2,1,6,7};
        MergeSort m = new MergeSort();
        System.out.println("Before");
        PrintArray.print(arr);
        m.sort(arr);
        System.out.println("After");
        PrintArray.print(arr);
    }
}
