package com.problems.TakeYouForward.Problems.Hard;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWith0Sum {  // Also Longest sub-array having sum k

    public static void main(String[] args) {

//        int[] arr1 = {10, 5, 2, 7, 1, 9};
//        int k1 = 15;

        int[] arr = {1,-1,0,0,1};
        int k = 0;

        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max_len = 0;

        for (int i = 0; i < n; i++) {

            sum = sum + arr[i];

            if(sum == k) {
                max_len = i+1;
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum-k)) {
                if (max_len < (i-map.get(sum-k))) {
                    max_len = i - map.get(sum - k);
                }
            }
        }

        System.out.println(max_len);

    }
}
