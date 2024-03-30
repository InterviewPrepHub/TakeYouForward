package com.problems.TakeYouForward.BinarySearch.Easy;

/*
Given a 0-indexed integer array nums, find a peak element, and return its index.
If the array contains multiple peaks, return the index to any of the peaks.

 */
public class PeakElement {

    public static void main(String[] args) {

//        int[] arr = {1,2,3,1};
        int[] arr =  {1,4,3,6,7,5};
        findPeakElement(arr);
    }

    private static void findPeakElement(int[] arr) {

        int left = 0;
        int right = arr.length-1;

        while(left<=right) {
            int mid = left + (right-left)/2;

            if((mid==0 || arr[mid]>=arr[mid-1]) && (mid==arr.length-1 || arr[mid] >= arr[mid+1])) {
                System.out.println("peak element : "+arr[mid]);
                break;
            }

            if(mid>0 && arr[mid-1] > arr[mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
    }
}
