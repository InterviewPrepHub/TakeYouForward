package com.problems.TakeYouForward.TusharRoy.DP;

public class BinaryStringsNoConsecutiveOnes {

    public static void main(String[] args) {

        countBinaryStrings(3);
    }

    private static int countBinaryStrings(int n) {

        if (n <= 0) return 0;
        if (n == 1) return 2; // Only "0" and "1"

        int[] dp0 = new int[n + 1]; // Ending with '0'
        int[] dp1 = new int[n + 1]; // Ending with '1'

        // Base cases
        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp0[i] = dp0[i-1] + dp1[i-1];
            dp1[i] = dp0[i-1];
        }

        return dp0[n] + dp1[n];
    }
}

/*

n = 2
dp0[2] = dp0[n-1] + dp1[n-1] = 1+1=2
dp1[2] = dp0[n-1] = 1
total = dp0[2]+dp1[2] = 3
 */
