package com.problems.TakeYouForward.Arrays.Problems.Hard;

import java.util.HashMap;
import java.util.Map;

/*
You are given an array of ‘N’ integers where each integer value is between ‘1’ and ‘N’.
Each integer appears exactly once except for ‘P’, which appears exactly twice, and ‘Q’, which is missing.
Your task is to find ‘P’ and ‘Q’ and return them respectively.

 */
public class FindRepeatingAndMissingNumbers {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,2};

        int[] arr = {1,2,1};
//        1 2 3 2
//        1 2 3 4

        int n = arr.length;
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < n; i++) {

            if(i+1 == arr[i]) {
                map.put(arr[i],i+1);
            } else {
                if(map.containsKey(arr[i])) {
                    System.out.println("missing number : "+ (i+1));
                    System.out.println("repeating number : "+arr[i]);
                }
            }

        }

    }
}
