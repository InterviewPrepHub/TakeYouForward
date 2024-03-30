package com.problems.TakeYouForward.TwoPointers;

import java.util.Arrays;

public class SmallestDiffPair {

    public static void main(String[] args) {
        int[] num1 = {1, 3, 15, 11, 2};
        int[] num2 = {23, 127, 235, 19, 8};

        smallestDiffPair(num1, num2);
    }

    private static void smallestDiffPair(int[] num1, int[] num2) {

        Arrays.sort(num1);
        Arrays.sort(num2);

        int i = 0, j = 0;

        int smallestDiff = Integer.MAX_VALUE;

        while (i <= num1.length-1 && j <= num2.length-1) {
            int currdiff = Math.abs(num1[i] - num2[j]);

            if(smallestDiff > currdiff) {
                smallestDiff = currdiff;
            }

            if (num1[i] < num2[j]) {
                i++;
            } else {
                j++;
            }

        }

        System.out.println(smallestDiff);


    }
}
