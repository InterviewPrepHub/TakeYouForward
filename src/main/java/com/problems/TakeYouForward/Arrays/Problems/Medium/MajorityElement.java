package com.problems.TakeYouForward.Arrays.Problems.Medium;

public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 3, 1, 1, 3, 1, 1};

        findMajorityElement(arr);
    }

    private static void findMajorityElement(int[] arr) {

        int candidate = 0;
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            if(count == 0) {
                candidate = arr[i];
                count++;
            } else {
                if (candidate == arr[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(candidate == arr[i]) {
                count++;
            }
        }

        System.out.println("majority element : "+candidate);
    }
}
