package com.problems.TakeYouForward.Arrays.Problems.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] arr = {5,8,3,2,1,4};
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        int max_len = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        //check if the current element is the starting element
        for (int i = 0; i < n; i++) {

            if(!map.containsKey(arr[i]-1)) {
                int j = arr[i];

                while (map.containsKey(j)) {
                    j++;
                }

                if (max_len < j-arr[i]) {
                    max_len = j-arr[i];
                }
            }
        }
        System.out.println(max_len);
    }
}
