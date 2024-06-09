package com.problems.TakeYouForward.TusharRoy.DP;

/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented
by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1
goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10

 */
public class BallonBurst {

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int len = 0; len < dp.length; len++) {
            for (int i = 0, j = len; j < dp.length; i++, j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int lc = k == i ? 0 : dp[i][k-1];
                    int rc = k == j ? 0 : dp[k+1][j];
                    int mc = nums[k];
                    if(i > 0) {
                        mc *= nums[i-1];
                    }
                    if(j != nums.length-1) {
                        mc *= nums[j+1];
                    }
                    int tc = lc + rc + mc;
                    if(max < tc) {
                        max = tc;
                    }
                }
                dp[i][j] = max;

            }
        }
        return dp[0][dp.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        int res = maxCoins(nums);
        System.out.println(res);
    }
}
