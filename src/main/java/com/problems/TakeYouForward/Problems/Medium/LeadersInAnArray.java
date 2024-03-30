package com.problems.TakeYouForward.Problems.Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//find peak element
public class LeadersInAnArray {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,2};

        int[] arr2 = {5,4,3};

        peakElement(arr1);
    }

    private static void peakElement(int[] arr) {

        int n = arr.length;

        int i = 0;

        int max_so_far = Integer.MIN_VALUE;

        List<Integer> list = new ArrayList<>();

        for (int j = n-1; j >= 0 ; j--) {
            if (arr[j] > max_so_far) {
                list.add(arr[j]);
                max_so_far = arr[j];
            }
        }

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int ele = it.next();
            System.out.println(ele);
        }

    }
}
