package com.problems.TakeYouForward.TusharRoy.DP;

public class RodCutting {

    public static void main(String[] args) {
        //cutting rod to max profit
        int len = 5;
        int[] prices = {2,5,7,8};

        int[][] T = new int[prices.length + 1][len + 1];

        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= len; j++) {
                if(i <= j) {
                    T[i][j] = Math.max(T[i - 1][j], T[i][j - i] + prices[i - 1]);
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }
        System.out.println(T[prices.length][len]);
    }
}
