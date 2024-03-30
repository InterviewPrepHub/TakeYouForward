package com.problems.TakeYouForward.BinarySearch.Hard;

/*
https://www.youtube.com/watch?v=86QI1psaMV4
 */
public class KthMissingPositiveNumber {

    public static void main(String[] args) {

//        int[] arr = {2,3,4,7,11};
//        int k = 4;

        int[] arr = {4, 7, 9, 10};
        int k = 4;

        findMissingNumber(arr,k);

    }

    private static void findMissingNumber(int[] arr, int k) {

        int left = 0;
        int right = arr.length-1;

        while (left <= right) {

            int mid = left + (right-left)/2;

            //calculate no of  missing numbers between arr[0]  to arr[mid]
            int missing_num_count = arr[mid] - mid - 1;

            if (missing_num_count >=k) {
                //kth missing number is in left
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        //left = 4, right = 3
        int missing_number = right + k + 1;
        System.out.println(missing_number);
    }
}
