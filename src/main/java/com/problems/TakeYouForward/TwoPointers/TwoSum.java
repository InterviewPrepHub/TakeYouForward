package com.problems.TakeYouForward.TwoPointers;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15}; int target = 9;

        twoSum(nums, target);
    }

    private static void twoSum(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            if(nums[left]+nums[right] == target) {
                System.out.println(left+","+right);
                break;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
