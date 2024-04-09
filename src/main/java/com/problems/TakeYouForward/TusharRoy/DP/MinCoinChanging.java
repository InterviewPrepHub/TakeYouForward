package com.problems.TakeYouForward.TusharRoy.DP;

public class MinCoinChanging {

    public static void main(String[] args) {
        int[] coins = {1,5,6,8};
        int total = 11;

        minCoinChange(coins, total);
    }

    private static void minCoinChange(int[] coins, int total) {

        int[][] T = new int[coins.length+1][total+1];

        for (int i = 0; i <= coins.length; i++) {
            T[i][0] = 0;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= total+1; j++) {
                if(j >= coins[i]) {
                    T[i][j] = Math.min(T[i-1][j], 1 + T[i][j-coins[i]]);
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }

        System.out.println(T[coins.length][total]);
    }
}
