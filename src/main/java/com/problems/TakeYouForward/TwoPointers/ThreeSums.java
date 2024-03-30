package com.problems.TakeYouForward.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {

    public static void main(String[] args) {
//        int[] nums = {7, 12, 3, 1, 2, -6, 5, -8, 6};
        int[] nums = {-5, 3, 2, -3, 1};
        int target = 0;
        
        threeSum(nums, target);
    }

    private static void threeSum(int[] nums, int target) {

        List<Integer[]> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];

            int left  = i+1;
            int right = nums.length-1;

            while (left <= right) {
                if (first + nums[left] + nums[right] == target) {
//                    System.out.println(i+", "+left+", "+right);
                    Integer[] integers = new Integer[3];
                    integers[0] = nums[i];
                    integers[1] = nums[left];
                    integers[2] = nums[right];
                    list.add(integers);
                    left++;
                    right--;
                } else if (first + nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left ++;
                }
            }
        }

        for (Integer[] intArr : list) {
            System.out.println(intArr[0]+", "+intArr[1]+", "+intArr[2]);
        }
    }
}
