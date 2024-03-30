package com.problems.TakeYouForward.BinarySearch.Hard;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
//        int[] arr1 = {1,2};
//        int[] arr2 = {3,4};

        int[] arr1 = {1,3,6};
        int[] arr2 = {2,8,12};

        double res = findMedian(arr1, arr2,0,arr1.length-1,0,arr2.length-1);
        System.out.println(res);
    }

    private static double findMedian(int[] A, int[] B, int startIndexA, int endIndexA, int startIndexB, int endIndexB) {

        if((endIndexA-startIndexA ==1) && (endIndexB-startIndexB==1)) {
            return 1.0 * ((Math.max(A[startIndexA], B[startIndexB])) + (Math.min(A[endIndexA], B[endIndexB])))/2;
        }

        int m1_Index = (endIndexA-startIndexA)/2;
        int m2_Index = (endIndexB-startIndexB)/2;

        int m1 = A[m1_Index];
        int m2 = B[m2_Index];

        if(m1 == m2) {
            return (double) m1;
        }

        if (m1 < m2) {
            startIndexA = m1_Index;
            endIndexB = m2_Index;
        }

        if (m1 > m2) {
            startIndexB = m2_Index;
            endIndexA = m1_Index;
        }

        return findMedian(A, B, startIndexA, endIndexA, startIndexB, endIndexB);
    }
}
