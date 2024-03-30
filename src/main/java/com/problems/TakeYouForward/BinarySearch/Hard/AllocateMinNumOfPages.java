package com.problems.TakeYouForward.BinarySearch.Hard;

public class AllocateMinNumOfPages {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int m = 2; // Number of students
        int n = arr.length; // Number of books
        int result = allocateBooks(arr, n, m);
        System.out.println("The minimum number of pages allocated to a student: " + result);

    }

    private static int allocateBooks(int[] arr, int n, int m) {
        
        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            right += arr[i];
        }

        int result = 0;

        while (left <= right) {

            int mid = left + (right-left)/2;

            if (isPossible(arr, mid, m)) {
                result = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] arr, int mid, int m) {

        int minStudents = 1;
        int pagesAllocated = 0;

        for (int i = 0; i < arr.length; i++) {

            if(pagesAllocated + arr[i] > mid) {
                minStudents++;
                pagesAllocated = arr[i];
                if (minStudents > m) {
                    return false;
                }
            } else {
                pagesAllocated += arr[i];
            }
        }
        return true;
    }

}
