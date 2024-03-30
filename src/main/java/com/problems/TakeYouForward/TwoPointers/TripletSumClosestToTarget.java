package com.problems.TakeYouForward.TwoPointers;

public class TripletSumClosestToTarget {

    public static void main(String[] args) {

//        int[] nums = {1, 0, 5, 0, 3};
//        int target = 100;

        int[] nums = {-2, -4, 6, 3, 7};
        int target = 2;

        int res = sumClosestToTarget(nums, target);
        System.out.println(res);

    }

    private static int sumClosestToTarget(int[] nums, int target) {

        int n = nums.length;
        int smallestDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int first = nums[i];

            int left = i+1;
            int right = n-1;

            while(left < right) {

                int currSum = Math.abs(first+nums[left]+nums[right]);

                if(currSum == target) {
                    return currSum;
                }

                if (currSum < target) {
                    left++;
                } else {
                    right--;
                }

                int currDiff = Math.abs(target - currSum);

                if (smallestDiff > currDiff) {
                    smallestDiff = currDiff;
                }
            }
        }
        return (target - smallestDiff);
    }
}
