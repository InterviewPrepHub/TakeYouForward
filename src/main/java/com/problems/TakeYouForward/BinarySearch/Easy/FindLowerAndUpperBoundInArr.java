package com.problems.TakeYouForward.BinarySearch.Easy;

public class FindLowerAndUpperBoundInArr {

    public static void main(String[] args) {
        int[] arr = {2,9,13,53,89,90,98};
        int k = 98;

        //lower bound - smallest index i such that arr[i] > k;

        int start = 0, end = arr.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] == k) {
                System.out.println("lower bound:"+arr[mid]);

                if(mid+1< arr.length) {
                    System.out.println("upper bound:"+arr[mid+1]);
                } else {
                    System.out.println("no upper bound");
                }
                break;
            } else if (arr[mid] > k) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
    }
}
