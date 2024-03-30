package com.problems.TakeYouForward.BinarySearch.Easy;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {3, 4, 6, 7, 9, 12, 16, 17} ;
        int k = 6;

        findBinarySearch(arr, k);
    }

    private static void findBinarySearch(int[] arr, int k) {

        int start = 0, end = arr.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] == k) {
                System.out.println(mid);
                break;
            }

            if (arr[mid] > k) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
    }
}
