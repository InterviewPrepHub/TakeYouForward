package com.problems.TakeYouForward.Problems.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target = 14;

        findTwoSumUsingHashing(arr, target);

        findTwoSumUsingTwoPointer(arr, target);
    }

    private static void findTwoSumUsingTwoPointer(int[] arr, int target) {

        Arrays.sort(arr);   //2,5,6,8,11

        int left = 0, right = arr.length-1;

        while(left < right) {

            if(arr[left]+ arr[right] == target) {
                System.out.println(arr[left]+" "+arr[right]);
                break;
            }

            if(arr[left] + arr[right] > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    private static void findTwoSumUsingHashing(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int res = Math.abs(k - arr[i]);

            if(map.containsKey(res)) {
                System.out.println(res + " " + arr[i]);
            } else {
                map.put(arr[i], res);
            }
        }
    }
}
